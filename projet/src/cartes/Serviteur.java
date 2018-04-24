package cartes;

import capacite.Capacite;

public class Serviteur extends Carte {
		private int attaque;
		private int vie;
		private Capacite capacite ;
		
	public Serviteur(String nom, int cout,int attaque,int vie,Capacite capacite) {
		super(nom, cout);
		setVie(vie);
		setAttaque(attaque);
		setCapacite(capacite);
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

	/**
	 * @return the attaque
	 */
	public int getAttaque() {
		return attaque;
	}

	/**
	 * @param attaque the attaque to set
	 */
	public void setAttaque(int attaque) {
		this.attaque = attaque;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Serviteur [ "+super.toString()+" attaque=" + attaque + ", vie=" + vie + " ] " + capacite;
	}


	
	

	
	

}
