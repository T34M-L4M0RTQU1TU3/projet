package player;

import capacite.Capacite;

public abstract class Hero {

	private String nom ;
	private int vie = PDVMAX;
	static final int PDVMAX = 15; 
	/**
	 * @param nom
	 * @param vie
	 */
	public Hero(String nom) {
		setNom(nom);
		setVie(vie);
	}

	
	

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the vie
	 */
	public int getVie() {
		return vie;
	}
	/**
	 * @param vie the vie to set
	 */
	public void setVie(int vie) {
		this.vie = vie;
	}
	
	public abstract Capacite getCapacite();

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hero [nom=" + nom + ", pointsDeVieCourant=" + vie + ",pointsDeVieMax="+PDVMAX+"]";
	}

	
	
}
