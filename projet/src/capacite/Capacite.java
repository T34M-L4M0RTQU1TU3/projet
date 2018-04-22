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
		this.nom = nom;
		this.description = description;
	}

	/**
	 * @param nom
	 *
	 */
	protected void setNom(String nom) {
		this.nom = nom;
	}
	/* (non-Javadoc)
	 * @see capacite.Icapacite#getNom()
	 */
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

	/* (non-Javadoc)
	 * @see capacite.Icapacite#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	
	
	/* (non-Javadoc)
	 * @see capacite.Icapacite#executerAction(java.lang.Object)
	 */
	@Override
	public void executerAction(Object cible) {
	}

	/* (non-Javadoc)
	 * @see capacite.Icapacite#executerEffetDebutTour(java.lang.Object)
	 */
	@Override
	public void executerEffetDebutTour(Object cible) {
	}

	/* (non-Javadoc)
	 * @see capacite.Icapacite#executerEffetDisparition(java.lang.Object)
	 */
	@Override
	public void executerEffetDisparition(Object cible) {
	}

	/* (non-Javadoc)
	 * @see capacite.Icapacite#executerEffetMiseEnJeu(java.lang.Object)
	 */
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Capacite [nom=" + nom + ", description=" + description + "]";
	}
}
