package capacite;

import cartes.Serviteur;
import player.*;
public class InvocationDeServiteur extends Invocation {
		
	public InvocationDeServiteur(String nom,int attaque,int vie,Capacite c,Ijoueur j,String nomServiteur) {
		super(nom,"Invoque un \""+nomServiteur+"\" "+attaque+"/"+vie,new Serviteur(nomServiteur,0,attaque,vie,c,j));
		
	}

	public InvocationDeServiteur(String nom,int attaque,int vie,Capacite c,Ijoueur j) {
		super(nom,"Invoque un serviteur "+attaque+"/"+vie,new Serviteur("serviteur",0,attaque,vie,c,j));	
	}
	
	@Override
	public String toString() {
		return "Capacite [nom ="+getNom()+", description="+getDescription()+"]";
	}
	
	

	@Override
	public void executerAction(Object cible) {
		((Joueur ) cible).addJeu(getServiteur());
		
	}


	@Override
	public void executerEffetDebutTour() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void executerEffetDisparition(Object cible) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		((Joueur ) cible).addJeu(getServiteur());
		
	}


	@Override
	public void executerEffetFinTour() {
		// TODO Auto-generated method stub
		
	}
}
