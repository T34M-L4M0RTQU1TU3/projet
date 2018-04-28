package cartes;

import player.*;

public abstract class Carte implements Icarte {

	private String nom ;
	private int cout ;
	private Ijoueur joueur ;
	/**
	 * @param nom
	 * @param cout
	 */
	public Carte(String nom, int cout,Ijoueur joueur) {
		setJoueur(joueur);
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
	/**
	 * @return the joueur
	 */
	
	@Override
	public Ijoueur getProprietaire() {
		return joueur;
	}

	/**
	 * @param joueur the joueur to set
	 */
	public void setJoueur(Ijoueur joueur) {
		this.joueur = joueur;
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

	@Override
	public String toString() {
		return "Carte [ nom=" + nom + ", cout=" + cout + " ]";
	}




}
