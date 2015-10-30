/**
 * 
 */
package miage.gestioncabinet;

import javax.persistence.Entity;

import miage.gestioncabinet.api.*;

/**
 * Interface décrivant une personne dans l'application
 * @author sraybaud - MIAGE
 *
 */
@Entity
abstract public class PersonneM implements Personne {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nom;
	private String prenom;

	public Long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
