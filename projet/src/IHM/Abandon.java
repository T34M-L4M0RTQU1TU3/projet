package IHM;

import player.Plateau;
import application.application;
/**
 * @author Gillot , Jhidri
 * la classe Abandon correspont au choix abondonner du Joueur courant , celui-ci déclare forfait
 */
public class Abandon extends Interaction {

	public Abandon(Interaction suivant) {
		super(suivant);
	}


	/**
	 * déclarer forfait 
	 */
	@Override
	public void executerInteraction(Object o ) {
		application.es.print("Etes vous sur de vouloir abondonner?\n--->");
		String reponse = application.es.readLine();
		
		if(reponse.charAt(0)=='o' || reponse.charAt(0)=='O')
			((Plateau) o).gagnePartie(((Plateau) o).getAdversaire(((Plateau) o).getJoueurCourant()));		
	}
	/**
	 * @return renvoi la description du choix
	 */
	@Override
	public String getDescription() {
		return "Abandonner";
	}

}