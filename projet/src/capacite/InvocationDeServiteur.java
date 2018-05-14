package capacite;

import cartes.Icarte;
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
		// nothing
		
	}


	@Override
	public void executerEffetDisparition(Object cible) {
		// nothing
		
	}


	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		Serviteur s = getServiteur().clone();
		
		for ( Icarte c : ((Joueur) cible).getJeu())
		{
			if ( ((Serviteur) c).getCapacite() instanceof EffetPermanent )
				 {
					int boosteVie = ((EffetPermanent)((Serviteur) c).getCapacite()).getbPDV() ;
					s.setVie(s.getVie()+boosteVie);
					int boosteAttaque = ((EffetPermanent)((Serviteur) c).getCapacite()).getbPAT() ;
					s.setAttaque(s.getAttaque()+boosteAttaque);
				 }
		}
		((Joueur ) cible).addJeu(s);
		
	}


	@Override
	public void executerEffetFinTour() {
		// nothing
		
	}
}