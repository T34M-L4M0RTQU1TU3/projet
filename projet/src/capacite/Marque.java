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
	 *            : les points de vie du serviteur adverse aprés le marquage
	 */
	public Marque(String nom, int pointDeVieApresLeMarquage) {
		super(nom, 0);
		setpointDeVieApresLeMarquage(pointDeVieApresLeMarquage);
	}

	/**
	 * Donne le nombre de points de vie du serviteur adverse aprés le marquage
	 * 
	 * @return pointDeVieApresLeMarquage
	 */
	public int getpointDeVieApresLeMarquage() {
		return pointDeVieApresLeMarquage;
	}

	/**
	 * définit la valeur de la variable pointDeVieApresLeMarquage
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
		return "Capacite [nom=" + getNom() + ", description=Abaisse à " + getpointDeVieApresLeMarquage()
				+ " les points de vie du serviteur ciblée]";
	}

	/**
	 * Marque sur la cible donnée à  la demande du joueur ( Pouvoir du Héros )
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
			throw new HeartStoneException("Marque ne peut être utilisée que sur un serviteur");

		((Serviteur) cible).setVie(getpointDeVieApresLeMarquage());

	}

	/**
	 * Marque sur la cible donnée à  la mise en jeu de la carte
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
			throw new HeartStoneException("Marque ne peut être utilisée que sur un serviteur");

		((Serviteur) cible).setVie(getpointDeVieApresLeMarquage());

	}

}