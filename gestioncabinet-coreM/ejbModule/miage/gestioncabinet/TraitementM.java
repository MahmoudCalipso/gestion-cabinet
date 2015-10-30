/**
 * 
 */
package miage.gestioncabinet;

import miage.gestioncabinet.api.*;

/**
 * Interface décrivant une prescription médicamenteuse
 * @author sraybaud - MIAGE
 *
 */
public class TraitementM implements Traitement {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Produit produit;
	private String posologie;

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;		
	}

	public String getPosologie() {
		return posologie;
	}

	public void setPosologie(String posologie) {
		this.posologie = posologie;
	}

}
