package player;

import capacite.*;


public class Chasseur extends Hero {
	private Capacite capacite ;


	public Chasseur(String nom) {
		super(nom);
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
		// TODO Auto-generated method stub
		return capacite;
	}

}
