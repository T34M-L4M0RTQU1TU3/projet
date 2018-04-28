package capacite;

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
		((Joueur) cible).getHero().setVie(((Joueur) cible).getHero().getVie()-getDegats());
		
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
		((Joueur) cible).getHero().setVie(((Joueur) cible).getHero().getVie()-getDegats());
	
	}


	@Override
	public void executerEffetFinTour() {
		// TODO Auto-generated method stub
		
	}

}
