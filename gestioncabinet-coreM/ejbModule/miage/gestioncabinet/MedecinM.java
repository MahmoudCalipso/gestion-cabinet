/**
 * 
 */
package miage.gestioncabinet;

import javax.persistence.Entity;

import miage.gestioncabinet.api.*;

/**
 * Interface décrivant un médecin
 * @author sraybaud - MIAGE
 *
 */
@Entity
public class MedecinM extends UtilisateurM implements Medecin {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rpps;

	public String getRPPS() {
		return rpps;
	}
}
