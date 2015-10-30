/**
 * 
 */
package miage.gestioncabinet;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;

import miage.gestioncabinet.api.*;
import miage.gestioncabinet.api.PlanningRemoteService;

/**
 * Interface distante du service de gestion d'une consultation
 * @author sraybaud - MIAGE
 *
 */
@Stateful
@Remote(ConsultationRemoteService.class)
public class ConsultationService implements ConsultationRemoteService{

	public Consultation getConsultation() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setConsultation(Consultation consultation) {
		// TODO Auto-generated method stub
		
	}

	public List<Produit> rechercherMedicament(String keyword) throws GestionCabinetException {
		// TODO Auto-generated method stub
		return null;
	}

	public void analyserPrescription() throws GestionCabinetException {
		// TODO Auto-generated method stub
		
	}

	public Consultation enregistrer() throws GestionCabinetException {
		// TODO Auto-generated method stub
		return null;
	}

	public void supprimer() throws GestionCabinetException {
		// TODO Auto-generated method stub
		
	}
	
}
