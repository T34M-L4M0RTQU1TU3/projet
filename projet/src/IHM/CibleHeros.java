package IHM;

import player.Joueur;
import player.Plateau;
import application.application;
import cartes.Carte;
import exceptions.HeartStoneException;

public class CibleHeros extends Interaction {

	public CibleHeros(Interaction suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(String choix) {
		if(getDescription().equals(choix))
			return true;
		return false;
	}

	@Override
	public void executerInteraction(Object o) throws HeartStoneException {
		if( o instanceof Plateau) // utilisation du pouvoir du heros sur le heros adverse
			{
					((Plateau ) o).getJoueurCourant().utiliserPouvoir(((Plateau ) o).getAdversaire(((Plateau ) o).getJoueurCourant())); 
			}
		else if ( o instanceof Carte) // utilisation d'une carte qui cible le hero
			{	
				if( ((Carte ) o).getProprietaire().getJeu().contains(((Carte) o))) // la carte est déjà dans le jeu 
					((Carte) o).executerAction(((Joueur)((Carte) o).getProprietaire()).getPlateau().getAdversaire(((Joueur)((Carte) o).getProprietaire())));
					
				else //la carte est encore dans la main du joueur
					((Carte) o).getProprietaire().jouerCarte(((Carte) o), ((Joueur)((Carte) o).getProprietaire()).getPlateau().getAdversaire( ((Joueur)((Carte) o).getProprietaire())));	
			}
		

	}

	@Override
	public String getDescription() {
		return "Cibler le Heros";
	}

}