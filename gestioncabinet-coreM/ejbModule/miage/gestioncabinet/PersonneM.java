/**
 * 
 */
package miage.gestioncabinet;

import java.io.Serializable;

import javax.persistence.Entity;

import miage.gestioncabinet.api.*;

/**
 * Interface décrivant une personne dans l'application
 * @author sraybaud - MIAGE
 *
 */
@Entity
public class PersonneM implements Personne {

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNom() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setNom(String nom) {
		// TODO Auto-generated method stub
		
	}

	public String getPrenom() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPrenom(String prenom) {
		// TODO Auto-generated method stub
		
	}
}
