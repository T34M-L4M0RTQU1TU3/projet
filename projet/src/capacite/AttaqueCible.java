package capacite;

import cartes.*;
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
		if( cible == null )
			throw new IllegalArgumentException("cible null ");
		
		if (cible instanceof Joueur)
		{
			for(  Icarte c : ((Joueur) cible).getJeu() )
				if ( ((Serviteur)c).getCapacite() instanceof Provocation )
					throw new IllegalArgumentException("vous ne pouvez pas attaquer le hero tant qu'il a un serviteur ayant Provocation");
			
			((Joueur) cible).getHero().setVie(((Joueur) cible).getHero().getVie()-getDegats());

			if(((Joueur) cible).getHero().getVie() <= 0)
				((Joueur) cible).getPlateau().gagnePartie(((Joueur) cible).getPlateau().getAdversaire(((Joueur) cible)));
				
			
		}
		if(cible instanceof Serviteur)
		{
		if(((Serviteur) cible).getCapacite() instanceof Provocation)
			{ // La cible a Provocation
				((Serviteur) cible).setVie(((Serviteur) cible).getVie()-getDegats());
			
				
				if(((Serviteur) cible).disparait())
					{
						executerEffetDisparition(((Serviteur) cible));
						((Serviteur)cible).getProprietaire().perdreCarte(((Serviteur) cible));
		
					}
			}else { // La cible n'a pas provocation
				for(  Icarte c : ((Serviteur)cible).getProprietaire().getJeu() )
					if ( ((Serviteur)c).getCapacite() instanceof Provocation )
						// Un des serviteurs de l'adversaire a Provocation
						throw new IllegalArgumentException("vous ne pouvez pas attaquer le hero tant qu'il a un serviteur ayant Provocation");
					// Aucun serviteur de l'adversaire possede Provocation
					((Serviteur) cible).setVie(((Serviteur) cible).getVie()-getDegats());

					if(((Serviteur) cible).disparait())
						{
							executerEffetDisparition(((Serviteur) cible));
							((Serviteur)cible).getProprietaire().perdreCarte(((Serviteur) cible));
				
						}
				
			}
		}
	}

	@Override
	public void executerAction(Object cible) {
		if( cible == null )
			throw new IllegalArgumentException("cible null ");
		
		if (cible instanceof Joueur)
		{
			for(  Icarte c : ((Joueur) cible).getJeu() )
				if ( ((Serviteur)c).getCapacite() instanceof Provocation )
					throw new IllegalArgumentException("vous ne pouvez pas attaquer le hero tant qu'il a un serviteur ayant Provocation");
			
			((Joueur) cible).getHero().setVie(((Joueur) cible).getHero().getVie()-getDegats());

			if(((Joueur) cible).getHero().getVie() <= 0)
				((Joueur) cible).getPlateau().gagnePartie(((Joueur) cible).getPlateau().getAdversaire(((Joueur) cible)));
	
		}
		if(cible instanceof Serviteur)
		{
		if(((Serviteur) cible).getCapacite() instanceof Provocation)
			{ // La cible a Provocation
				((Serviteur) cible).setVie(((Serviteur) cible).getVie()-getDegats());
			
				
				if(((Serviteur) cible).disparait())
					{
						executerEffetDisparition(((Serviteur) cible));
						((Serviteur)cible).getProprietaire().perdreCarte(((Serviteur) cible));
		
					}
			}else { // La cible n'a pas provocation
				for(  Icarte c : ((Serviteur)cible).getProprietaire().getJeu() )
					if ( ((Serviteur)c).getCapacite() instanceof Provocation )
						// Un des serviteurs de l'adversaire a Provocation
						throw new IllegalArgumentException("vous ne pouvez pas attaquer le hero tant qu'il a un serviteur ayant Provocation");
					// Aucun serviteur de l'adversaire possede Provocation
					((Serviteur) cible).setVie(((Serviteur) cible).getVie()-getDegats());

					if(((Serviteur) cible).disparait())
						{
							executerEffetDisparition(((Serviteur) cible));
							((Serviteur)cible).getProprietaire().perdreCarte(((Serviteur) cible));
				
						}
				
			}
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