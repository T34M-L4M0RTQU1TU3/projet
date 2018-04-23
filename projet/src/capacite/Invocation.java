package capacite;
public abstract class Invocation extends Capacite {
	private Serviteur serviteur;
	
	public Invocation(String nom,Serviteur s) {
		super(nom,"");
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
 