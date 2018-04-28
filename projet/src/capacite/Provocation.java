package capacite;

import cartes.Serviteur;

public class Provocation extends Capacite {

	public Provocation() {
		super("Provocation","Les attaques n'atteindront pas votre Héros");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		if (!(cible instanceof Serviteur))
				throw new  IllegalArgumentException("pas possible de metre cette capacité a cette cible");
			((Serviteur) cible).setCapacite(new Provocation());
		
	}

	@Override
	public void executerAction(Object cible) {
		if (!(cible instanceof Serviteur))
			throw new  IllegalArgumentException("pas possible de metre cette capacité a cette cible");
		((Serviteur) cible).setCapacite(new Provocation());
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
