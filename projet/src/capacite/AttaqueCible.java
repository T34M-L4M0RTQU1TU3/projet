package capacite;

public class AttaqueCible extends Attaque {

	public AttaqueCible(String nom, int degats) {
		super(nom, degats);
	}
	
	@Override
	public String toString() {
		return "Capacite [nom=" + getNom() + ", description=inflige "+getDegats()+" points de dégât au personnage ciblé]";
	}

}
