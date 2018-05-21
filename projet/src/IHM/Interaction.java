package IHM;

import exceptions.HeartStoneException;
import player.Plateau;

public abstract class Interaction {
	
	private Interaction suivant = null;
	
	public Interaction(Interaction suivant) {
		this.suivant = suivant;
	}
	
	public Interaction getSuivant() {
		return suivant;
	}
	
	public abstract boolean saitInteragir(String choix);
	
	public abstract void executerInteraction(Object o) throws HeartStoneException;
	
	public abstract String getDescription();
	
	public void interagir(String choix,Object o) throws HeartStoneException {
		if(saitInteragir(choix))
			executerInteraction(o);
		else {
			if(suivant != null)
				suivant.interagir(choix, o);				
		}
	}

}
