package capacite;

public class AttaqueTotal extends Attaque {

	public AttaqueTotal(String nom, int degats) {
		super(nom,"inflige "+degats+" points de dégat à tout  les serviteurs adverses", degats);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Capacite [nom=" + getNom() + ", description="+getDescription()+"]";
	}

}
