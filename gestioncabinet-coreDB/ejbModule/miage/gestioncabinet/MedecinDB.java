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
@NamedQueries({
	@NamedQuery(name=MedecinDB.QUERY_RECHERCHER_MEDECIN, query="SELECT m FROM MedecinDB m"),
	@NamedQuery(name=MedecinDB.QUERY_RECHERCHER_MEDECIN_PAR_ID, query="SELECT m FROM MedecinDB m WHERE m.id = :idMedecin")
})
public class MedecinDB extends UtilisateurDB implements Medecin {
	/**
	 * Requête rechercher medecins
	 */
	public static final String QUERY_RECHERCHER_MEDECIN = "rechercherMedecins";
	
	/**
	 * Requête rechercher medecin par id
	 */
	public static final String QUERY_RECHERCHER_MEDECIN_PAR_ID = "rechercherMedecinsParId";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String rpps;

	public String getRPPS() {
		return rpps;
	}
}
