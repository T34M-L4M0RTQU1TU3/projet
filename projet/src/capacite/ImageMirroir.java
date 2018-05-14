package capacite;

import cartes.*;

import player.*;
public class ImageMirroir extends Invocation {

	public ImageMirroir(String nom,int attaque,int vie,Capacite c,Ijoueur j) {

		super(nom,"Invoque deux serviteur de Jayna "+attaque+"/"+vie+" ayant la capacite "+c.getClass().getSimpleName(),new Serviteur("Serviteur de Jayna",0,attaque,vie,c,j));

	}

	
	
	@Override
	public String toString() {
		return "Capacite [nom =Image Mirroir, description="+getDescription()+" ]";
	}

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
					int boosteVie = ((EffetPermanent)((Serviteur) c).getCapacite()).getbPDV() ;
					s.setVie(s.getVie()+boosteVie);
					s2.setVie(s2.getVie()+boosteVie);
				
					int boosteAttaque = ((EffetPermanent)((Serviteur) c).getCapacite()).getbPAT() ;
					s.setAttaque(s.getAttaque()+boosteAttaque);
					s2.setAttaque(s2.getAttaque()+boosteAttaque);
				 }
		}
		
		((Joueur ) cible).addJeu(s);
		((Joueur ) cible).addJeu(s2);
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
					int boosteVie = ((EffetPermanent)((Serviteur) c).getCapacite()).getbPDV() ;
					s.setVie(s.getVie()+boosteVie);
					s2.setVie(s2.getVie()+boosteVie);
				
					int boosteAttaque = ((EffetPermanent)((Serviteur) c).getCapacite()).getbPAT() ;
					s.setAttaque(s.getAttaque()+boosteAttaque);
					s2.setAttaque(s2.getAttaque()+boosteAttaque);
				 }
		}
		
		
	}

	@Override
	public void executerEffetFinTour() {
		//nothing
	}
}