package player;

import java.util.ArrayList;

import capacite.*;
import cartes.Icarte;
import cartes.Serviteur;
import cartes.Sort;
import exceptions.HeartStoneException;

/**
 * Un héros de type chasseur 
 * @author JHIDRI GILLOT
 */
public class Chasseur extends Hero {
	private Capacite capacite ;

	/**
	 * @see Hero
	 * le Hero de type chasseur a forcèment une capacité de type AttaqueDuHero , de nom Tir assuré et de cout 2 
	 */
	public Chasseur() {
		super("Rexar");
		setCapacite(new AttaqueDuHero("Tir assuré",2));
	}
	
	/**
	 * Définit la capacité du chasseur 
	 * @param capacite : capacité du chasseur
	 */
	public void setCapacite(Capacite capacite) {
		this.capacite = capacite;
	}

	/**
	 * Donne la capacité du chasseur
	 * @return capacite
	 */
	@Override
	public Capacite getCapacite() {
		return capacite;
	}

	/**
	 * Créée et ajoute au deck les cartes spécifiques du chasseur
	 * @throws HeartStoneException 
	 */
	@Override
	public ArrayList<Icarte> deckSpecial() throws HeartStoneException {
		ArrayList<Icarte> deck = new ArrayList<Icarte>();
		Icarte c  = new Serviteur("Busard affamé",5,3,2,new Piocher(1),null);
		deck.add(c);
		Icarte c1 = new Sort("Marque du chasseur",2,new Marque("Marque du chasseur",1),null);
		deck.add(c1);
		Icarte c2 = new Sort("Tir des arcanes",1,new AttaqueCible("Tir des arcanes",2),null);
		deck.add(c2);
		Icarte c3 = new Sort("Lâchez les chiens",3,new MultiClonage("Invocation des chiens",1,1,new Charge(),null),null);
		deck.add(c3);
		Icarte c4 = new Sort("Ordre de tuer",3,new AttaqueCible("Ordre de tuer",3),null);
		deck.add(c4);		
		return deck;
	}
	
}