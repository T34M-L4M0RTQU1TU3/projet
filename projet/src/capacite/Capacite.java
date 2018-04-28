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
	 * 
	 * @param nom
	 * @param description
	 */
	public Capacite(String nom, String description) {

		setNom(nom);
		setDescription(description);
	}
	/**
	 * @param nom
	 *
	 */
	public void setNom(String nom) {
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
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String getDescription() {
		return description;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Capacite [nom=" + nom + ", description=" + description + "]";
	}

	



}
