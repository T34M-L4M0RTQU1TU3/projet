package capacite;

import cartes.Serviteur;

public class InvocationDeServiteur extends Invocation {
		
	public InvocationDeServiteur(String nom,int pAttaque,int pVie,Capacite c) {
		super(nom,new Serviteur("Serviteur de nom",0,pAttaque,pVie,c));

	}

	
	@Override
	public String toString() {
		return "Capacite [nom ="+getNom()+", description=Invoque un serviteur "+getServiteur().getAttaque()+"/"+getServiteur().getVie()+"]";
	}
	
	
	

}
