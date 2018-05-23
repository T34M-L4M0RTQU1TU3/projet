package IHM;

import application.application;
import cartes.Carte;
import exceptions.HeartStoneException;
import player.Joueur;
import player.Plateau;
/**
 * @author Gillot,Jhidri
 * la classe CibleHeros correspont au choix dans le sousMenu qui permet de cibler le Hero adverse 
 */
public class CibleServiteur extends Interaction {

	public CibleServiteur(Interaction suivant) {
		super(suivant);
	}

	/**
	 * execute l'action demander sur le serviteur cible
	 * @throws HeartStoneException : 
	 * 								la carte jouer est introuvable,la carte cibler est introuvable
	 */

	@Override
	public void executerInteraction(Object o) throws HeartStoneException {
		application.es.print("saisissez le nom du serviteur à attaquer");		
		String nomCarte = application.es.readLine();
		if( o instanceof Plateau) // utilisation du pouvoir du heros sur un serviteur 
		{	
			Carte cible = (Carte) ((Plateau) o).getAdversaire(((Plateau) o).getJoueurCourant()).getCarteEnJeu(nomCarte);	
			((Plateau) o).getJoueurCourant().utiliserPouvoir(cible);
		}	
		else if ( o instanceof Carte) // utilisation d'une carte qui cible un serviteur
		{	
			Carte cible = (Carte) ((Joueur) ((Carte) o).getProprietaire()).getPlateau().getAdversaire(((Joueur) ((Carte) o).getProprietaire())).getCarteEnJeu(nomCarte);

			if( ((Carte ) o).getProprietaire().getJeu().contains(((Carte) o))) // la carte est déjà dans le jeu 
				((Carte) o).executerAction(cible);
				
			else //la carte est encore dans la main du joueur
				((Carte) o).getProprietaire().jouerCarte(((Carte) o), cible);	
		}
		

	}

	/**
	 * @return renvoi la description
	 */
	@Override
	public String getDescription() {
		return "Cibler un serviteur";
	}

}