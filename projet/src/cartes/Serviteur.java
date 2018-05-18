package cartes;

import capacite.*;
import player.*;

/**
 * Un serviteur qui se bat pour un joueur
 * @author JHIDRI GILLOT
 */
public class Serviteur extends Carte {
	private int attaque;
	private int vie;
	private Capacite capacite ;
	private boolean jouable = false ;
	private int frappeParTour = 0 ;

	/**
	 * @param nom : nom du serviteur
	 * @param cout : coût en mana du serviteur
	 * @param attaque : points d'attaque du serviteur
	 * @param vie : vie du serviteur
	 * @param capacite : capacité du au serviteur
	 * @param j : joueur propriétaire de la carte
	 */
	public Serviteur(String nom, int cout,int attaque,int vie,Capacite capacite,Ijoueur j) {
		super(nom, cout,j);
		setVie(vie);
		setAttaque(attaque);
		setCapacite(capacite);
		if(capacite instanceof Charge)
			setJouable(true);	
	}

	/**
	 * Donne une copie du serviteur
	 * @return clone
	 */
	public Serviteur clone(){

		Serviteur clone = new Serviteur(this.getNom(),this.getCout(),this.attaque,this.getVie(),this.getCapacite(),this.getProprietaire());
		return clone;
	}

	/**
	 * Donne la vie du serviteur
	 * @return vie
	 */
	public int getVie() {
		return vie;
	}

	/**
	 * Définit la vie du serviteur
	 * @param vie : vie du serviteur
	 */
	public void setVie(int vie) {
		// A revoir pour vie < 0		
		this.vie = vie;
	}

	/**
	 * Donne l'attaque du serviteur
	 * @return attaque
	 */
	public int getAttaque() {
		return attaque;
	}

	/**
	 * Définit les points d'attaque du serviteur
	 * @param attaque : attaque du serviteur
	 */
	public void setAttaque(int attaque) {
		if(attaque < 0)
			throw new IllegalArgumentException("Attaque serviteur Invalide");
		this.attaque = attaque;
	}

	/**
	 * Donne la capacité du serviteur
	 * @return capacite
	 */
	public Capacite getCapacite() {
		return capacite;
	}

	/**
	 * Définit la capacité du serviteur
	 * @param capacite : capacité du serviteur
	 */
	public void setCapacite(Capacite capacite) {
		this.capacite = capacite;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * true si le serviteur peux attaquer, false sinon
	 * @return jouable
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

	/**
	 * Affichage
	 */
	@Override
	public String toString() {
		return "Serviteur [ "+super.toString()+" attaque=" + attaque + ", vie=" + vie + " ] " + capacite;
	}

	/**
	 * Détermine si un serviteur est mort ou non
	 */
	@Override
	public Boolean disparait() {
		if ( this.getVie() <= 0)
		{
			return true ;}
		return false ;
	}

	/**
	 * Fait attaquer le serviteur à la demande du joueur 
	 * @param cible : le héros adverse ou un serviteur adverse
	 */
	@Override
	public void executerAction(Object cible) {
		if( cible == null )
			throw new IllegalArgumentException("cible null");
		if(!jouable)
			throw new IllegalArgumentException("ce serviteur est en etat Zombie !");
		if ( this.frappeParTour  != 0)
			throw new IllegalArgumentException("Ce serviteur Ã  dÃšja cracher le morceau");
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
			if(((Serviteur) cible).getCapacite() instanceof Provocation)
			{ // La cible a Provocation
				((Serviteur) cible).setVie(((Serviteur) cible).getVie()-getAttaque());
				setVie(getVie()-((Serviteur) cible).getAttaque());
				if(disparait() ) 
				{
					executerEffetDisparition(this);
					getProprietaire().perdreCarte(this) ;							
				}
				this.frappeParTour++;

				if(((Serviteur) cible).disparait())
				{
					executerEffetDisparition(((Serviteur) cible));
					((Serviteur)cible).getProprietaire().perdreCarte(((Serviteur) cible));
				}
			}else { // La cible n'a pas provocation
				for(  Icarte c : ((Serviteur)cible).getProprietaire().getJeu() )
					if ( ((Serviteur)c).getCapacite() instanceof Provocation )
						// Un des serviteurs de l'adversaire a Provocation
						throw new IllegalArgumentException("vous ne pouvez pas attaquer le hero tant qu'il a un serviteur ayant Provocation");
				// Aucun serviteur de l'adversaire possede Provocation
				((Serviteur) cible).setVie(((Serviteur) cible).getVie()-getAttaque());
				setVie(getVie()-((Serviteur) cible).getAttaque());
				if(disparait() ) 
				{
					executerEffetDisparition(this);
					getProprietaire().perdreCarte(this) ;							
				}
				this.frappeParTour++;
				if(((Serviteur) cible).disparait())
				{
					executerEffetDisparition(((Serviteur) cible));
					((Serviteur)cible).getProprietaire().perdreCarte(((Serviteur) cible));
				}
			}
		}
	}

	/**
	 * Ajoute le serviteur au jeu du joueur et lance l'effet de mise en jeu de sa capacité
	 * @param cible : cible de la capacité
	 */
	@Override
	public void executerEffetDebutMiseEnJeu(Object cible) {
		((Joueur)getProprietaire()).addJeu(this);
		if( capacite != null)
			capacite.executerEffetMiseEnJeu(cible);
		}

	/**
	 * Lance l'effet de début de tour de la capacité du serviteur
	 * @param cible : cible de la capacité
	 */
	@Override
	public void executerEffetDebutTour(Object cible) {
		if( capacite != null)
			capacite.executerEffetDebutTour();
	}


	/**
	 * Lance l'effet de disparition de la capacité du serviteur
	 * @param cible : cible de la capacité
	 */
	@Override
	public void executerEffetDisparition(Object cible) {
		
		if( capacite != null)
			capacite.executerEffetDisparition(this);		
	}


	/**
	 * Lance l'effet de fin de tour de la capacité du serviteur
	 * @param cible : cible de la capacité
	 */
	@Override
	public void executerEffetFinTour(Object cible) {
		if( capacite != null)
			capacite.executerEffetFinTour();
		setJouable(true);
		this.frappeParTour=0;
	}

	/**
	 * Donne le nombre de frappe par tour du serviteur
	 * @return frappeParTour
	 */
	public int getNbre() {
		return frappeParTour;
	}

	/**
	 * Définit le nombre de frappe par tour du serviteur
	 * @param nbre : nombre de frappe par tour
	 */
	public void setNbre(int nbre) {
		if( nbre < 0)
			throw new IllegalArgumentException("Frappe par tour Invalide");
		this.frappeParTour = nbre;
	}

}