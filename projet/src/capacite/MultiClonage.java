package capacite;

import cartes.Serviteur;

public class MultiClonage extends Invocation {

	public MultiClonage(String nom,int pAttaque,int pVie,Capacite c) {
		
		super(nom,new Serviteur(nom.substring(15),0,pAttaque,pVie,c));
	}
	



	@Override
	public String toString() {
		return "Capacite [nom ="+getNom()+", description=Invoque autant de "+getNom().substring(15)+" "+getServiteur().getAttaque()+"/"+getServiteur().getVie()+" avec la capacité "+getServiteur().getCapacite().getClass().getSimpleName()+" ,que de serviteurs adverses]";
	}
	
	
}
