/**
 * 
 */
package miage.gestioncabinet;

import javax.persistence.*;

import miage.gestioncabinet.api.*;

/**
 * Interface décrivant un utilisateur, c'est-à-dire une personne utilisatrice de
 * l'application
 * 
 * @author sraybaud - MIAGE
 *
 */
@Entity
@Table(name = "utilisateurs")
public class UtilisateurDB extends PersonneDB implements Utilisateur {
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
