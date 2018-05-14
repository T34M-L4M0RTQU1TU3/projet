package capacite;


public class Provocation extends Capacite {

	public Provocation() {
		super("Provocation","Les attaques n'atteindront pas votre Héros");
		
	}
	
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		//nothing
	}

	@Override
	public void executerAction(Object cible) {
		//nothing
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