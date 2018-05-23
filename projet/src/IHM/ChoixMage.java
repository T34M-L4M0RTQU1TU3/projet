package IHM;

import exceptions.HeartStoneException;
import player.Ijoueur;
import player.Joueur;
import player.Mage;
import player.Plateau;
import application.application;

/**
 * @author Gillot,Jhidri
 * la classe ChoixChasseur correspont au hero que l'utilisateur à choisi
 */
public class ChoixMage extends Interaction {

	public ChoixMage(Interaction suivant) {
		super(suivant);
	}

	/**
	 * Demande au joueur de saisir un pseudo valide , puis ajouter  un joueur (pseudo,Mage) au plateau
	 * @throws HeartStoneException  : 
	 * 								si la création du Joueur a echouer
	 * @throws IllegalArgumentException  :
	 * 								nom du joueur null , vide ou chaines d'espaces
	 */
	@Override
	public void executerInteraction(Object o) throws HeartStoneException {
		int n ;
		n= ( ((Plateau) o).getPlayers().size()==0 )? 1:2;
		while (true) {
			
			application.es.println("Joueur "+n+" veuillez choisir votre nom (caractère de [A-Za-z0-9]) :");
			String nomJoueur1 = application.es.readLine();
			try{
				((Plateau ) o ).ajouterJoueur((Ijoueur) new Joueur(nomJoueur1,new Mage()));
				break;
			}catch(IllegalArgumentException e)
			{}
		}
		
	}
	/**
	 * @return renvoi la description du choix
	 */
	@Override
	public String getDescription() {
		return "Jayna";
	}

}
