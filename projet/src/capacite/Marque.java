package capacite;

import cartes.Serviteur;
import exceptions.HeartStoneException;

/**
 * Modifie les points de vie d'un serviteur
 * 
 * @author JHIDRI GILLOT
 */
public class Marque extends AttaqueCible {
	private int pointDeVieApresLeMarquage;

	/**
	 * @see Attaque
	 * @param pointDeVieApresLeMarquage
	 *            : les points de vie du serviteur adverse aprÃšs le marquage
	 */
	public Marque(String nom, int pointDeVieApresLeMarquage) {
		super(nom, 0);
		setpointDeVieApresLeMarquage(pointDeVieApresLeMarquage);
	}

	/**
	 * Donne le nombre de points de vie du serviteur adverse aprÃšs le marquage
	 * 
	 * @return pointDeVieApresLeMarquage
	 */
	public int getpointDeVieApresLeMarquage() {
		return pointDeVieApresLeMarquage;
	}

	/**
	 * dÃ©finit la variable pointDeVieApresLeMarquage
	 * 
	 * @throws IllegalArgumentException
	 *             : si le nombre de points de vies après marquage donné est
	 *             inférieur ou égal à 0
	 */
	public void setpointDeVieApresLeMarquage(int pointDeVieApresLeMarquage) {
		if (pointDeVieApresLeMarquage <= 0)
			throw new IllegalArgumentException("Marque <=0 invalide");
		this.pointDeVieApresLeMarquage = pointDeVieApresLeMarquage;
	}

	/**
	 * Affichage
	 */
	@Override
	public String toString() {
		return "Capacite [nom=" + getNom() + ", description=Abaisse ÃÂ  " + getpointDeVieApresLeMarquage()
				+ " les points de vie du serviteur ciblÃÂ©]";
	}

	/**
	 * Marque sur la cible donnÃ©e Ã  la demande du joueur ( Pouvoir du HÃ©ros )
	 * 
	 * @throws HeartStoneException
	 *             : Si Marque est utilisée sur une cible autre qu'un serviteur ou
	 *             sur une cible nulle
	 */
	@Override
	public void executerAction(Object cible) throws HeartStoneException {
		if (cible == null)
			throw new HeartStoneException("Cible de la marque nulle");
		if (!(cible instanceof Serviteur))
			throw new HeartStoneException("Marque ne peut ÃÂªtre utilisée que sur un serviteur");

		((Serviteur) cible).setVie(getpointDeVieApresLeMarquage());

	}

	/**
	 * Marque sur la cible donnÃ©e Ã  la mise en jeu de la carte
	 * 
	 * @throws HeartStoneException
	 *             : Si Marque est utilisée sur une cible autre qu'un serviteur ou
	 *             sur une cible nulle
	 */
	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HeartStoneException {
		if (cible == null)
			throw new HeartStoneException("Cible de la marque nulle");
		if (!(cible instanceof Serviteur))
			throw new HeartStoneException("Marque ne peut ÃÂªtre utilisée que sur un serviteur");

		((Serviteur) cible).setVie(getpointDeVieApresLeMarquage());

	}

}