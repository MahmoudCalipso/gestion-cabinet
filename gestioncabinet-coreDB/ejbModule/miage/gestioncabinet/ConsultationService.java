/**
 * 
 */
package miage.gestioncabinet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.vidal.webservices.interactionservice.InteractionCouple;
import fr.vidal.webservices.interactionservice.InteractionService;
import fr.vidal.webservices.interactionservice.InteractionService_Service;
import fr.vidal.webservices.interactionservice.InteractionSeverityType;
import fr.vidal.webservices.productservice.ProductService;
import fr.vidal.webservices.productservice.ProductService_Service;
import fr.vidal.webservices.productservice.ProductType;
import miage.gestioncabinet.api.*;

/**
 * Interface distante du service de gestion d'une consultation
 * 
 * @author sraybaud - MIAGE
 *
 */
@Stateful
@Remote(ConsultationRemoteService.class)
public class ConsultationService implements ConsultationRemoteService {

	private Utilisateur utilisateur;
	private Calendar dateDebut;
	private Calendar dateFin;
	private Medecin medecin;
	private Consultation consultation;

	private List<Consultation> consultations;

	private ProductService ps;
	private InteractionService is;
	
	@PersistenceContext
	private EntityManager em;

	public ConsultationService() {
		super();
		this.consultations = new ArrayList<Consultation>();

		this.ps = new ProductService_Service().getProductServiceHttpPort();
		this.is = new InteractionService_Service().getInteractionServiceHttpPort();
	}

	public Consultation getConsultation() {
		return this.consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	public List<Produit> rechercherMedicament(String keyword) throws GestionCabinetException {
		List<Produit> medicaments = new ArrayList<Produit>();
		
		Query query = em.createNamedQuery(PatientDB.QUERY_TROUVER_PATIENT_PAR_NOM);
		query.setParameter("leNom", "%" + keyword + "%");
		medicaments = query.getResultList();
		
		return medicaments;
	}

	public void analyserPrescription() throws GestionCabinetException {
		Set<Produit> produits = new HashSet<Produit>();
		List<Interaction> interactions = new ArrayList<Interaction>();

		for (Traitement t : this.getConsultation().getPrescription()) {
			if (t.getProduit() != null) {
				produits.add(t.getProduit());
			}
		}

		fr.vidal.webservices.interactionservice.ArrayOfInt ids = new fr.vidal.webservices.interactionservice.ArrayOfInt();
		for (Produit produit : produits) {
			fr.vidal.webservices.productservice.Product product = this.ps.searchByCis(produit.getCis());
			ids.getInt().add(product.getId());
		}

		for (InteractionCouple ic : is
				.getInteractionCouplesForProductIds(ids, InteractionSeverityType.TAKE_INTO_ACCOUNT)
				.getInteractionCoupleList().getInteractionCouple()) {
			Interaction interaction = new InteractionDB();

			Produit pA = new ProduitDB();
			pA.setCis(ic.getProductA().getCis());
			pA.setNom(ic.getProductA().getName());
			Produit pB = new ProduitDB();
			pB.setCis(ic.getProductB().getCis());
			pB.setNom(ic.getProductB().getName());

			interaction.setProduitA(pA);
			interaction.setProduitB(pB);

			interaction.setPrecautions(ic.getPrecautionComment());
			interaction.setRisques(ic.getRiskComment());
			interaction.setSeverite(ic.getSeverity().toString());

			interactions.add(interaction);
		}
		consultation.setInteractions(interactions);
	}

	public Consultation enregistrer() throws GestionCabinetException {
		
		this.em.merge(this.consultation);
		return this.consultation;
	}

	public void supprimer() throws GestionCabinetException {

		Consultation c = em.contains(consultation) ? consultation : enregistrer();		
		em.remove(c);
	}
}
