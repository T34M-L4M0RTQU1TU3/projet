package capacite;

import cartes.*;

import player.*;

/**
 * Invoque deux serviteurs identiques ( pour Jayna )
 * @author JHIDRI GILLOT
 */
public class ImageMirroir extends Invocation {

	/**
	 * @param attaque : attaque des serviteurs
	 * @param vie : vie des serviteurs
	 * @param c : capacité des serviteurs
	 * @param j : joueur propriétaire des serviteurs
	 */
	public ImageMirroir(String nom,int attaque,int vie,Capacite c,Ijoueur j) {
		super(nom,"Invoque deux serviteur de Jayna "+attaque+"/"+vie+" ayant la capacite "+c.getClass().getSimpleName(),new Serviteur("Serviteur de Jayna",0,attaque,vie,c,j));
	}


	/**
	 * Invocation mirroir à la demande du joueur ( Pouvoir du Héros)
	 */
	@Override
	public void executerAction(Object cible) {		
		Serviteur s = getServiteur().clone();
		s.setNom(s.getNom()+" 1");
		s.setJoueur(((Joueur) cible));		
		
		Serviteur s2 = getServiteur().clone();
		s2.setNom(s2.getNom()+" 2");
		s2.setJoueur(((Joueur) cible));		
		for ( Icarte c : ((Joueur) cible).getJeu())
		{
			if ( ((Serviteur) c).getCapacite() instanceof EffetPermanent )
				 {
					int boostVie = ((EffetPermanent)((Serviteur) c).getCapacite()).getbPDV() ;
					s.setVie(s.getVie()+boostVie);
					s2.setVie(s2.getVie()+boostVie);
				
					int boostAttaque = ((EffetPermanent)((Serviteur) c).getCapacite()).getbPAT() ;
					s.setAttaque(s.getAttaque()+boostAttaque);
					s2.setAttaque(s2.getAttaque()+boostAttaque);
				 }
		}		
		((Joueur ) cible).addJeu(s);
		((Joueur ) cible).addJeu(s2);
	}

	/**
	 * Aucun effet pour ImageMirroir en début de tour
	 */
	@Override
	public void executerEffetDebutTour() {
		//nothing		
	}

	/**
	 * Aucun effet pour ImageMirroir à la disparition de la carte
	 */
	@Override
	public void executerEffetDisparition(Object cible) {
		//nothing		
	}

	/**
	 * Invocation mirroir à la mise en jeu de la carte
	 */
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		Serviteur s = getServiteur().clone();
		s.setNom(s.getNom()+" 1");
		
		Serviteur s2 = getServiteur().clone();
		s2.setNom(s2.getNom()+" 2");
	
		((Joueur ) cible).addJeu(s);
		((Joueur ) cible).addJeu(s2);		
		for ( Icarte c : ((Joueur) cible).getJeu())
		{
			if ( ((Serviteur) c).getCapacite() instanceof EffetPermanent )
				 {
					int boostVie = ((EffetPermanent)((Serviteur) c).getCapacite()).getbPDV() ;
					s.setVie(s.getVie()+boostVie);
					s2.setVie(s2.getVie()+boostVie);
				
					int boostAttaque = ((EffetPermanent)((Serviteur) c).getCapacite()).getbPAT() ;
					s.setAttaque(s.getAttaque()+boostAttaque);
					s2.setAttaque(s2.getAttaque()+boostAttaque);
				 }
		}		
	}

	/**
	 * Aucun effet pour ImageMirroir en fin de tour
	 */
	@Override
	public void executerEffetFinTour() {
		//nothing
	}
	
	
	/**
	 * Affichage
	 */
	@Override
	public String toString() {
		return "Capacite [nom =Image Mirroir, description="+getDescription()+" ]";
	}
}