package application;

import java.util.ArrayList;

import capacite.*;
import cartes.*;

import player.*;

public class application {

	public static void main(String[] args) {

		Joueur j = new Joueur("skarlette-johanson",new Mage("Jayna Porvaint"));	
		
		
		Icarte c  = new Sort("Choc de flemme",7,new AttaqueCible("Attaque massive",4),j);

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
		 
		 
		
		 
		/* System.out.println(c4.getProprietaire());
		 
		 
			try  { 
			Icarte car = j.getCarteEnMain("Explosion pyrotechnique");
			System.out.println(car);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}*/
			
			
			
			
			
		System.out.println(j);
		afficherMain(j.getMain());
		afficherJeu(j.getJeu());
		
		
		
		
		
	}
	/*public static ArrayList<Icarte> remplirDeckDeBase(){
		ArrayList<Icarte> deck = new ArrayList<Icarte>();
	
		
		
		Icarte c5 = new Serviteur("Chasse-marée murloc",2, 2, 1, new InvocationDeServiteur("serviteur de murloc",1,1,null));
		deck.add(c5);
		Icarte c12 = new Sort("Charge",1,new Charge());
		deck.add(c12);
		Icarte c13 = new Sort("Attaque mentale",2,new AttaqueDuHero("Attaque mentale",5));
		deck.add(c13);
		Icarte c6 = new Serviteur("Champion de Hurlevent",7,6, 6, new EffetPermanent("Bonus de Hurelevent",1,1));
		deck.add(c6);
		Icarte c14 = new Serviteur("Chef de raid",3,2, 2, new EffetPermanent("Bonus du chef de raid",1,0));
		deck.add(c14);
		Icarte c7 = new Serviteur("Garde de Baie-du-butin",5, 5, 4, new Provocation());
		deck.add(c7);
		Icarte c8 = new Serviteur("La missilière téméraire",6,5, 2, new Charge());
		deck.add(c8);
		Icarte c9 = new Serviteur("L'ogre-magi",4, 4, 4, new Provocation());
		deck.add(c9);
		Icarte c10 = new Serviteur("Archimage",6, 4, 7, new Provocation());
		deck.add(c10);
		Icarte c11= new Serviteur("Gnôme Lépreux",1,1,1, new AttaqueDuHero("Attaque du lépreux",2));
		deck.add(c11);
		return deck;
	
	}*/
	
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
