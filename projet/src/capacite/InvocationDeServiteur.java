package capacite;

import cartes.Serviteur;

public class InvocationDeServiteur extends Invocation {
		
	public InvocationDeServiteur(String nom,int attaque,int vie,Capacite c) {
		super(nom,"Invoque un serviteur "+attaque+"/"+vie,new Serviteur("Serviteur de murloc",0,attaque,vie,c));

	}

	
	@Override
	public String toString() {
		return "Capacite [nom ="+getNom()+", description="+getDescription()+"]";
	}
	
	
	

}
