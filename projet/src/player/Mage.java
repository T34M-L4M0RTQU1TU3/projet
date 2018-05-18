package player;

import java.util.ArrayList;

import capacite.*;
import cartes.Icarte;
import cartes.Sort;

/**
 * Un héros de type Mage
 * @author JHIDRI GILLOT
 */
public class Mage extends Hero {
	private Capacite capacite ;
	
	/**
	 * @see Hero
	 */
	public Mage() {
		super("Jayna Porvaint");
		setCapacite(new AttaqueCible("Boule de Feu",1));
	}
	
	/**
	 * Donne la capacité du mage
	 * @return capacite
	 */
	public Capacite getCapacite() {
		return capacite;
	}
	
	/**
	 * Définit la capacité du mage
	 * @param capacite : capacité du mage
	 */
	private void setCapacite(Capacite capacite) {
		this.capacite = capacite;
	}
	
	/**
	 * Créée et ajoute au deck les cartes spécifiques du mage
	 */
	/* (non-Javadoc)
	 * @see player.Hero#deckSpecial()
	 */
	@Override
	public ArrayList<Icarte> deckSpecial() {
		ArrayList<Icarte> deck = new ArrayList<Icarte>();
		Icarte c  = new Sort("Choc de flamme",7,new AttaqueTotal("Attaque massive",4),null);
		deck.add(c);
		Icarte c1 = new Sort("Eclair de givre",2,new AttaqueCible("Attaque du givre",3),null);
		deck.add(c1);
		Icarte c2 = new Sort("Intelligence des arcanes",2,new Piocher(2),null);
		deck.add(c2);
		Icarte c3 = new Sort("Image mirroir",1,new ImageMirroir("Image mirroir",0,2,new Provocation(),null),null);
		deck.add(c3);
		Icarte c4 = new Sort("Explosion pyrotechnique",10,new AttaqueCible("Explosion pyrotechnique",10),null);
		deck.add(c4);		
		return deck;
	}	

}