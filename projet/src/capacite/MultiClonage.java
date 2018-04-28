package capacite;

import cartes.*;
import player.*;

public class MultiClonage extends Invocation {

	public MultiClonage(String nom,int attaque,int vie,Capacite c,Ijoueur j) {
		
		super(nom,"Invoque autant de "+nom.substring(15)+" "+attaque+"/"+vie+" avec la capacite "+c.getClass().getSimpleName()+", que de serviteurs adverses",new Serviteur(nom.substring(15),0,attaque,vie,c,j));
	}
	



	@Override
	public String toString() {
		return "Capacite [nom ="+getNom()+", description="+getDescription()+"]";
	}




	@Override
	public void executerAction(Object cible) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void executerEffetDebutTour() {
		//Nothing
		
	}




	@Override
	public void executerEffetDisparition(Object cible) {
		//Nothing 
		
	}




	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		// TODO Auto-generated method stub
	}




	@Override
	public void executerEffetFinTour() {
		//Nothing
		
	}
	
	
}
