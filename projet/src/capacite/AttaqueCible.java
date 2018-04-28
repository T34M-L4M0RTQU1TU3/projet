package capacite;

import cartes.Serviteur;
import player.Hero;
import player.Joueur;


/*
 * Attaque cible est une attaque qui des degats et un nom et elle inflige les degats a la cible qui peutre soit hero soit Serviteur adverse biensur 
 * une attaque cible n'a qu'effet c'est lors de la miseEnJEU  
 * JE CROIS  pas qu'on a besoin de dautre effet  
 * 
 */
public class AttaqueCible extends Attaque {

	public AttaqueCible(String nom, int degats) {
		super(nom,"inflige "+degats+" points de dégat à la cible ", degats);
	}
	
	@Override
	public String toString() {
		return "Capacite [nom=" + getNom() + ", description="+getDescription()+"]";
	}
	

	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		if (cible instanceof Hero)
		{
			((Hero) cible).setVie(((Hero) cible).getVie()-getDegats());
		}
		if (cible instanceof Serviteur)
		{
			((Serviteur) cible).setVie(((Serviteur) cible).getVie()-getDegats());
				if(((Serviteur) cible).disparait() ) 
					((Serviteur) cible).getProprietaire().getJeu().remove(((Serviteur) cible)) ;
		}
	}

	@Override
	public void executerAction(Object cible) {
		if (cible instanceof Joueur)
		{
			((Joueur) cible).getHero().setVie(((Joueur) cible).getHero().getVie()-getDegats());
		}
		if (cible instanceof Serviteur)
		{
			((Serviteur) cible).setVie(((Serviteur) cible).getVie()-getDegats());
			if(((Serviteur) cible).disparait() ) 
				((Serviteur) cible).getProprietaire().getJeu().remove(((Serviteur) cible)) ;
		}
	}

	@Override
	public void executerEffetDebutTour() {
			//nothing	
	}

	@Override
	public void executerEffetDisparition(Object cible) {
			//nothing	
	}

	@Override
	public void executerEffetFinTour() {
			//nothing
	}

		
}
