package IHM;

import application.application;
import exceptions.HeartStoneException;
import player.Chasseur;
import player.Ijoueur;
import player.Joueur;
import player.Plateau;

/**
 * @author Gillot,Jhidri
 * la classe ChoixChasseur correspont au hero que l'utilisateur à choisi
 */
public class ChoixChasseur extends Interaction {

	public ChoixChasseur(Interaction suivant) {
		super(suivant);

	}

	/**
	 * Demande au joueur de saisir un pseudo valide , puis ajouter  un joueur (pseudo,Chasseur) au plateau
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
			
			application.es.print("Joueur "+n+" veuillez choisir votre nom (caractère de [A-Za-z0-9]) :\n-->");
			String nomJoueur1 = application.es.readLine();
			try{
				((Plateau ) o ).ajouterJoueur((Ijoueur) new Joueur(nomJoueur1,new Chasseur()));
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
		
		return "Rexxar";
	}

}
