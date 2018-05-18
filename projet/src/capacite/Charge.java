package capacite;

import cartes.Serviteur;
/**
 * Permet à un serviteur d'attaquer dès sa mise en jeu
 * @author JHIDRI GILLOT
 */

public class Charge extends AttaqueCible {

	public Charge() {
		super("Charge",0);
	}
	
	/**
	 * Confère Charge à la cible à la mise en jeu de la carte
	 * @param cible : cible à qui attribuer Charge
	 */
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		
		if (cible instanceof Serviteur)
			((Serviteur) cible).setJouable(true);
		
	}
	/**
	 * Confère Charge à la cible à la demande du joueur ( Pouvoir Héros )
	 * @param cible : cible à qui attribuer Charge
	 */
	@Override
	public void executerAction(Object cible) {
		if (cible instanceof Serviteur)
			((Serviteur) cible).setJouable(true);
	}
	/**
	 * Pas d'effet pour Charge en début de tour
	 */
	@Override
	public void executerEffetDebutTour() {
		//nothing
		
	}
	/**
	 * Pas d'effet pour Charge à la disparition de la carte
	 */
	@Override
	public void executerEffetDisparition(Object cible) {
		//nothing
		
	}
	/**
	 * Pas d'effet pour Charge en fin de tour
	 */
	@Override
	public void executerEffetFinTour() {
		//nothing
		
	}
	@Override
	public String toString() {
		return "Capacite [nom=Charge, description=vise un serviteur en attente et il peut attaquer tout de suite]";
	}

}
