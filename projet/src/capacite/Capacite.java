/**
 * 
 */
package capacite;

/**
 * Classe abstraite qui implÃ©mente IcapacitÃ©
 * 
 * @author JHIDRI GILLOT exemple @see Charge @see Marque
 */
public abstract class Capacite implements Icapacite {

	private String nom;
	private String description;

	/**
	 * @param nom
	 *            : nom de la capacitÃ©
	 * @param description
	 *            : description de la capacitÃ©
	 * @throws IllegalArgumentException
	 *             : en cas de nom null, vide ou uniquement constitué d'espaces
	 */
	public Capacite(String nom, String description) {
		setNom(nom);
		setDescription(description);
	}

	/**
	 * DÃ©finit le nom de la capacitÃ©
	 * 
	 * @param nom
	 *            : nom de la capacitÃ©
	 */
	public void setNom(String nom) {
		if (nom == null || nom.isEmpty() || nom.trim().isEmpty())
			throw new IllegalArgumentException("Nom capacite invalide");
		this.nom = nom;
	}

	/**
	 * Donne le nom de la capacitÃ©
	 * 
	 * @return nom
	 */
	@Override
	public String getNom() {
		return nom;
	}

	/**
	 * DÃ©finit la description de la capacitÃ©
	 * 
	 * @param description
	 *            : description de la capacitÃ©
	 * @throws IllegalArgumentException
	 *             : en cas de description nulle, vide ou uniquement constituée
	 *             d'espaces
	 */
	public void setDescription(String description) {
		if (description == null || description.isEmpty() || description.trim().isEmpty())
			throw new IllegalArgumentException("Nom capacite invalide");
		this.description = description;
	}

	/**
	 * Donne la description de la capacitÃ©
	 * 
	 * @return description
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * Affichage
	 */
	@Override
	public String toString() {
		return "Capacite [nom=" + nom + ", description=" + description + "]";
	}

}