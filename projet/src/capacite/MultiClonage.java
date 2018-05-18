package capacite;

import cartes.*;
import player.*;

/**
 * Invoque autant de serviteurs que le nombre de seviteurs adverses ( propre à Rexxar )
 * @author JHIDRI GILLOT	
 */
public class MultiClonage extends Invocation {

	/**
	 * @param attaque : attaque des serviteurs
	 * @param vie : vie des serviteurs
	 * @param c : capacité des serviteurs
	 * @param j : joueur propriétaire des serviteurs
	 */
	public MultiClonage(String nom,int attaque,int vie,Capacite c,Ijoueur j) {		
		super(nom,"Invoque autant de chien "+attaque+"/"+vie+" avec la capacite "+c.getClass().getSimpleName()+", que de serviteurs adverses",new Serviteur("chien",0,attaque,vie,c,j));
	}

	/**
	 * Affichage
	 */
	@Override
	public String toString() {
		return "Capacite [nom ="+getNom()+", description="+getDescription()+"]";
	}

	/**
	 * Invocation Multiclonnage à la demande du joueur ( Pouvoir du Héros )
	 * @param cible : joueur propriétaire des serviteurs
	 */
	@Override
	public void executerAction(Object cible) {
		for (int i = 0; i< ((Joueur) cible).getPlateau().getAdversaire( ((Joueur) cible) ).getJeu().size(); i++ )
		{
			Serviteur s = getServiteur().clone();
			s.setNom(s.getNom()+" "+(i+1));			
			for ( Icarte c : ((Joueur) cible).getJeu())
			{
				if ( ((Serviteur) c).getCapacite() instanceof EffetPermanent )
					 {
						int boosteVie = ((EffetPermanent)((Serviteur) c).getCapacite()).getbPDV() ;
						s.setVie(s.getVie()+boosteVie);
						int boosteAttaque = ((EffetPermanent)((Serviteur) c).getCapacite()).getbPAT() ;
						s.setAttaque(s.getAttaque()+boosteAttaque);
					 }
			}			
			((Joueur) cible).addJeu(s);
		}
	}

	/**
	 * Aucun effet pour Multiclonnage en début de tour
	 */
	@Override
	public void executerEffetDebutTour() {
		//Nothing		
	}

	/**
	 * Aucun effet pour Multiclonnage à la disparition de la carte
	 * @param cible : joueur propriétaire des serviteurs
	 */
	@Override
	public void executerEffetDisparition(Object cible) {
		//Nothing 		
	}

	/**
	 * Invocation Multiclonnage à la mise en jeu de la carte
	 * @param cible : joueur propriétaire des serviteurs
	 */
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		for (int i = 0; i< ((Joueur) cible).getPlateau().getAdversaire( ((Joueur) cible) ).getJeu().size(); i++ )
		{
			Serviteur s = getServiteur().clone();
			s.setNom(s.getNom()+" "+(i+1));			
			for ( Icarte c : ((Joueur) cible).getJeu())
			{
				if ( ((Serviteur) c).getCapacite() instanceof EffetPermanent )
					 {
						int boosteVie = ((EffetPermanent)((Serviteur) c).getCapacite()).getbPDV() ;
						s.setVie(s.getVie()+boosteVie);
						int boosteAttaque = ((EffetPermanent)((Serviteur) c).getCapacite()).getbPAT() ;
						s.setAttaque(s.getAttaque()+boosteAttaque);
					 }
			}
			((Joueur) cible).addJeu(s);
		}		
	}

	/**
	 * Aucun effet pour Multiclonnage en fin de tour
	 */
	@Override
	public void executerEffetFinTour() {
		//Nothing		
	}
		
}