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
	private List<Medecin> medecins;
	private List<Patient> patients;
	private List<Produit> produits;

	private ProductService ps;
	private InteractionService is;

	@PostConstruct
	public void initialiser() {
		Medecin m1 = new MedecinM();
		m1.setNom("Greene");
		m1.setPrenom("Mark");

		Medecin m2 = new MedecinM();
		m2.setNom("Doctor");
		m2.setPrenom("Who");

		this.medecins.add(m1);
		this.medecins.add(m2);
	}

	public ConsultationService() {
		super();
		this.consultations = new ArrayList<Consultation>();
		this.medecins = new ArrayList<Medecin>();
		this.patients = new ArrayList<Patient>();
		this.produits = new ArrayList<Produit>();

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
		List<Produit> listProduit = new ArrayList<Produit>();

		fr.vidal.webservices.productservice.ArrayOfProduct ap = ps.searchByNameAndType(keyword, ProductType.VIDAL);

		for (fr.vidal.webservices.productservice.Product p1 : ap.getProduct()) {
			Produit p2 = new ProduitM();
			p2.setNom(p1.getName());
			p2.setCis(p1.getCis());

			listProduit.add(p2);
		}

		return listProduit;
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
			Interaction interaction = new InteractionM();

			Produit pA = new ProduitM();
			pA.setCis(ic.getProductA().getCis());
			pA.setNom(ic.getProductA().getName());
			Produit pB = new ProduitM();
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
		this.consultations.add(this.consultation);
		return this.consultation;
	}

	public void supprimer() throws GestionCabinetException {
		for (int i = 0; i < consultations.size(); ++i) {
			if (consultations.get(i).equals(this.consultation)) {
				consultations.remove(i);
			}
		}
	}
}
