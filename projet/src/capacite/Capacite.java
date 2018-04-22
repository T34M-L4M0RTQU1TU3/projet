/**
 * 
 */
package capacite;

/**
 * @author town
 *
 */
public abstract class Capacite implements Icapacite {
	
	private String nom ;
	private String description;
	


	
	/**
	 * @param nom
	 * @param description
	 */
	protected Capacite(String nom, String description) {

		setNom(nom);
		setDescription(description);
	}
	/**
	 * @param nom
	 *
	 */
	protected void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String getNom() {
		return nom;
	}
	/**
	 * @param description
	 *
	 */
	protected void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String getDescription() {
		return description;
	}





	

	@Override
	public void executerAction(Object cible) {
	}


	@Override
	public void executerEffetDebutTour(Object cible) {
	}

	
	@Override
	public void executerEffetDisparition(Object cible) {
	}


	@Override
	public void executerEffetMiseEnJeu(Object cible) {
	}



	public String toString() {
		return "Capacite [nom=" + nom + ", description=" + description + "]";
	}
}
