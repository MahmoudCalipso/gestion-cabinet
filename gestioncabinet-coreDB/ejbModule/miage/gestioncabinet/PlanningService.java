package miage.gestioncabinet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import miage.gestioncabinet.api.Consultation;
import miage.gestioncabinet.api.GestionCabinetException;
import miage.gestioncabinet.api.Medecin;
import miage.gestioncabinet.api.Patient;
import miage.gestioncabinet.api.PlanningRemoteService;
import miage.gestioncabinet.api.Utilisateur;

/**
 * EJB PlanningService
 * 
 * @author Vincent
 *
 */
@Stateful
@Remote(PlanningRemoteService.class)
public class PlanningService implements PlanningRemoteService {
	private Utilisateur utilisateur;
	private Calendar dateDebut;
	private Calendar dateFin;
	private Medecin medecin;
	private Consultation rdvCourant;

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Init
	 * 
	 * @throws ParseException
	 */
	@PostConstruct
	private void initialiser() {
		
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public List<Medecin> rechercherMedecins() throws GestionCabinetException {
		
		List<Medecin> medecins = new ArrayList<Medecin>();
		
		Query query = em.createNamedQuery(MedecinDB.QUERY_RECHERCHER_MEDECIN);
		medecins = query.getResultList();
		
		return medecins;
	}

	public List<Patient> rechercherPatients(String nom, String prenom, Calendar dateNaissance)
			throws GestionCabinetException {
		
		List<Patient> patients = new ArrayList<Patient>();

		Query query = em.createNamedQuery(PatientDB.QUERY_TROUVER_PATIENT_PAR_NOM);
		query.setParameter("nomPatient", nom);
		patients = query.getResultList();
		
		return patients;
	}

	public Calendar getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Calendar date) {
		this.dateDebut = date;
	}

	public Calendar getDateFin() {
		return dateFin;
	}

	public void setDateFin(Calendar date) {
		this.dateFin = date;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public List<Consultation> listerRdv() {
		List<Consultation> rdvs = new ArrayList<Consultation>();

		Query query = em.createNamedQuery(ConsultationDB.QUERY_LISTER_RDV_PAR_MEDECIN);
		query.setParameter("idMedecin", medecin);
		rdvs = query.getResultList();

		return rdvs;
	}

	public Consultation getRdvCourant() {
		return rdvCourant;
	}

	public void setRdvCourant(Consultation rdv) {
		this.rdvCourant = rdv;
	}

	public Consultation creerRdv(Calendar date) {
		Consultation consultation = new ConsultationDB();
		Calendar dateFin = (Calendar)date.clone();
		dateFin.add(Calendar.MINUTE, 15);
		
		consultation.setDebut(date);
		consultation.setFin(dateFin);
		consultation.setMedecin(medecin);
		consultation.setPatient(new PatientDB());
		
		return consultation;
	}

	public Consultation enregistrerRdv() throws GestionCabinetException {
		
		em.merge(rdvCourant);
		return rdvCourant;
	}

	public void supprimerRdv() throws GestionCabinetException {
		Consultation c = em.contains(rdvCourant) ? rdvCourant : enregistrerRdv();
		em.remove(c);
	}

}
