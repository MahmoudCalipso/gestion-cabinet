/**
 * 
 */
package miage.gestioncabinet;

import java.util.Calendar;
import java.util.List;

import miage.gestioncabinet.api.*;

/**
 * Interface décrivant une consultation médicale
 * @author sraybaud - MIAGE
 *
 */
public class ConsultationM implements Consultation {

	public int compareTo(Consultation arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Patient getPatient() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPatient(Patient patient) {
		// TODO Auto-generated method stub
		
	}

	public Medecin getMedecin() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setMedecin(Medecin medecin) {
		// TODO Auto-generated method stub
		
	}

	public Calendar getDebut() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDebut(Calendar date) {
		// TODO Auto-generated method stub
		
	}

	public Calendar getFin() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFin(Calendar date) {
		// TODO Auto-generated method stub
		
	}

	public String getCompteRendu() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCompteRendu(String texte) {
		// TODO Auto-generated method stub
		
	}

	public List<Traitement> getPrescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean ajouterTraitement(Produit produit) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean supprimerTraitement(Traitement medicament) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Interaction> getInteractions() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setInteractions(List<Interaction> interactions) {
		// TODO Auto-generated method stub
		
	}
	
}