package capacite;

public class AttaqueDuHero extends Attaque {

	public AttaqueDuHero(String nom, int degats) {
		super(nom, degats);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "Capacite [nom=" + getNom() + ", description=inflige "+getDegats()+" points de dégât au héros]";
	}

}
