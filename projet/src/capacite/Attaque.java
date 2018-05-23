package capacite;

/**
 * Classe abstraite: inflige des dégats
 * @author JHIDRI GILLOT
 * @see capacite.AttaqueCible
 * @see capacite.AttaqueDuHero 
 * @see capacite.AttaqueTotal
 */
public abstract class Attaque extends Capacite {
	
	private int degats ;
	/**
	 * @param nom : nom de l'attaque
	 * @param description : description de l'attaque
	 * @param degats : nombre de dégâts infligés
	 */
	public Attaque(String nom,String description,int degats ) {
		super(nom, description);
		setDegats(degats);
	}

	/**
	 * Donne le nombre de dégâts de l'attaque
	 * @return degats
	 */
	public int getDegats() {
		return degats;
	}

	/**
	 * Définit le nombre de dégats de l'attaque
	 * @param degats : nombre de dégats infligés
	 */
	public void setDegats(int degats) {
		if( degats < 0)
				throw new IllegalArgumentException("Degats attaque capacite invalide");
		this.degats = degats;
	}	
	
}