package player;

import java.util.ArrayList;

import capacite.*;
import cartes.Icarte;
import cartes.Serviteur;
import cartes.Sort;


public class Chasseur extends Hero {
	private Capacite capacite ;


	public Chasseur() {
		super("Rexar");
		setCapacite(new AttaqueDuHero("Tir assuré",2));
	}
	
	/**
	 * @param capacite the capacite to set
	 */
	public void setCapacite(Capacite capacite) {
		this.capacite = capacite;
	}

	@Override
	public Capacite getCapacite() {
		return capacite;
	}

	@Override
	public ArrayList<Icarte> deckSpecial() {
		ArrayList<Icarte> deck = new ArrayList<Icarte>();
		Icarte c  = new Serviteur("Busard affamé",5,3,2,new Piocher(1),null);
		deck.add(c);
		Icarte c1 = new Sort("Marque du Chasseur",2,new Marque("Marque du chasseur",1),null);
		deck.add(c1);
		Icarte c2 = new Sort("Tire des arcanes",1,new AttaqueCible("Tir des arcanes",2),null);
		deck.add(c2);
		Icarte c3 = new Sort("Lâchez les chiens",1,new MultiClonage("Invocation des chiens",1,1,new Charge(),null),null);
		deck.add(c3);
		Icarte c4 = new Sort("Ordre de tuer",3,new AttaqueCible("Ordre de tuer",3),null);
		deck.add(c4);
		
		return deck;
	}
}
