package miage.gestioncabinet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateful;

import miage.gestioncabinet.api.Consultation;
import miage.gestioncabinet.api.GestionCabinetException;
import miage.gestioncabinet.api.Medecin;
import miage.gestioncabinet.api.Patient;
import miage.gestioncabinet.api.PlanningRemoteService;
import miage.gestioncabinet.api.Utilisateur;

/**
 * EJB PlanningService
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
	private List<Medecin> medecins;
	private List<Patient> patients;
	private List<Consultation> consultations;

	/**
	 * Init
	 * @throws ParseException
	 */
	@PostConstruct
	private void initialiser() {
		this.medecins = new ArrayList<Medecin>();
		this.patients = new ArrayList<Patient>();
		this.consultations = new ArrayList<Consultation>();
		
		Medecin m = new MedecinM();
		m.setNom("Doctor");
		m.setPrenom("Who");
		this.medecins.add(m);
		
		setDateDebut(Calendar.getInstance());
		Calendar fin = getDateDebut();
		fin.add(Calendar.HOUR, 4);
		setDateFin(fin);
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public List<Medecin> rechercherMedecins() throws GestionCabinetException {
		return medecins;
	}

	public List<Patient> rechercherPatients(String nom, String prenom, Calendar dateNaissance)
			throws GestionCabinetException {
		List<Patient> retour = new ArrayList<Patient>();
		
		for(Patient p : patients) {
			if(p.getNom().equals(nom) && p.getPrenom().equals(prenom) && p.getDateNaissance().equals(dateNaissance)) {
				retour.add(p);
			}
		}
		return retour;
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
		List<Consultation> retour = new ArrayList<Consultation>();
		
		for(Consultation c : this.consultations) {
			if(c.getMedecin().getNom().equals(this.medecin.getNom())) {
				// && c.getDebut().after(this.dateDebut) && c.getFin().before(this.dateFin)) {
				retour.add(c);
			}
		}
		return retour;
	}

	public Consultation getRdvCourant() {
		return rdvCourant;
	}

	public void setRdvCourant(Consultation rdv) {
		this.rdvCourant = rdv;
	}

	public Consultation creerRdv(Calendar date) {
		Consultation rdv = new ConsultationM();
		rdv.setDebut(date);
		rdv.setMedecin(medecin);
		rdv.setPatient(new PatientM());
		return rdv;
	}

	public Consultation enregistrerRdv() throws GestionCabinetException {
		consultations.add(rdvCourant);
		return rdvCourant;
	}

	public void supprimerRdv() throws GestionCabinetException {
		consultations.remove(rdvCourant);
	}
	
}
