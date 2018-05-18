/**
 * 
 */
package capacite;

/**
 * Classe abstraite qui implémente Icapacité
 * @author JHIDRI GILLOT
 * exemple @see Charge @see Marque
 */
public abstract class Capacite implements Icapacite {
	
	private String nom ;
	private String description;

	/**
	 * @param nom : nom de la capacité
	 * @param description : description de la capacité
	 */
	public Capacite(String nom, String description) {
		setNom(nom);
		setDescription(description);
	}
	
	/**
	 * Définit le nom de la capacité
	 * @param nom : nom de la capacité
	 */
	public void setNom(String nom) {
		if (nom == null || nom.isEmpty() || nom.trim().isEmpty() )
			throw new IllegalArgumentException("Nom capacite invalide");
		this.nom = nom;
	}
	
	/**
	 * Donne le nom de la capacité
	 * @return nom
	 */
	@Override
	public String getNom() {
		return nom;
	}
	
	/**
	 * Définit la description de la capacité
	 * @param description : description de la capacité
	 */
	public void setDescription(String description) {
		if (description == null || description.isEmpty() || description.trim().isEmpty() )
			throw new IllegalArgumentException("Nom capacite invalide");
		this.description = description;
	}
	
	/**
	 * Donne la description de la capacité
	 * @return description
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * Affichage
	 */
	@Override
	public String toString() {
		return "Capacite [nom=" + nom + ", description=" + description + "]";
	}

}