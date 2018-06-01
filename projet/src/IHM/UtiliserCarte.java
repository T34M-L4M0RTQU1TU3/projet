package IHM;

import application.application;
import cartes.Carte;
import cartes.Serviteur;
import exceptions.HeartStoneException;
import player.Joueur;
import player.Plateau;
/**
 * @author Gillot,Jhidri
 * la classe UtiliserCarte correspont au choix permettant d'utiliser une carte déjà en Jeu
 */
public class UtiliserCarte extends Interaction {

	public UtiliserCarte(Interaction suivant) {
		super(suivant);
	}

/**
 * demande la carte en Jeu et la joue
 * 	@throws HeartStoneException : 
 * 								carte introuvable , provocation , etat zombie
 */

	@Override
	public void executerInteraction(Object o) throws HeartStoneException {
		application.es.print("saisissez le nom de la carte à jouer :\n--->");		
		String nomCarte = application.es.readLine();
		
		Joueur joueur = (Joueur) ((Plateau ) o ).getJoueurCourant();
		Carte carteAJouer = (Carte) joueur.getCarteEnJeu(nomCarte);
		
		if(!((Serviteur)carteAJouer).isJouable()) {
				throw new HeartStoneException("ce serviteur est en etat Zombie !");
		}
	
		Interaction sousIhm = application.initialiserSousInterface();
		//if souSIHM EST VIDE !
		String choix = application.sousMenu(sousIhm);
		try {
			sousIhm.interagir(choix, carteAJouer);
			}	catch(HeartStoneException e){	
				System.err.printf("%100s\n",e.getMessage());
			}

	}

	/**
	 * @return renvoi la description de la classe
	 */
	@Override
	public String getDescription() {
		return "Utiliser une carte de ton jeu";
	}

}