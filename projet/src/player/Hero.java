package player;

import java.util.ArrayList;

import capacite.Capacite;
import cartes.Icarte;

public abstract class Hero {

	private String nom;
	private int vie ;
	static final int PDVMAX = 15;

	/**
	 * @param nom
	 * @param vie
	 */
	public Hero(String nom) {
		setNom(nom);
		setVie(PDVMAX);
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		if (nom == null || nom.isEmpty() || nom.trim().isEmpty())
			throw new IllegalArgumentException("Nom Heros invalide");
		this.nom = nom;
	}

	/**
	 * @return the vie
	 */
	public int getVie() {
		return vie;
	}

	/**
	 * @param vie
	 *            the vie to set
	 */
	public void setVie(int vie) {
		this.vie = vie;
	}

	public abstract Capacite getCapacite();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hero [nom=" + nom + ", pointsDeVieCourant=" + vie + ",pointsDeVieMax=" + PDVMAX + "]";
	}

	public abstract ArrayList<Icarte> deckSpecial();

}