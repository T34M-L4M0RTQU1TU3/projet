package player;

import java.util.ArrayList;

import capacite.Capacite;
import cartes.Icarte;
import exceptions.HeartStoneException;

/**
 * Classe abstraite : pour un héros séléctionné par un joueur
 * @author JHIDRI GILLOT
 * @see Chasseur Mage
 */
public abstract class Hero {

	private String nom;
	private int vie ;
	static final int PDVMAX = 15;

	/**
	 * @param nom : nom du héros
	 */
	public Hero(String nom) {
		setNom(nom);
		setVie(PDVMAX);
	}

	/**
	 * Donne le nom du héros
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Définit le nom du héros
	 * @param nom : nom du héros
	 * @throws illegalArgumentException : nom du hero null , vide ou chaine d'espaces
	 */
	public void setNom(String nom) {
		if (nom == null || nom.isEmpty() || nom.trim().isEmpty())
			throw new IllegalArgumentException("Nom Heros invalide");
		this.nom = nom;
	}

	/**
	 * Donne la vie du héros
	 * @return vie
	 */
	public int getVie() {
		return vie;
	}

	/**
	 * Définit la vie du héros
	 * @param vie : vie du héros
	 */
	public void setVie(int vie) {
		this.vie = vie;
	}

	/**
	 * Donne la capacité du héros 
	 */
	public abstract Capacite getCapacite();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	
	/**
	 * Affichage
	 */
	@Override
	public String toString() {
		return "Hero [nom=" + nom + ", pointsDeVieCourant=" + vie + ",pointsDeVieMax=" + PDVMAX + "]";
	}
	
	/**
	 * Ajoute au deck les cartes spécifiques au héros
	 * @return ArrayList de carte
	 */
	public abstract ArrayList<Icarte> deckSpecial() throws HeartStoneException;

}