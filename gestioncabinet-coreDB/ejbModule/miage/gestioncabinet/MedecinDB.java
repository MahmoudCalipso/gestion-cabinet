/**
 * 
 */
package miage.gestioncabinet;

import javax.persistence.*;

import miage.gestioncabinet.api.*;

/**
 * Interface décrivant un médecin
 * 
 * @author sraybaud - MIAGE
 *
 */
@Entity
@DiscriminatorValue("medecin")
public class MedecinDB extends UtilisateurDB implements Medecin {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rpps;

	public String getRPPS() {
		return rpps;
	}
}
