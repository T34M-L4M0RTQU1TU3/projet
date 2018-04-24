package cartes;

import capacite.Capacite;

public class Sort extends Carte {
	private Capacite capacite ;
	public Sort(String nom, int cout,Capacite c) {
		super(nom, cout);
		setCapacite(c);
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
	public void setCapacite(Capacite capacite) {
		this.capacite = capacite;
	}
	
	@Override
	public String toString() {
		return "Sort [ "+super.toString()+" ] " + capacite;
	}

}
