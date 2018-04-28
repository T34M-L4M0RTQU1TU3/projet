package capacite;

import cartes.Icarte;
import cartes.Serviteur;
import player.Hero;
import player.Joueur;

public class AttaqueDuHero extends Attaque {

	public AttaqueDuHero(String nom, int degats) {
		super(nom,"inflige "+degats+" points de dégat au héros adverse", degats);
		
	}

	
	@Override
	public String toString() {
		return "Capacite [nom=" + getNom() + ", description="+getDescription()+"]";
	}


	@Override
	public void executerAction(Object cible) {
		for(  Icarte c : ((Joueur) cible).getJeu() )
			if ( ((Serviteur)c).getCapacite() instanceof Provocation )
				throw new IllegalArgumentException("vous ne pouvez pas attaquer le hero tant qu'il a un serviteur ayant Provocation");
		((Joueur) cible).getHero().setVie(((Joueur) cible).getHero().getVie()-getDegats());
		
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
		for(  Icarte c : ((Joueur) cible).getJeu() )
			if ( ((Serviteur)c).getCapacite() instanceof Provocation )
				throw new IllegalArgumentException("vous ne pouvez pas attaquer le hero tant qu'il a un serviteur ayant Provocation");
		((Joueur) cible).getHero().setVie(((Joueur) cible).getHero().getVie()-getDegats());
	
	}


	@Override
	public void executerEffetFinTour() {
		//Nothing
		
	}

}
