package capacite;

import java.util.ArrayList;

import cartes.Icarte;
import cartes.Serviteur;
import player.Ijoueur;
import player.Joueur;

public class AttaqueTotal extends Attaque {

	public AttaqueTotal(String nom, int degats) {
		super(nom,"inflige "+degats+" points de dégat à tout  les serviteurs adverses", degats);
		
	}
	
	
	@Override
	public String toString() {
		return "Capacite [nom=" + getNom() + ", description="+getDescription()+"]";
	}


	@Override
	public void executerAction(Object cible) {
		int nombreServiteurAyantProvocation  = 0 ;
		
		Ijoueur adversaire = ((Joueur) cible).getPlateau().getAdversaire(((Joueur) cible));
		for( Icarte c : adversaire.getJeu() )
			if ( ((Serviteur)c).getCapacite() instanceof Provocation )
				nombreServiteurAyantProvocation++;
		
		if(adversaire.getJeu().size() != nombreServiteurAyantProvocation && nombreServiteurAyantProvocation > 0 ) 
			throw new IllegalArgumentException("vous ne pouvez pas attaquer un serviteur  tant qu'il a un autre serviteur ayant Provocation dans le plateau adverse ");
			
				
		ArrayList<Icarte> l = (ArrayList<Icarte>) adversaire.getJeu().clone();
		for(  Icarte c : l ) 
		{
			((Serviteur)c).setVie(((Serviteur)c).getVie() - getDegats()) ; 
			if( ((Serviteur)c).disparait() )
				adversaire.perdreCarte(((Serviteur) c));
		}
			
	}


	@Override
	public void executerEffetDebutTour() {
		// Nothing
		
	}


	@Override
	public void executerEffetDisparition(Object cible) {
		//Nothing
		
	}


	@Override
	public void executerEffetMiseEnJeu(Object cible) {
	int nombreServiteurAyantProvocation  = 0 ;
		
		Ijoueur adversaire = ((Joueur) cible).getPlateau().getAdversaire(((Joueur) cible));
		for( Icarte c : adversaire.getJeu() )
			if ( ((Serviteur)c).getCapacite() instanceof Provocation )
				nombreServiteurAyantProvocation++;
		
			if(adversaire.getJeu().size() != nombreServiteurAyantProvocation && nombreServiteurAyantProvocation > 0 ) 
				throw new IllegalArgumentException("vous ne pouvez pas attaquer un serviteur  tant qu'il a un autre serviteur ayant Provocation dans le plateau adverse ");
			
				
		ArrayList<Icarte> l = (ArrayList<Icarte>) adversaire.getJeu().clone();
		for(  Icarte c : l ) 
		{
			((Serviteur)c).setVie(((Serviteur)c).getVie() - getDegats()) ; 
			if( ((Serviteur)c).disparait() )
				adversaire.perdreCarte(((Serviteur) c));
		}
			
	}


	@Override
	public void executerEffetFinTour() {
		//Nothing
		
	}

}