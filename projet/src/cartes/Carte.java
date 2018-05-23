package cartes;

import player.*;

/**
 * Classe abstraite : pour les différents types de cartes 
 * @author JHIDRI GILLOT
 * @see cartes.Serviteur 
 * @see cartes.Sort
 */
public abstract class Carte implements Icarte {

	private String nom ;
	private int cout ;
	private Ijoueur joueur ;
	
	/**
	 * @param nom : nom de la carte
	 * @param cout : coût en mana de la carte
	 * @param joueur : propriétaire de la carte
	 */
	public Carte(String nom, int cout,Ijoueur joueur) {
		setJoueur(joueur);
		setCout(cout);
		setNom(nom);		
	}

	/**
	 * Définit le nom de la carte
	 * @param nom : nom de la carte
	 * @throws IllegealArgumentException : en cas de nom null,vide ou uniquement constitué d'espaces 
	 */
	public void setNom(String nom) {
		if (nom == null || nom.isEmpty() || nom.trim().isEmpty() )
			throw new IllegalArgumentException("Nom Carte invalide");
		this.nom = nom;
	}

	/**
	 * Donne le nom de la carte
	 */
	@Override
	public String getNom() {
		return nom;
	}

	/**
	 * Définit le cout de la carte
	 * @param cout : coût de la carte
	 * @throws IllegealArgumentException : cout de la carte invalide < 0 ou > 10
	 */
	public void setCout(int cout) {
		if ( cout < 0 || cout > 10 )
			throw new IllegalArgumentException("Cout Invalide");
		this.cout = cout;
	}

	/**
	 * Donne le coût de la carte
	 */
	@Override
	public int getCout() {	
		return cout;
	}
	
	/**
	 * Donne le propriétaire de la carte
	 */
	@Override
	public Ijoueur getProprietaire() {
		return joueur;
	}

	/**
	 * Définit le propriétaire de la carte
	 * @param joueur : propriétaire de la carte
	 */
	public void setJoueur(Ijoueur joueur) {
		this.joueur = joueur;
	}

	/**
	 * Affichage
	 */
	@Override
	public String toString() {
		return "Carte [ nom=" + nom + ", cout=" + cout + " ]";
	}

}