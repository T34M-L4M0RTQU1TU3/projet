package cartes;

import exceptions.CibleNullException;
import exceptions.HeartStoneException;
import player.Ijoueur;

/**
 * Interfarce : base des différentes cartes nécéssaires au jeu
 * @author JHIDRI GILLOT
 * @see Carte
 */
public interface Icarte {
	
	/**
	 * True si la carte disparaît, false sinon
	 * @return true or false 
	 */
	Boolean disparait();
	
	/**
	 * L'effet de la carte lorsqu'elle est utilisée par le joueur
	 * @param cible : cible affectée par l'effet
	 */
	void executerAction(Object cible)throws HeartStoneException;
	
	/**
	 * Lance l'effet de mise en jeu de la capacité de la carte
	 * @param cible : cible affectée par l'effet
	 */
	void executerEffetDebutMiseEnJeu(Object cible) throws HeartStoneException;
	
	/**
	 * Lance l'effet dedébut de tour de la capacité de la carte
	 * @param cible : cible affectée par l'effet
	 */
	void executerEffetDebutTour(Object cible);
	
	/**
	 * Lance l'effet de disparition de la capacité de la carte
	 * @param cible : cible affectée par l'effet
	 */
	void executerEffetDisparition(Object cible)throws HeartStoneException;
	
	/**
	 * Lance l'effet de fin de tour de la capacité de la carte
	 * @param cible : cible affectée par l'effet
	 */
	void executerEffetFinTour(Object cible);
	
	/**
	 * Donne le cout de la carte
	 */
	int getCout();
	
	/**
	 * Donne le nom de la carte
	 */
	String getNom();
	
	/**
	 * Donne le propriétaire de la carte
	 */
	Ijoueur getProprietaire();
}