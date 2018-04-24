package capacite;

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
		//une capacité EffetPermanent est d'abords une capacité puis elle a 2 champs
		//bPDV la valeur de booste de point de vie
		//bPAT la valeur de booste de point d'attaque
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


	

}
