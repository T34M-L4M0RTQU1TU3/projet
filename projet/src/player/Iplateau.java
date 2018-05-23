package player;

/**
 * Interface :  Base du plateau re présentant le jeu
 * @author JHIDRI GILLOT
 * @see player.Plateau
 */
public interface Iplateau {
	
	/**
	 * Ajoute un joueur au plateau
	 */
	void ajouterJoueur(Ijoueur joueur);
	
	/**
	 * Lance la partie
	 */
	void demarrerPartie();
	
	/**
	 * true si la partie est lancée, false sinon
	 */
	boolean estDermarree();
	
	/**
	 * Met fin au tour du joueur 
	 * @param joueur : joueur du tour courant
	 */
	void finTour(Ijoueur joueur);
	
	/**
	 * Met fin au jeu avec le joueur gagnant
	 * @param joueur : joueur gagnant
	 */
	void gagnePartie(Ijoueur joueur);
	
	/**
	 * Donne l'adversaire du joueur 
	 * @param joueur : joueur dont on veut l'adversaire
	 */
	Ijoueur getAdversaire(Ijoueur joueur);
	
	/**
	 * Donne le joueur courant
	 */
	Ijoueur getJoueurCourant();
	
	/**
	 * Définit le joueur courant 
	 * @param joueur : joueur courant
	 */
	void setJoueurCourant(Ijoueur joueur); 
	
}