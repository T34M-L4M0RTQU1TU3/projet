package IHM;

import player.Plateau;

public class FinirTour extends Interaction {

	public FinirTour(Interaction suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(String choix) {
		if(getDescription().equals(choix))
			return true;
		return false;
	}

	@Override
	public void executerInteraction(Object o) {
		((Plateau) o).getJoueurCourant().finirTour();
		((Plateau) o).getAdversaire(((Plateau) o).getJoueurCourant()).prendreTour();
		((Plateau) o).toString();
	}

	@Override
	public String getDescription() {
		return "Finir tour";
	}

}
