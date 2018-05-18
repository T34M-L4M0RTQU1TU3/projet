package capacite;

import cartes.Icarte;
import cartes.Serviteur;
import player.Joueur;

/**
 * Confère un bonus d'attaque et de vie aux serviteurs présents sur le jeu
 * @author JHIDRI GILLOT
 */
public class EffetPermanent extends Capacite {

	private int bPDV ;
	private int bPAT ;
	
	/**
	 * @param nom,description : @see Capacite 
	 * @param bPDV : boost de points de vie 
	 * @param bPAT : boost de points d'attaque
	 */	
	public EffetPermanent(String nom,int bPAT , int bPDV ) {
		super("Bonus de "+nom, "Vos autres serviteurs ont +"+bPAT+"/+"+bPDV+"");
		setbPDV(bPDV);
		setbPAT(bPAT);
	}

	/**
	 * Donne le boost de points de vie
	 * @return bPDV
	 */
	protected int getbPDV() {
		return bPDV;
	}

	/**
	 * Définit le boost de points de vie
	 * @param bPDV : boost de points de vie
	 */
	protected void setbPDV(int bPDV) {
		if(bPDV < 0)
			throw new IllegalArgumentException("Boost PDV invalide");
		this.bPDV = bPDV;
	}

	/**
	 * Donne le boost d'attaque
	 * @return bPAT
	 */
	protected int getbPAT() {
		return bPAT;
	}

	/**
	 * Définit le boost de points d'attaque
	 * @param bPAT : boost de points d'attaque
	 */
	protected void setbPAT(int bPAT) {
		if(bPAT < 0)
			throw new IllegalArgumentException("Boost PATT invalide");
		this.bPAT = bPAT;
	}
	
	/**
	 * Boost de vie et d'attaque à la demande du joueur ( Pouvoir du Héros )
	 */
	@Override
	public void executerAction(Object cible) {
		for( Icarte c : ((Joueur) cible).getJeu() )
		{
			((Serviteur) c).setVie(((Serviteur) c).getVie() + getbPDV()) ;
			((Serviteur) c).setAttaque(((Serviteur) c).getAttaque() + getbPAT()) ;
		}
	}

	/**
	 * Aucun effet pour EffetPermanent en début de tour 
	 */
	@Override
	public void executerEffetDebutTour() {
		//nothing		
	}

	/**
	 * Suppression des boost de vie et d'attaque à la disparition de la carte
	 */
	@Override
	public void executerEffetDisparition(Object cible) {
		for( Icarte c : ((Serviteur) cible).getProprietaire().getJeu() )
		{
			((Serviteur) c).setVie(((Serviteur) c).getVie() - getbPDV()) ;
			((Serviteur) c).setAttaque(((Serviteur) c).getAttaque() - getbPAT()) ;					
		}
	}

	/**
	 * Boost de vie et d'attaque à la mise en jeu de la carte
	 */
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		for( Icarte c : ((Joueur) cible).getJeu() )
		{
			((Serviteur) c).setVie(((Serviteur) c).getVie() + getbPDV()) ;
			((Serviteur) c).setAttaque(((Serviteur) c).getAttaque() + getbPAT()) ;
		}
	}

	/**
	 * Aucun effet pour EffetPermanent en début de tour 
	 */
	@Override
	public void executerEffetFinTour() {
		//nothing
	}
}