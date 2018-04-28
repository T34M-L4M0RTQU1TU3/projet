package capacite;

import cartes.Serviteur;

public class Provocation extends Capacite {

	public Provocation() {
		super("Provocation","Les attaques n'atteindront pas votre Héros");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		if (cible instanceof Serviteur)
			((Serviteur) cible).setCapacite(new Provocation());
		
	}

	@Override
	public void executerAction(Object cible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDebutTour() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDisparition(Object cible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetFinTour() {
		// TODO Auto-generated method stub
		
	}


}
