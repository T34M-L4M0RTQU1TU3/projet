package capacite;

public abstract class Attaque extends Capacite {
	
	private int degats ;

	public Attaque(String nom,String description,int degats ) {
		super(nom, description);
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
		if( degats < 0)
				throw new IllegalArgumentException("Degats capacite invalide");
		this.degats = degats;
	}	
}