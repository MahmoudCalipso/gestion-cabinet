/**
 * 
 */
package miage.gestioncabinet;

import javax.persistence.*;

import miage.gestioncabinet.api.*;

/**
 * Interface décrivant une interaction médicamenteuse
 * @author sraybaud - MIAGE
 *
 */
@Entity
@Table(name="interactions")
public class InteractionDB implements Interaction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String severite;
	private String risques;
	private String precautions;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="cis", column=@Column(name="produitA_cis")),
		@AttributeOverride(name="nom", column=@Column(name="produitA_nom"))
	})
	private Produit produitA;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="cis", column=@Column(name="produitB_cis")),
		@AttributeOverride(name="nom", column=@Column(name="produitB_nom"))
	})
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
