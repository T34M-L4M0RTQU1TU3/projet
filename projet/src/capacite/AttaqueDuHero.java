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
		
		
		
		Ijoueur adversaire = ((Joueur) cible).getPlateau().getAdversaire((Ijoueur) cible);
		
		adversaire.getHero().setVie(adversaire.getHero().getVie()-getDegats());
		if(adversaire.getHero().getVie() <= 0)
			((Joueur) cible).getPlateau().gagnePartie(((Joueur) cible));
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
				
		Ijoueur adversaire = ((Joueur) cible).getPlateau().getAdversaire((Ijoueur) cible);
		adversaire.getHero().setVie(adversaire.getHero().getVie()-getDegats());
		if(adversaire.getHero().getVie() <= 0)
			((Joueur) cible).getPlateau().gagnePartie(((Joueur) cible));	
	}


	@Override
	public void executerEffetFinTour() {
		//Nothing
		
	}

}