package cartes;

import capacite.*;
import player.*;


public class Sort extends Carte {
	private Capacite capacite ;
	public Sort(String nom, int cout,Capacite c,Ijoueur j) {
		super(nom, cout,j);
		setCapacite(c);
	}
	/**
	 * @return the capacite
	 */
	public Capacite getCapacite() {
		return capacite;
	}
	/**
	 * @param capacite the capacite to set
	 */
	public void setCapacite(Capacite capacite) {
		this.capacite = capacite;
	}
	
	@Override
	public String toString() {
		return "Sort [ "+super.toString()+" ] " + capacite;
	}
	

	@Override
	public Boolean disparait() {
	
		return true;
	}

	@Override
	public void executerAction(Object cible) {
		capacite.executerAction(cible);
			getProprietaire().perdreCarte(this);

	}

	@Override
	public void executerEffetDebutMiseEnJeu(Object cible) {
		capacite.executerEffetMiseEnJeu(cible);
			getProprietaire().perdreCarte(this);
	}

	@Override
	public void executerEffetDebutTour(Object cible) {
		capacite.executerEffetDebutTour();
			getProprietaire().perdreCarte(this);
	}

	@Override
	public void executerEffetDisparition(Object cible) {
		capacite.executerEffetDisparition(cible);
		getProprietaire().perdreCarte(this);
	}

	@Override
	public void executerEffetFinTour(Object cible) {
		capacite.executerEffetFinTour();
		getProprietaire().perdreCarte(this);
	}

}
