package capacite;

public class AttaqueDuHero extends Attaque {

	public AttaqueDuHero(String nom, int degats) {
		super(nom,"inflige "+degats+" points de dégat au héros adverse", degats);
		
	}

	
	@Override
	public String toString() {
		return "Capacite [nom=" + getNom() + ", description="+getDescription()+"]";
	}

}
