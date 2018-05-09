package application;

import java.util.ArrayList;

import capacite.*;
import cartes.*;

import player.*;

public class application {

	public static void main(String[] args) {

		Joueur j = new Joueur("skarlette-johanson",new Mage("Jayna Porvaint"));	
		
		
		//Icarte c  = new Sort("Choc de flemme",7,new AttaqueCible("Attaque massive",4),j);

	//	Icarte c1 = new Sort("Eclair de givre",2,new EffetPermanent("bouste de givre",2,2),j);

	//	Icarte c2 = new Sort("Inteligence des arcanes",2,new Piocher(2),j);

		Icarte c3 = new Sort("Image mirroir",1,new ImageMirroir("Image mirroir",0,2,new Provocation(),j),j);

		//Icarte c4 = new Sort("Explosion pyrotechnique",10,new AttaqueCible("Explosion pyrotechnique",10),j);
		
		Icarte c5 = new Serviteur("achraf",2, 2, 6,new Charge(),j);

	//	Icarte c6 = new Serviteur("chasse-marée murloc",2, 50, 90, new AttaqueCible("ATTAQUE MENTALE !", 4),j);

		
		
		
		
		j.addDeck(c3);
		//j.addDeck(c3);
		j.addDeck(c5);
		//j.addDeck(c3);

		
		 j.piocher();
		 j.piocher();
		 //c5.executerEffetFinTour(c);
		 //j.piocher();
			// j.piocher();
		 j.jouerCarte(c3);
		 j.jouerCarte(c5);

	 
		// j.jouerCarte(c6,j.getCarteEnJeu("achraf"));
		//j.utiliserPouvoir(j);

		//Icarte d = ");
		//j.jouerCarte(c,d);
		 
		
		j.utiliserCarte(c5,j.getCarteEnJeu("Serviteur de Jayna Porvaint 1"));
		 
		 
			
			
			
		System.out.println(j);
		afficherMain(j.getMain());
		afficherJeu(j.getJeu());
		
		
		
		
		
	}

	
	public static void afficherMain(ArrayList<Icarte> c ) {
		String s =">>>> TOUR <<<<\n### Ta main ###\n###############\n";
		for ( Icarte carte :c)
			s+="### "+carte.toString()+"\n";
	   s+="###############";
		System.out.println(s);
	}
	
	
	public static void afficherJeu(ArrayList<Icarte> c ) {
		String s ="==================================\n";
		for ( Icarte carte :c)
			s+="### "+carte.toString()+(((Serviteur)carte).isJouable()?"(jouable)":"(en attente)")+"\n";
	   s+="==================================";
		System.out.println(s);
	}

}
