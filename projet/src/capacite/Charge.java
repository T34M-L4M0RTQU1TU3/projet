package capacite;

import cartes.Serviteur;

public class Charge extends Capacite {

	public Charge() {
		super("Charge","vise un serviteur en attente et il peut attaquer tout de suite");
	}
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		if (cible instanceof Serviteur)
			((Serviteur) cible).setCapacite(new Charge());
	}
	@Override
	public void executerAction(Object cible) {
		if (cible instanceof Serviteur)
			((Serviteur) cible).setCapacite(new Charge());
	}
	@Override
	public void executerEffetDebutTour() {
		//nothing
		
	}
	@Override
	public void executerEffetDisparition(Object cible) {
		//nothing
		
	}
	@Override
	public void executerEffetFinTour() {
		//nothing
		
	}

}
