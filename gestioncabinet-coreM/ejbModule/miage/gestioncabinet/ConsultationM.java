/**
 * 
 */
package miage.gestioncabinet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;

import miage.gestioncabinet.api.*;

/**
 * Interface décrivant une consultation médicale
 * 
 * @author sraybaud - MIAGE
 *
 */
@Entity
public class ConsultationM implements Consultation {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Calendar dateDebut;
	private Calendar dateFin;
	private String compteRendu;
	private Medecin medecin;
	private Patient patient;
	private List<Traitement> prescriptions;
	private List<Interaction> interactions;

	public ConsultationM() {
		super();

		medecin = new MedecinM();
		patient = new PatientM();

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
		Traitement t = new TraitementM();
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