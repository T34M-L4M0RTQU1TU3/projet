package capacite;

public abstract class Attaque extends Capacite {
	
	private int degats ;

	public Attaque(String nom,int degats ) {
		super(nom, "");
		setDegats(degats);
	}

	/**
	 * @return the degats
	 */
	public int getDegats() {
		return degats;
	}

	/**
	 * @param degats the degats to set
	 */
	public void setDegats(int degats) {
		this.degats = degats;
	}

	
	
}
