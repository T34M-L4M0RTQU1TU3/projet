package capacite;

public class InvocationDeServiteur extends Invocation {
		
	public InvocationDeServiteur(String nom,Serviteur s) {
		super(nom,s);

	}

	
	@Override
	public String toString() {
		return "Capacite [nom ="+getNom()+", description=Invoque un serviteur "+getServiteur().getPAttaque()+"/"+getServiteur().getPVie()+"]";
	}
	
	
	

}
