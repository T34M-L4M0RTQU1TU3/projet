package capacite;

import cartes.Serviteur;
import player.Hero;

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
		}
	};

}
