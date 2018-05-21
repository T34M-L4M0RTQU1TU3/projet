package IHM;


public class Quitter extends Interaction {

	public Quitter(Interaction suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(String choix) {
		if(getDescription().equals(choix))
			return true;
		return false;
	}

	@Override
	public void executerInteraction(Object o ) {
		System.exit(0);
	}

	@Override
	public String getDescription() {
		return "Quitter";
	}

}
