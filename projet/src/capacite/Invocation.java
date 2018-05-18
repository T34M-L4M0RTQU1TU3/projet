package capacite;

import cartes.Serviteur;

/**
 * Invoque un/des serviteur(s) sur le jeu
 * @author JHIDRI GILLOT
 * @see ImageMirroir InvocationDeServiteur Multiclonage
 */
public abstract class Invocation extends Capacite {
	
	private Serviteur serviteur;
	
	/**
	 * @param nom : nom de l'invocation
	 * @param description : description de l'invocation
	 * @param s : serviteur à invoquer
	 */
	public Invocation(String nom,String description,Serviteur s) {
		super(nom,description);
		setServiteur(s) ;		
	}

	/**
	 * Donne le serviteur à invoquer
	 * @return s
	 */
	public Serviteur getServiteur() {
		return serviteur;
	}
	
	/**
	 * Définit le serviteur à invoquer
	 * @param s : serviteur à invoquer 
	 */
	public void setServiteur(Serviteur s) {
		if(s == null)
			throw new IllegalArgumentException("Serviteur invoque invalide");
		this.serviteur= s;
	}	
	
}
 