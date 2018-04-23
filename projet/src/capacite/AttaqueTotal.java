package capacite;

public class AttaqueTotal extends Attaque {

	public AttaqueTotal(String nom, int degats) {
		super(nom, degats);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Capacite [nom=" + getNom() + ", description=inflige "+getDegats()+" points de dégât à tout les serviteurs adverses]";
	}

}
