package application;

import java.util.ArrayList;
import java.util.Random;

import capacite.*;
import cartes.*;

import player.*;

public class application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Plateau TerrainDeJeu = Plateau.getPlateauCourant() ;
		

		Joueur j = new Joueur("Joueur1",new Mage());	
		Joueur j2 = new Joueur("Joueur2",new Mage());	
		

		 TerrainDeJeu.ajouterJoueur(j);
		 TerrainDeJeu.ajouterJoueur(j2);
		 TerrainDeJeu.demarrerPartie();
		for ( int i = 0 ; i < 12 ; i++)
		{
			TerrainDeJeu.getJoueurCourant().prendreTour();
			TerrainDeJeu.getJoueurCourant().finirTour();
			TerrainDeJeu.getJoueurCourant().prendreTour();
			TerrainDeJeu.getJoueurCourant().finirTour();
		}
		
	
		 TerrainDeJeu.getJoueurCourant().prendreTour();
		//pouvoir
		//TerrainDeJeu.getJoueurCourant().utiliserPouvoir(TerrainDeJeu.getJoueurCourant()); 
		//serviteur qui attaque serviteur ou Joueur
		//TerrainDeJeu.getJoueurCourant().utiliserCarte(TerrainDeJeu.getJoueurCourant().getCarteEnJeu("Archimage"),TerrainDeJeu.getAdversaire(TerrainDeJeu.getJoueurCourant()));


		//TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("Chasse-marée murloc"));
		//TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("Charge"),TerrainDeJeu.getJoueurCourant().getCarteEnJeu("Archimage"));
		//TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("Attaque mentale"));
		//TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("Champion de Hurlevent"));
		//TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("Chef de raid"));
		//TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("Garde de Baie-du-butin"));		
		//TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("La missilière téméraire"));		
		//TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("L'ogre-magi"));		
		TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("Archimage"));
		//TerrainDeJeu.getJoueurCourant().utiliserCarte(TerrainDeJeu.getJoueurCourant().getCarteEnJeu("Archimage"),TerrainDeJeu.getAdversaire(TerrainDeJeu.getJoueurCourant()));

		//TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("Gnôme Lépreux"));		 
		//TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("Golem des moissons"));		
		//Mage 
		//TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("Choc de flamme"));	
		//TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("Eclair de givre"),TerrainDeJeu.getAdversaire(TerrainDeJeu.getJoueurCourant()).getCarteEnJeu("Archimage"));		 
		//TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("Intelligence des arcanes"));		 
		//TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("Image mirroir"));		
		//TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("Explosion pyrotechnique"),TerrainDeJeu.getAdversaire(TerrainDeJeu.getJoueurCourant()).getCarteEnJeu("Champion de Hurlevent"));
		 //chasseur
		//TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("Busard affamé"));	
		//TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("Marque du chasseur"),TerrainDeJeu.getAdversaire(TerrainDeJeu.getJoueurCourant()).getCarteEnJeu("Archimage"));
		//TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("Lâchez les chiens"));
		//TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("Tir des arcanes"),TerrainDeJeu.getAdversaire(TerrainDeJeu.getJoueurCourant()).getCarteEnJeu("Archimage"));
		//TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("Ordre de tuer"),TerrainDeJeu.getAdversaire(TerrainDeJeu.getJoueurCourant()).getCarteEnJeu("Archimage"));
		 
		 
		 TerrainDeJeu.getJoueurCourant().finirTour();
		TerrainDeJeu.getJoueurCourant().prendreTour();
		TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("Eclair de givre"),TerrainDeJeu.getAdversaire(TerrainDeJeu.getJoueurCourant()).getCarteEnJeu("Archimage"));		 
		
		//TerrainDeJeu.getJoueurCourant().jouerCarte(TerrainDeJeu.getJoueurCourant().getCarteEnMain("Eclair de givre"),);		 
		
		 TerrainDeJeu.getJoueurCourant().finirTour();
			TerrainDeJeu.getJoueurCourant().prendreTour();

	
		 	System.out.println(TerrainDeJeu);
	}

	/**
	 * 
	 * @deprecated 
	 * @see Plateau.toString()
	 */
	public static void afficherMain(ArrayList<Icarte> c ) {
		String s =">>>> TOUR <<<<\n### Ta main ###\n###############\n";
		for ( Icarte carte :c)
			s+="### "+carte.toString()+"\n";
	   s+="###############";
		System.out.println(s);
	}
	
	/**
	 * 
	 * @deprecated 
	 * @see Plateau.toString()
	 */
	public static void afficherJeu(ArrayList<Icarte> c ) {
		String s ="==================================\n";
		for ( Icarte carte :c)
			s+="### "+carte.toString()+(((Serviteur)carte).isJouable()?"(jouable)":"(en attente)")+"\n";
	   s+="==================================";
		System.out.println(s);
	}
	

	
	public static ArrayList<Icarte> deckBase(){
		ArrayList<Icarte> deck = new ArrayList<Icarte>();
		Icarte c5 = new Serviteur("Chasse-marée murloc",2, 2, 1,new InvocationDeServiteur("Cri de guerre",1,1,null,null),null);
		deck.add(c5);
		Icarte c12 = new Sort("Charge",1,new Charge(),null);
		deck.add(c12);
		Icarte c13 = new Sort("Attaque mentale",2,new AttaqueDuHero("Attaque mentale",5),null);
		deck.add(c13);
		Icarte c6 = new Serviteur("Champion de Hurlevent",7,6, 6, new EffetPermanent("Bonus de Hurelevent",1,1),null);
		deck.add(c6);
		Icarte c14 = new Serviteur("Chef de raid",3,2, 2, new EffetPermanent("Bonus du chef de raid",1,0),null);
		deck.add(c14);
		Icarte c7 = new Serviteur("Garde de Baie-du-butin",5, 5, 4, new Provocation(),null);
		deck.add(c7);
		Icarte c8 = new Serviteur("La missilière téméraire",6,5, 2, new Charge(),null);
		deck.add(c8);
		Icarte c9 = new Serviteur("L'ogre-magi",4, 4, 4, new Provocation(),null);
		deck.add(c9);
		Icarte c10 = new Serviteur("Archimage",6, 4, 7, new Provocation(),null);
		deck.add(c10);
		Icarte c11= new Serviteur("Gnôme Lépreux",1,1,1, new AttaqueDuHero("Attaque du lépreux",2),null);
		deck.add(c11);
		Icarte c20= new Serviteur("Golem des moissons",3,2,3,  new InvocationDeServiteur("Golémisation",2,1,null,null,"Golem endomagé"),null);
		deck.add(c20);
		boolean sortir = false ;
		int i;
		for( i=0 ; i < deck.size() && !sortir ; i++)
			{
				if (deck.size() == 10)
					sortir = true ;
				else {
					int x = new Random().nextInt(deck.size());
					deck.remove(x); 
				}
			}
		return  (ArrayList<Icarte>) deck.clone();
	}

}
