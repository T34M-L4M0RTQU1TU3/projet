package capacite;

import cartes.*;

import player.*;
public class ImageMirroir extends Invocation {

	public ImageMirroir(String nom,int attaque,int vie,Capacite c,Ijoueur j) {

		super(nom,"Invoque deux serviteur de "+j.getHero().getNom()+" "+attaque+"/"+vie+" ayant la capacite "+c.getClass().getSimpleName(),new Serviteur("Serviteur de "+j.getHero().getNom(),0,attaque,vie,c,j));

	}

	
	
	@Override
	public String toString() {
		return "Capacite [nom =Image Mirroir, description="+getDescription()+" ]";
	}

	@Override
	public void executerAction(Object cible) {
		Serviteur s = getServiteur().clone();
		s.setNom(s.getNom()+" 1");
		((Joueur ) cible).addJeu(s);
		Serviteur s2 = getServiteur().clone();
		s2.setNom(s2.getNom()+" 2");
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
		((Joueur ) cible).addJeu(s);
		Serviteur s2 = getServiteur().clone();
		s2.setNom(s2.getNom()+" 2");
		((Joueur ) cible).addJeu(s2);
	}

	@Override
	public void executerEffetFinTour() {
		//nothing
	}
}
