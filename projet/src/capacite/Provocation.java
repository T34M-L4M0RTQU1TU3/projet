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


}
