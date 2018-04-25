package cartes;

import capacite.*;
import player.*;


public class Serviteur extends Carte {
		private int attaque;
		private int vie;
		private Capacite capacite ;
		
	public Serviteur(String nom, int cout,int attaque,int vie,Capacite capacite) {
		super(nom, cout);
		setVie(vie);
		setAttaque(attaque);
		setCapacite(capacite);
	}

	/**
	 * @return the vie
	 */
	public int getVie() {
		return vie;
	}

	/**
	 * @param vie the vie to set
	 */
	public void setVie(int vie) {
		this.vie = vie;
	}

	/**
	 * @return the attaque
	 */
	public int getAttaque() {
		return attaque;
	}

	/**
	 * @param attaque the attaque to set
	 */
	public void setAttaque(int attaque) {
		this.attaque = attaque;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Serviteur [ "+super.toString()+" attaque=" + attaque + ", vie=" + vie + " ] " + capacite;
	}


	@Override
	public Boolean disparait() {
		if ( this.getVie() <= 0)
			return true ;
		return false ;
	}

	@Override
	public void executerAction(Object cible) {
		if (cible instanceof Hero )
			((Hero) cible).setVie(((Hero) cible).getVie()-getAttaque());
		
		if(cible instanceof Serviteur)
			{
			((Serviteur) cible).setVie(((Serviteur) cible).getVie()-getAttaque());
			setVie(getVie()-((Serviteur) cible).getAttaque());
			if(disparait() ) 
				 getProprietaire().getJeu().remove(this) ;
				((Serviteur) cible).disparait();
			}

	}

	@Override
	public void executerEffetDebutMiseEnJeu(Object cible) {
	
			getProprietaire().getJeu().add(this);
			if(this.getCapacite() instanceof EffetPermanent || this.getCapacite() instanceof Attaque || this.getCapacite() instanceof Invocation )
				capacite.executerEffetMiseEnJeu(cible);

	}

	@Override
	public void executerEffetDebutTour(Object cible) {
		capacite.executerEffetDebutTour();

	}

	@Override
	public void executerEffetDisparition(Object cible) {
		capacite.executerEffetDisparition(cible);

	}

	@Override
	public void executerEffetFinTour(Object cible) {
		capacite.executerEffetFinTour();

	}
	
	

	
	

}
