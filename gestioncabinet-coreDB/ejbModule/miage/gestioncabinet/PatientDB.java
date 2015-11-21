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
public class PatientDB extends PersonneDB implements Patient {
	
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
