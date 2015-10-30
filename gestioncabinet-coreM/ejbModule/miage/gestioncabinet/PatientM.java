/**
 * 
 */
package miage.gestioncabinet;

import java.util.Calendar;

import javax.persistence.Entity;

import miage.gestioncabinet.api.*;

/**
 * Interface décrivant un patient
 * @author sraybaud - MIAGE
 *
 */
@Entity
public class PatientM extends PersonneM implements Patient {

	@Override
	public Calendar getDateNaissance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDateNaissance(Calendar dateNaissance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getAge() {
		// TODO Auto-generated method stub
		return null;
	}
}
