/**
 * 
 */
package miage.gestioncabinet;

import javax.persistence.*;

import miage.gestioncabinet.api.*;

/**
 * Interface décrivant une spécialité médicamenteuse
 * 
 * @author sraybaud - MIAGE
 *
 */
@Embeddable
@Table(name = "produits")
@NamedQuery(name=ProduitDB.QUERY_RECHERCHER_PRODUIT_PAR_NOM, query="SELECT p FROM Produit p WHERE p.nom LIKE :leNom")
public class ProduitDB implements Produit {
	/**
	 * Requête rechercher produit par nom
	 */
	public static final String QUERY_RECHERCHER_PRODUIT_PAR_NOM = "listerProduits";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cis;
	private String nom;

	public String getCis() {
		return cis;
	}

	public void setCis(String cis) {
		this.cis = cis;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
