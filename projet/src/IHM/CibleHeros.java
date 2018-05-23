package IHM;

import player.Joueur;
import player.Plateau;
import application.application;
import cartes.Carte;
import exceptions.HeartStoneException;
/**
 * @author Gillot,Jhidri
 * la classe CibleHeros correspont au choix dans le sousMenu qui permet de cibler le Hero adverse 
 */
public class CibleHeros extends Interaction {

	public CibleHeros(Interaction suivant) {
		super(suivant);
	}

	/**
	 * attaque Le hero 
	 * @throws HeartStoneException :
	 * 								le pouvoir du hero est déjà utiliser,le serviteur a déjà attaquer une fois dans le tour courant , ou le héros a un serviteur qui a provocation							
	 */

	@Override
	public void executerInteraction(Object o) throws HeartStoneException  {
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
	/**
	 * @return renvoi la description 
	 */

	@Override
	public String getDescription() {
		return "Cibler le Heros";
	}

}