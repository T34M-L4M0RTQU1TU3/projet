package capacite;

import cartes.Serviteur;

public abstract class Invocation extends Capacite {
	private Serviteur serviteur;
	
	public Invocation(String nom,String description,Serviteur s) {
		super(nom,description);
		setServiteur(s) ;
		
	}

	/**
	 * @return the s
	 */
	public Serviteur getServiteur() {
		return serviteur;
	}
	/**
	 * @param s the s to set
	 */
	public void setServiteur(Serviteur s) {
		this.serviteur= s;
	}

	
	
}
 