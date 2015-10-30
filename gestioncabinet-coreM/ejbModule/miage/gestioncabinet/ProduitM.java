/**
 * 
 */
package miage.gestioncabinet;

import miage.gestioncabinet.api.*;

/**
 * Interface décrivant une spécialité médicamenteuse
 * @author sraybaud - MIAGE
 *
 */
public class ProduitM implements Produit {
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
