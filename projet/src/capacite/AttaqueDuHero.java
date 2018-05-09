package capacite;


import player.Ijoueur;
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

		((Joueur) cible).getPlateau().getAdversaire((Ijoueur) cible).getHero().setVie(((Joueur) cible).getHero().getVie()-getDegats());
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

				
		((Joueur) cible).getPlateau().getAdversaire((Ijoueur) cible).getHero().setVie(((Joueur) cible).getHero().getVie()-getDegats());
	
	}


	@Override
	public void executerEffetFinTour() {
		//Nothing
		
	}

}
