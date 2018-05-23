package IHM;


import player.Plateau;
/**
 * @author Gillot,Jhidri
 * la classe FinirTour correspont au choix dans le sousMenu qui permet de passer le tour  
 */
public class FinirTour extends Interaction {

	public FinirTour(Interaction suivant) {
		super(suivant);
	}

/**
 * le joueur passe le tour et son adversaire prend le tour
 */
	@Override
	public void executerInteraction(Object o) {
		((Plateau) o).getJoueurCourant().finirTour();
		((Plateau) o).getJoueurCourant().prendreTour();
	}
	
	/**
	 * @return renvoi la description
	 */
	@Override
	public String getDescription() {
		return "Finir tour";
	}

}