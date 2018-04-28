package player;

import capacite.*;

public class Mage extends Hero {
	private Capacite capacite ;
	
	public Mage(String nom) {
		super(nom);
		setCapacite(new AttaqueDuHero("Boule de Feu",1));
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
	
	

}
