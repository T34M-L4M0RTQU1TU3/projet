package capacite;

import exceptions.CibleNullException;
import exceptions.HeartStoneException;

/**
 * Interface : Interface des différentes capacités nécéssaires pour le jeu
 * 
 * @author JHIDRI GILLOT
 * @see capacite.Capacite
 */
public interface Icapacite {

	/**
	 * Effet à la demande du joueur
	 * 
	 * @param cible
	 *            : cible à attaquer
	 * @throws HeartStoneException
	 *             : par ex attaque d'un serviteur alors qu'un autre serviteur a
	 *             Provocation
	 * @throws CibleNullException
	 *             : en cas de cible nulle
	 */
	void executerAction(Object cible) throws HeartStoneException;

	/**
	 * Effet en début de tour
	 */
	void executerEffetDebutTour();

	/**
	 * Effet à la disparition de la carte
	 * 
	 * @param cible
	 *            : cible à attaquer
	 */
	void executerEffetDisparition(Object cible)  throws HeartStoneException;

	/**
	 * Effet lors de la mise en jeu de la carte
	 * 
	 * @param cible
	 *            : cible à attaquer
	 * @throws HeartStoneException
	 *             : par ex attaque d'un serviteur alors qu'un autre serviteur a
	 *             Provocation
	 * @throws CibleNullException
	 *             : en cas de cible nulle
	 */
	void executerEffetMiseEnJeu(Object cible) throws HeartStoneException, CibleNullException;

	/**
	 * Effet en fin de tour
	 */
	void executerEffetFinTour();

	/**
	 * Donne la description de la capacité
	 */
	String getDescription();

	/**
	 * Donne le nom de la capacité
	 */
	String getNom();

}