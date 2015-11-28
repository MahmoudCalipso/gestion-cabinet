/**
 * 
 */
package miage.gestioncabinet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

import miage.gestioncabinet.api.*;

/**
 * Interface décrivant une consultation médicale
 * 
 * @author sraybaud - MIAGE
 *
 */
@Access(AccessType.PROPERTY)
@Entity
@Table(name = "consultations")
@NamedQuery(name=ConsultationDB.QUERY_LISTER_RDV_PAR_MEDECIN, query="SELECT c FROM ConsultationDB c WHERE c.medecin = :idMedecin ")
public class ConsultationDB implements Consultation {
	/**
	 * Requête SQL qui liste les rdv du medecin courant
	 */
	public static final String QUERY_LISTER_RDV_PAR_MEDECIN = "listerRdv";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateDebut;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateFin;

	@Column(name = "compterendu", length = 255)
	private String compteRendu;

	@ManyToOne(targetEntity=MedecinDB.class)
	@JoinColumn(name = "medecin")
	private Medecin medecin;

	@ManyToOne(targetEntity=PatientDB.class)
	@JoinColumn(name = "patient")
	private Patient patient;

	@OneToMany(targetEntity=TraitementDB.class)
	@JoinColumn(name = "id", nullable = false)
	private List<Traitement> prescriptions;

	@OneToMany(targetEntity=InteractionDB.class)
	@JoinColumn(name = "id", nullable = false)
	private List<Interaction> interactions;

	public ConsultationDB() {
		super();

		medecin = new MedecinDB();
		patient = new PatientDB();

		interactions = new ArrayList<Interaction>();
		prescriptions = new ArrayList<Traitement>();

		this.id = Calendar.getInstance().getTimeInMillis();
	}

	public int compareTo(Consultation arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Calendar getDebut() {
		return dateDebut;
	}

	public void setDebut(Calendar date) {
		this.dateDebut = date;
	}

	public Calendar getFin() {
		return dateFin;
	}

	public void setFin(Calendar date) {
		this.dateFin = date;
	}

	public String getCompteRendu() {
		return compteRendu;
	}

	public void setCompteRendu(String texte) {
		this.compteRendu = texte;
	}

	public List<Traitement> getPrescription() {
		return prescriptions;
	}

	public Boolean ajouterTraitement(Produit produit) {
		Traitement t = new TraitementDB();
		t.setProduit(produit);
		if (prescriptions.contains(t)) {
			return false;
		} else {
			prescriptions.add(t);
			return true;
		}
	}

	public Boolean supprimerTraitement(Traitement medicament) {
		if (prescriptions.contains(medicament)) {
			prescriptions.remove(medicament);
			return true;
		} else {
			return false;
		}
	}

	public List<Interaction> getInteractions() {
		return interactions;
	}

	public void setInteractions(List<Interaction> interactions) {
		this.interactions = interactions;
	}

}