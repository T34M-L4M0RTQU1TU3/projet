package capacite;

import cartes.Icarte;
import cartes.Serviteur;

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
		for(  Icarte c : ((Serviteur) cible).getProprietaire().getJeu() )
			if ( ((Serviteur)c).getCapacite() instanceof Provocation )
				throw new IllegalArgumentException("vous ne pouvez pas attaquer ce serviteur  tant qu'il a un autre serviteur ayant Provocation dans le plateau adverse ");
		
		
	}


	@Override
	public void executerEffetDebutTour() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void executerEffetDisparition(Object cible) {
		//Nothing
		
	}


	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		for(  Icarte c : ((Serviteur) cible).getProprietaire().getJeu() )
			if ( ((Serviteur)c).getCapacite() instanceof Provocation )
				throw new IllegalArgumentException("vous ne pouvez pas attaquer ce serviteur  tant qu'il a un autre serviteur ayant Provocation dans le plateau adverse ");
		
	}


	@Override
	public void executerEffetFinTour() {
		//Nothing
		
	}

}
