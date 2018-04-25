package cartes;

import player.Ijoueur;

public interface Icarte {
	Boolean disparait();
	void executerAction(Object cible);
	void executerEffetDebutMiseEnJeu(Object cible);
	void executerEffetDebutTour(Object cible);
	void executerEffetDisparition(Object cible);
	void executerEffetFinTour(Object cible);
	int getCout();
	String getNom();
	Ijoueur getProprietaire();
}
