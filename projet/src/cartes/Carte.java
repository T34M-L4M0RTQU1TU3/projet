package cartes;

public abstract class Carte implements Icarte {

	private String nom ;
	private int cout ;
	
	/**
	 * @param nom
	 * @param cout
	 */
	public Carte(String nom, int cout) {

		setCout(cout);
		setNom(nom);
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String getNom() {
		return nom;
	}

	/**
	 * @param cout the cout to set
	 */
	public void setCout(int cout) {
		this.cout = cout;
	}

	@Override
	public int getCout() {
	
		return cout;
	}


	@Override
	public Boolean disparait() {
	
		return null;
	}

	@Override
	public void executerAction(Object cible) {
		

	}

	@Override
	public void executerEffetDebutMiseEnJeu(Object cible) {


	}

	@Override
	public void executerEffetDebutTour(Object cible) {
	

	}

	@Override
	public void executerEffetDisparition(Object cible) {
		

	}

	@Override
	public void executerEffetFinTour(Object cible) {
		

	}
	//@Override
	//Ijoueur getProprietaire();

	@Override
	public String toString() {
		return "Carte [ nom=" + nom + ", cout=" + cout + " ]";
	}


}
