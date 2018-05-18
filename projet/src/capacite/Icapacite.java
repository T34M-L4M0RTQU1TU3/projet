package capacite;

/**
 * Interface : Interface des différentes capacités nécéssaires pour le jeu
 * @author JHIDRI GILLOT
 * @see Capacite 
 */
public interface Icapacite {	
	
	/**
	 * Effet à la demande du joueur  
	 * @param cible : cible à attaquer
	 */
	void executerAction(Object cible );
 
	/**
	 * Effet en début de tour
	 */
	void executerEffetDebutTour();
 
	/**
	 * Effet à la disparition de la carte
	 * @param cible : cible à attaquer
	 */
	void executerEffetDisparition(Object cible );
 
	/**
	 * Effet lors de la mise en jeu de la carte 
	 * @param cible : cible à attaquer
	 */
	void executerEffetMiseEnJeu(Object cible );
 	
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