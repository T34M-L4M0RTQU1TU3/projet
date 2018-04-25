package application;

import java.util.ArrayList;

import capacite.*;
import cartes.*;

import player.*;

public class application {

	public static void main(String[] args) {

		Joueur j = new Joueur("skarlette-johanson",new Mage("Jayna Porvaint"));	
		Icarte c = new Sort("Choc de flemme",7,new AttaqueTotal("Attaque massive",4));

		Icarte c1 = new Sort("Eclair de givre",2,new AttaqueCible("Attaque du givre",3));

		Icarte c2 = new Sort("Inteligence des arcanes",2,new Piocher(2));

		Icarte c3 = new Sort("Image mirroir",1,new ImageMirroir("Image mirroir",0,2,new Provocation()));

		Icarte c4 = new Sort("Explosion pyrotechnique",10,new AttaqueCible("Explosion pyrotechnique",10));
		
		Icarte c5 = new Serviteur("chasse-marée murloc",2, 2, 6, new ImageMirroir("serviteur de murloc",1,1,new Charge()));

		Icarte c6 = new Serviteur("chasse-marée murloc",2, 10, 50, new InvocationDeServiteur("serviteur de murloc",1,1,null));

		
		System.out.println(c6);
		
		
		j.addDeck(c5);
		j.addDeck(c5);
		j.addDeck(c1);
		j.addDeck(c2);
		j.addDeck(c3);
		j.addDeck(c4);
		
		 j.piocher();
		 j.piocher();
		 j.piocher();
		 j.piocher();
		 

		 j.jouerCarte(c5);
		 

		 j.utiliserCarte(c5,c6);
		 
		 
		
		 
		/* System.out.println(c4.getProprietaire());
		 
		 
			try  { 
			Icarte car = j.getCarteEnMain("Explosion pyrotechnique");
			System.out.println(car);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}*/
			
			
			
			
			
			
		afficherMain(j.getMain());
		afficherJeu(j.getJeu());
		System.out.println(c6);
		
		
		
		
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
			s+="### "+carte.toString()+"\n";
	   s+="==================================";
		System.out.println(s);
	}

}
