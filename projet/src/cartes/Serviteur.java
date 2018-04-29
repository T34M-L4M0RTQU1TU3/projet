package cartes;

import java.util.ArrayList;

import capacite.*;
import player.*;


public class Serviteur extends Carte {
		private int attaque;
		private int vie;
		private Capacite capacite ;
		private boolean jouable = false ;
		
	public Serviteur(String nom, int cout,int attaque,int vie,Capacite capacite,Ijoueur j) {
		super(nom, cout,j);
		setVie(vie);
		setAttaque(attaque);
		setCapacite(capacite);

	}
	
	public Serviteur clone(){
		
		Serviteur clone = new Serviteur(this.getNom(),this.getCout(),this.attaque,this.getVie(),this.getCapacite(),this.getProprietaire());
		return clone;
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
	/**
	 * @return the jouable
	 */
	public boolean isJouable() {
		return jouable;
	}

	/**
	 * @param jouable the jouable to set
	 */
	public void setJouable(boolean jouable) {
		this.jouable = jouable;
	}
	
	

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
			if(!jouable)
			{
				throw new IllegalArgumentException("ce serviteur est en etat Zombie !");
			}
			if (cible instanceof Joueur )
				((Joueur) cible).getHero().setVie(((Joueur) cible).getHero().getVie()-getAttaque());
		
			if(cible instanceof Serviteur)
				{
				((Serviteur) cible).setVie(((Serviteur) cible).getVie()-getAttaque());
				setVie(getVie()-((Serviteur) cible).getAttaque());
				if(disparait() ) 
					{
					getProprietaire().getJeu().remove(this) ;
					executerEffetDisparition(cible);
					}
			
				if (((Serviteur) cible).disparait()) 
					{
					((Carte) cible).getProprietaire().getJeu().remove((Serviteur) cible);
					((Carte) cible).executerEffetDisparition(((Carte) cible).getProprietaire());
					}
				}
		
	}

	@Override
	public void executerEffetDebutMiseEnJeu(Object cible) {
		if(this.capacite instanceof Charge)
			setJouable(true);	
		((Joueur)getProprietaire()).addJeu(this);
			
			if (capacite != null ) 
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
		setJouable(true);

	}

	
	
	

}
