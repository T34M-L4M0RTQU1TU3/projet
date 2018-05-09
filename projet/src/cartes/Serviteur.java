package cartes;



import capacite.*;
import player.*;


public class Serviteur extends Carte {
		private int attaque;
		private int vie;
		private Capacite capacite ;
		private boolean jouable = false ;
		
		private int frappeParTour = 0 ;
	
	public Serviteur(String nom, int cout,int attaque,int vie,Capacite capacite,Ijoueur j) {
		super(nom, cout,j);
		setVie(vie);
		setAttaque(attaque);
		setCapacite(capacite);
		if(capacite instanceof Charge)
			setJouable(true);	
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
		{
			return true ;}
		return false ;
	}

	@Override
	public void executerAction(Object cible) {
			if( cible == null )
				throw new IllegalArgumentException("cible null");
			
			
			if(!jouable)
			{
				throw new IllegalArgumentException("ce serviteur est en etat Zombie !");
			}
			
			
			if ( this.frappeParTour  != 0)
				throw new IllegalArgumentException("Ce serviteur à dèja cracher le morceau");
			
			
			if (cible instanceof Joueur )
				{
				for(  Icarte c : ((Joueur) cible).getJeu() )
					if ( ((Serviteur)c).getCapacite() instanceof Provocation )
						throw new IllegalArgumentException("vous ne pouvez pas attaquer le hero tant qu'il a un serviteur ayant Provocation");
				((Joueur) cible).getHero().setVie(((Joueur) cible).getHero().getVie()-getAttaque());
				this.frappeParTour++;
				if (((Joueur) getProprietaire()).getPlateau().getAdversaire(getProprietaire()).getHero().getVie() <= 0)
				((Joueur) getProprietaire()).getPlateau().gagnePartie(getProprietaire());
				}
		
			if(cible instanceof Serviteur)
				{
					((Serviteur) cible).setVie(((Serviteur) cible).getVie()-getAttaque());
					setVie(getVie()-((Serviteur) cible).getAttaque());
					if(disparait() ) 
						{
							getProprietaire().getJeu().remove(this) ;
							executerEffetDisparition(this);
						}
					this.frappeParTour++;

					if(((Serviteur) cible).disparait())
						{
							executerEffetDisparition(((Serviteur) cible));
							((Joueur) getProprietaire()).getPlateau().getAdversaire(getProprietaire()).getJeu().remove(((Serviteur) cible));
				
						}
				}
	}

	@Override
	public void executerEffetDebutMiseEnJeu(Object cible) {
		((Joueur)getProprietaire()).addJeu(this);
			
		if( capacite != null)
			capacite.executerEffetMiseEnJeu(cible);
	}

	@Override
	public void executerEffetDebutTour(Object cible) {
		if( capacite != null)
		capacite.executerEffetDebutTour();

	}

	@Override
	public void executerEffetDisparition(Object cible) {
		if( capacite != null)
		capacite.executerEffetDisparition(this);

	}

	@Override
	public void executerEffetFinTour(Object cible) {
		if( capacite != null)
		capacite.executerEffetFinTour();
		setJouable(true);
		this.frappeParTour=0;

	}

	/**
	 * @return the nbre
	 */
	public int getNbre() {
		return frappeParTour;
	}

	/**
	 * @param nbre the nbre to set
	 */
	public void setNbre(int nbre) {
		this.frappeParTour = nbre;
	}

	
	
	

}
