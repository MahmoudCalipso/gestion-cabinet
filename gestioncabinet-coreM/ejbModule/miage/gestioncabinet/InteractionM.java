/**
 * 
 */
package miage.gestioncabinet;

import javax.persistence.Entity;

import miage.gestioncabinet.api.*;

/**
 * Interface décrivant une interaction médicamenteuse
 * @author sraybaud - MIAGE
 *
 */
@Entity
public class InteractionM implements Interaction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String severite;
	private String risques;
	private String precautions;
	private Produit produitA;
	private Produit produitB;

	public Produit getProduitA() {
		return produitA;
	}

	public void setProduitA(Produit produit) {
		this.produitA = produit;
	}

	public Produit getProduitB() {
		return produitB;
	}

	public void setProduitB(Produit produit) {
		this.produitB = produit;
	}

	public String getSeverite() {
		return severite;
	}

	public void setSeverite(String severite) {
		this.severite = severite;
	}

	public String getRisques() {
		return risques;
	}

	public void setRisques(String risques) {
		this.risques = risques;
		
	}

	public String getPrecautions() {
		return precautions;
	}

	public void setPrecautions(String precautions) {
		this.precautions = precautions;
	}	
}
