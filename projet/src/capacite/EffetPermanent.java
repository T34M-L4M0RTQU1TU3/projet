package capacite;


import cartes.Icarte;
import cartes.Serviteur;
import player.Joueur;

public class EffetPermanent extends Capacite {

	private int bPDV ;
	private int bPAT ;
	/**
	 * @param nom,description @see Capacite 
	 * @param bPDV   le nbre de point de booste point de vie 
	 * @param bPAT   le nbre de point de booste point d'attaque
	 */
	
	public EffetPermanent(String nom,int bPAT , int bPDV ) {
		super("Bonus de "+nom, "Vos autres serviteurs ont +"+bPAT+"/+"+bPDV+"");
		setbPDV(bPDV);
		setbPAT(bPAT);
	}

	/**
	 * @return the bPDV
	 */
	protected int getbPDV() {
		return bPDV;
	}

	/**
	 * @param bPDV the bPDV to set
	 */
	protected void setbPDV(int bPDV) {
		this.bPDV = bPDV;
	}

	/**
	 * @return the bPAT
	 */
	protected int getbPAT() {
		return bPAT;
	}

	/**
	 * @param bPAT the bPAT to set
	 */
	protected void setbPAT(int bPAT) {
		this.bPAT = bPAT;
	}

	@Override
	public void executerAction(Object cible) {
		for( Icarte c : ((Joueur) cible).getJeu() )
		{
			((Serviteur) c).setVie(((Serviteur) c).getVie() + getbPDV()) ;
			((Serviteur) c).setAttaque(((Serviteur) c).getAttaque() + getbPAT()) ;
		}
	}

	@Override
	public void executerEffetDebutTour() {
		//nothing
		
	}

	@Override
	public void executerEffetDisparition(Object cible) {
		for( Icarte c : ((Serviteur) cible).getProprietaire().getJeu() )
		{
			((Serviteur) c).setVie(((Serviteur) c).getVie() - getbPDV()) ;
			((Serviteur) c).setAttaque(((Serviteur) c).getAttaque() - getbPAT()) ;
		}
		
	}

	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		for( Icarte c : ((Joueur) cible).getJeu() )
		{
			((Serviteur) c).setVie(((Serviteur) c).getVie() + getbPDV()) ;
			((Serviteur) c).setAttaque(((Serviteur) c).getAttaque() + getbPAT()) ;
		}
		
	}

	@Override
	public void executerEffetFinTour() {
		//nothing
	}


	

}
