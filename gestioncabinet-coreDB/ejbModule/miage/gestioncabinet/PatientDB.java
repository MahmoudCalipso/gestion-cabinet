/**
 * 
 */
package miage.gestioncabinet;

import java.util.Calendar;

import javax.persistence.*;

import miage.gestioncabinet.api.*;

/**
 * Interface décrivant un patient
 * 
 * @author sraybaud - MIAGE
 *
 */
@Entity
@DiscriminatorValue("patient")
@NamedQuery(name=PatientDB.QUERY_TROUVER_PATIENT_PAR_NOM, query="SELECT p FROM PatientDB p WHERE p.nom like :nomPatient")
public class PatientDB extends PersonneDB implements Patient {
	
	/**
	 * Requête pour trouver le patient à partir de son nom
	 */
	public static final String QUERY_TROUVER_PATIENT_PAR_NOM = "rechercherPatients";
	
	private String sexe;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateNaissance;

	public Calendar getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Calendar dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Integer getAge() {
		Calendar maintenant = Calendar.getInstance();
		int age = maintenant.get(Calendar.YEAR) - dateNaissance.get(Calendar.YEAR);
		if ((dateNaissance.get(Calendar.MONTH) > maintenant.get(Calendar.MONTH))
				|| (dateNaissance.get(Calendar.MONTH) == maintenant.get(Calendar.MONTH)
						&& dateNaissance.get(Calendar.DAY_OF_MONTH) > maintenant.get(Calendar.DAY_OF_MONTH))) {
			age--;
		}
		return age;
	}
}
