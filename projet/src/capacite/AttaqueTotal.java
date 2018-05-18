package capacite;

import java.util.ArrayList;
import cartes.Icarte;
import cartes.Serviteur;
import player.Ijoueur;
import player.Joueur;

/**
 * Inflige des dégâts à tous les serviteurs adverses
 * @author JHIDRI GILLOT
 */
public class AttaqueTotal extends Attaque {
	
	/**
	 * @see Attaque
	 */
	public AttaqueTotal(String nom, int degats) {
		super(nom,"inflige "+degats+" points de dÃ©gat Ã  tout  les serviteurs adverses", degats);		
	}
	
	/**
	 * Affichage
	 */
	@Override
	public String toString() {
		return "Capacite [nom=" + getNom() + ", description="+getDescription()+"]";
	}

	/**
	 * Attaque le jeu de la cible à la demande du joueur ( Pouvoir du Héros )
	 * @param cible : joueur adverse
	 */
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

	/**
	 * Aucun effet pour AttaqueTotale en début de tour
	 */
	@Override
	public void executerEffetDebutTour() {
		// Nothing		
	}

	/**
	 * Aucun effet pour AttaqueTotale à la disparition de la carte
	 * @param cible : joueur adverse
	 */
	@Override
	public void executerEffetDisparition(Object cible) {
		//Nothing		
	}

	/**
	 * Attaque le jeu de la cible à la mise en jeu de la carte
	 * @param cible : joueur adverse
	 */
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

	/**
	 * Aucun effet pour AttaqueTotale en fin de tour
	 */
	@Override
	public void executerEffetFinTour() {
		//Nothing		
	}

}