package capacite;

/**
 * Classe abstraite qui implémente Icapacite
 * 
 * @author JHIDRI GILLOT  
 * @see capacite.Provocation
 * @see capacite.Piocher
 * @see capacite.Attaque
 * @see capacite.Invocation
 * @see capacite.EffetPermanent
 */
public abstract class Capacite implements Icapacite {

	private String nom;
	private String description;

	/**
	 * @param nom
	 *            : nom de la capacité
	 * @param description
	 *            : description de la capacité
	 * @throws IllegalArgumentException
	 *             : en cas de nom null, vide ou uniquement constitué d'espaces
	 */
	public Capacite(String nom, String description) {
		setNom(nom);
		setDescription(description);
	}

	/**
	 * Définit le nom de la capacité
	 * 
	 * @param nom
	 *            : nom de la capacité
	 */
	public void setNom(String nom) {
		if (nom == null || nom.isEmpty() || nom.trim().isEmpty())
			throw new IllegalArgumentException("Nom capacite invalide");
		this.nom = nom;
	}

	/**
	 * Donne le nom de la capacité
	 * 
	 * @return nom
	 */
	@Override
	public String getNom() {
		return nom;
	}

	/**
	 * Définit la description de la capacité
	 * 
	 * @param description
	 *            : description de la capacité
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
	 * Donne la description de la capacité
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