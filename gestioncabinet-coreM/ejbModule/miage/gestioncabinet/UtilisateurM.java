/**
 * 
 */
package miage.gestioncabinet;

import javax.persistence.Entity;

import miage.gestioncabinet.api.*;

/**
 * Interface décrivant un utilisateur, c'est-à-dire une personne utilisatrice de
 * l'application
 * 
 * @author sraybaud - MIAGE
 *
 */
@Entity
public class UtilisateurM extends PersonneM implements Utilisateur {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String compte;
	private String motdepasse;

	public String getCompte() {
		return compte;
	}
}
