package player;

public interface Iplateau {
	
	
	void ajouterJoueur(Ijoueur joueur);
	void demarrerPartie();
	boolean estDermarree();
	void finTour(Ijoueur joueur);
	void gagnePartie(Ijoueur joueur);
	Ijoueur getAdversaire(Ijoueur joueur);
	Ijoueur getJoueurCourant();
	void setJoueurCourant(Ijoueur joueur); 
	
	
	
	

}
