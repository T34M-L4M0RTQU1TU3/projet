package player;

import java.util.ArrayList;

import capacite.*;
import cartes.Icarte;
import cartes.Sort;

public class Mage extends Hero {
	private Capacite capacite ;
	
	public Mage() {
		super("Jayna Porvaint");
		setCapacite(new AttaqueCible("Boule de Feu",1));
	}
	/**
	 * @return the capacite
	 */
	public Capacite getCapacite() {
		return capacite;
	}
	/**
	 * @param capacite the capacite to set
	 */
	private void setCapacite(Capacite capacite) {
		this.capacite = capacite;
	}
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
		Icarte c2 = new Sort("Inteligence des arcanes",2,new Piocher(2),null);
		deck.add(c2);
		Icarte c3 = new Sort("Image mirroir",1,new ImageMirroir("Image mirroir",0,2,new Provocation(),null),null);
		deck.add(c3);
		Icarte c4 = new Sort("Explosion pyrotechnique",10,new AttaqueCible("Explosion pyrotechnique",10),null);
		deck.add(c4);
		
		return deck;
	}
	
	

}
