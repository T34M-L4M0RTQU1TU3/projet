package capacite;

import cartes.Serviteur;

public class MultiClonage extends Invocation {

	public MultiClonage(String nom,int attaque,int vie,Capacite c) {
		
		super(nom,"Invoque autant de "+nom.substring(15)+" "+attaque+"/"+vie+" avec la capacite "+c.getClass().getSimpleName()+", que de serviteurs adverses",new Serviteur(nom.substring(15),0,attaque,vie,c));
	}
	



	@Override
	public String toString() {
		return "Capacite [nom ="+getNom()+", description="+getDescription()+"]";
	}
	
	
}
