package player;

import java.util.ArrayList;


import cartes.*;

/**
 * Interface : base d'un joueur pour le jeu
 * @author JHIDRI GILLOT
 * @see Joueur
 */
public interface Ijoueur {
	
	/**
	 * Maximum de mana qu'un joureur peut avoir durant la partie
	 */
	final int MAX_MANA = 10;
	/**
	 * Maximum de carte qu'un joureur peut avoir dans son deck
	 */	
	final int TAILLE_DECK= 15;

	/**
	 * Met fin au tour du joueur	
	 */
	void finirTour();
	
	/**
	 * Retourne la carte demandée présente dans le jeu du joueur
	 * @param nomCarte : nom de la carte
	 */
	Icarte getCarteEnJeu(String nomCarte) ;
	
	/**
	 * Retourne la carte demandée présente dans la main du joueur
	 * @param nomCarte : nom de la carte
	 */
	Icarte getCarteEnMain(String nomCarte) ;
	
	/**
	 * Donne le héros du joueur
	 */
	Hero getHero();
	
	/**
	 * Donne la liste des cartes dans le jeu du joueur
	 */
	ArrayList<Icarte> getJeu();
	
	/**
	 * Donne la liste des cartes dans la main du joueur
	 */
	ArrayList<Icarte> getMain();
	
	/**
	 * Donne le mana total du joueur pour le tour actuel
	 */
	int getMana();
	
	/**
	 * Donne le mana restant du joueur pour le tour actuel
	 */
	int getStockMana();
	
	/**
	 * Donne le pseudo du joueur
	 */
	String getPseudo();
	
	/**
	 * Retire une carte de la main, la place sur le jeu et lance sa capacité
	 * @param carte : carte à jouer
	 * @param cible : cible pour la capacité ( si EffetMiseEnJeu )
	 */
	void jouerCarte(Icarte carte,Object cible);
	
	/**
	 * Retire une carte de la main, la place sur le jeu 
	 * @param carte : carte à jouer
	 */
	void jouerCarte(Icarte carte);
	
	/**
	 * Retire la carte du jeu du joueur
	 * @param carte : carte à retirer
	 */
	void perdreCarte(Icarte carte);
	
	/**
	 * Retire une carte de la pioche et la place dans la main du joueur
	 */
	void piocher();
	
	/**
	 * Démarre le tour du joueur, pioche une carte, augmente de 1 le mana total ( si < MAX_MANA ) et lance l' EffetDebutTour
	 * de la capacité de chaque serviteur en jeu
	 */
	void prendreTour();
	
	/**
	 * Utilise une carte en jeu
	 * @param carte : carte à utiliser
	 * @param cible : cible à attaquer
	 */
	void utiliserCarte(Icarte carte ,Object cible);
	
	/**
	 * Utilise le pouvoir du héros
	 * @param cible : cible du pouvoir
	 */
	void utiliserPouvoir(Object cible);

}