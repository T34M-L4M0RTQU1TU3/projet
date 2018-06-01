package application;

import java.util.ArrayList;
import java.util.Random;
import IHM.*;
import capacite.*;
import cartes.*;
import console.Console;
import exceptions.HeartStoneException;
import player.*;

public class application {

	public static Console es = new Console();
	public static Interaction ihm = null;
	public static Plateau TerrainDeJeu = Plateau.getPlateauCourant() ;
	
	public static void main(String[] args)  {


		System.out.printf("%100s\n","===========================================");
		System.out.printf("%100s\n","===============>           <===============");
		System.out.printf("%100s\n","===============>HearthStone<===============");
		System.out.printf("%100s\n","===============>           <===============");
		System.out.printf("%100s\n","===========================================");


		
		ihm = initialiserHero();
		if(ihm == null) {
			es.println("L'application ne fait rien");
			System.exit(0);
		}
		
		choixJoueurs();
	
		ihm = initialiserInterface();
		if(ihm == null) {
			es.println("L'application ne fait rien");
			System.exit(0);
		}

		 demarrageDePartie();

	}





	public static void demarrageDePartie() {
		TerrainDeJeu.demarrerPartie();
		 TerrainDeJeu.getJoueurCourant().prendreTour();
		 while(TerrainDeJeu.estDermarree()) {
			 
			 es.println(TerrainDeJeu);
			 try {
			 String choix = menu("que voulez vous faire ?\n--->");
			 
			 try {
				ihm.interagir(choix, TerrainDeJeu);
			} catch (HeartStoneException e) {
				System.err.printf("%100s\n",e.getMessage());

			}
			 }catch(IndexOutOfBoundsException e2) {}
 
		 }
	}
	public static void choixJoueurs() {
		while(true) {
			es.println("joueur "+(TerrainDeJeu.getPlayers().size()+1)+" choisissez votre Heros :");
			 try {
				 String choix = menu("quel numero ?\n--->");
				 try {
					 ihm.interagir(choix, TerrainDeJeu);
				 	} catch (HeartStoneException e) {
				 		System.err.printf("%100s\n",e.getMessage());
				 	}
			 	}catch(IndexOutOfBoundsException e2) {}
			 
			 if(TerrainDeJeu.getPlayers().size() == 2)
				 break;
		 }
	}
	
	public static ArrayList<Icarte> deckBase() throws HeartStoneException{
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
		Icarte c8 = new Serviteur("La missilière téméraire",6,5,2, new Charge(),null);
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

	public static Interaction initialiserInterface() {
		Interaction monInterface = null;
		monInterface = new Abandon(monInterface);
		monInterface = new PouvoirDuHeros(monInterface);
		monInterface = new UtiliserCarte(monInterface);
		monInterface = new JouerCarte(monInterface);
		monInterface = new FinirTour(monInterface);
		return monInterface;
	}
	public static Interaction initialiserHero() {
		Interaction monInterface = null;
		monInterface = new ChoixMage(monInterface);
		monInterface = new ChoixChasseur(monInterface);
		
		return monInterface;
	}
	public static Interaction initialiserSousInterface() {
		Interaction sousInterface = null;
		sousInterface = new CibleHeros(sousInterface);
		sousInterface = new CibleServiteur(sousInterface);
		return sousInterface;
	}
	
	public static String menu(String phrase) {
		ArrayList <String> menu = new ArrayList<String>();
		Interaction i = ihm;
		while (i != null) {
			menu.add(i.getDescription());
			i=i.getSuivant();
		}
		int n = 1;
		for (String s : menu) {
			es.println(""+n+". "+s);
			n++;
		}
		es.print(phrase);
		int c = es.readInt();
		return menu.get(c-1);
	}
	public static String sousMenu(Interaction ihm) {
		ArrayList <String> sousMenu = new ArrayList<String>();
		Interaction i = ihm;
		while (i != null) {
			sousMenu.add(i.getDescription());
			i=i.getSuivant();
		}
		int n = 1;
		for (String s : sousMenu) {
			es.println(""+n+". "+s);
			n++;
		}
		es.print("Choisissez une cible:");
		int c = es.readInt();
		return sousMenu.get(c-1);
	}

}