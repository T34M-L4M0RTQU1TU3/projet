package capacite;

import cartes.*;
import player.*;

public class MultiClonage extends Invocation {

	public MultiClonage(String nom,int attaque,int vie,Capacite c,Ijoueur j) {
		
		super(nom,"Invoque autant de chien "+attaque+"/"+vie+" avec la capacite "+c.getClass().getSimpleName()+", que de serviteurs adverses",new Serviteur("chien",0,attaque,vie,c,j));
	}
	



	@Override
	public String toString() {
		return "Capacite [nom ="+getNom()+", description="+getDescription()+"]";
	}




	@Override
	public void executerAction(Object cible) {
		for (int i = 0; i< ((Joueur) cible).getPlateau().getAdversaire( ((Joueur) cible) ).getJeu().size(); i++ )
		{
			Serviteur s = getServiteur().clone();
			s.setNom(s.getNom()+" "+(i+1));
			
			
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
			
			((Joueur) cible).addJeu(s);
		}
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
		for (int i = 0; i< ((Joueur) cible).getPlateau().getAdversaire( ((Joueur) cible) ).getJeu().size(); i++ )
		{
			Serviteur s = getServiteur().clone();
			s.setNom(s.getNom()+" "+(i+1));
			
			
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
			((Joueur) cible).addJeu(s);
		}
		
		
	}




	@Override
	public void executerEffetFinTour() {
		//Nothing
		
	}
	
	
}