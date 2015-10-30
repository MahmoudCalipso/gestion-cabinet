/**
 * 
 */
package miage.gestioncabinet;

import java.util.Calendar;
import java.util.List;

/**
 * Interface distante du service de gestion du planning
 * @author sraybaud - MIAGE
 *
 */
public interface PlanningRemoteService{
	/**
	 * Retourne l'utilisateur authentifié
	 */
	public UtilisateurM getUtilisateur();
	
	/**
	 * Retourne la liste des médecins du cabinet
	 * @return la liste des médecins
	 */
	public List<MedecinM> rechercherMedecins() throws GestionCabinetException;
	
	/**
	 * Recherche un patient par un mot clé
	 * @param keyword le mot clé
	 * @return la liste des patients correspondants
	 */
	public List<PatientM> rechercherPatients(String nom, String prenom, Calendar dateNaissance) throws GestionCabinetException;

	
	/**
	 * Retourne la date de début de période des rendez-vous du médecin courant
	 * @return la date correspondante
	 */
	public Calendar getDateDebut();
	
	/**
	 * Modifie la date de début de période des rendez-vous du médecin courant
	 * @param date la date à modifier
	 */
	public void setDateDebut(Calendar date);
	
	/**
	 * Retourne la date de fin de période des rendez-vous du médecin courant
	 * @return la date correspondante
	 */
	public Calendar getDateFin();
	
	/**
	 * Modifie la date de fin de période des rendez-vous du médecin courant
	 * @param date la date à modifier
	 */
	public void setDateFin(Calendar date);

	/**
	 * Retourne le médecin courant
	 * @return le médecin correspondant
	 */
	public MedecinM getMedecin();
	
	/**
	 * Modifie le médecin courant
	 * @param medecin le médecin à modifier
	 */
	public void setMedecin(MedecinM medecin);
	
	/**
	 * Liste les rendez-vous du médecin courant sur la période correspondante
	 * @return la liste des consultations correspondantes
	 */
	public List<ConsultationM> listerRdv();
	
	/**
	 * Retourne le rendez-vous de consultation courant
	 * @return le rendez-vous correspondant
	 */
	public ConsultationM getRdvCourant();
	
	/**
	 * Modifie le rendez-vous de consultation courante
	 * @param rdv le rendez-vous à sélectionner
	 */
	public void setRdvCourant(ConsultationM rdv);
	
	/**
	 * Crée un nouveau rendez-vous de consultation
	 * @param date la date du rendez-vous
	 * @return la consultation créée
	 */
	public ConsultationM creerRdv(Calendar date);
	
	/**
	 * Sauvegarde le rendez-vous de consultation courant
	 * @return le rendez-vous après avoir été sauvegardé
	 */
	public ConsultationM enregistrerRdv() throws GestionCabinetException;
	
	/**
	 * Supprime le rendez-vous de consultation courant
	 */
	public void supprimerRdv() throws GestionCabinetException;	
	
}
