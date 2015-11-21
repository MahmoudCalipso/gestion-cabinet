/**
 * 
 */
package miage.gestioncabinet;

import javax.persistence.*;

import miage.gestioncabinet.api.*;

/**
 * Interface décrivant une prescription médicamenteuse
 * 
 * @author sraybaud - MIAGE
 *
 */
@Entity
@Table(name = "traitements")
public class TraitementDB implements Traitement {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Embedded
	private ProduitDB produit;

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
