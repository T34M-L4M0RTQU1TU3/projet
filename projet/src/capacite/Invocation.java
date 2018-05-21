package capacite;

import cartes.Serviteur;
import exceptions.HeartStoneException;

/**
 * Invoque un/des serviteur(s) sur le jeu
 * 
 * @author JHIDRI GILLOT
 * @see ImageMirroir InvocationDeServiteur Multiclonage
 */
public abstract class Invocation extends Capacite {

	private Serviteur serviteur;

	/**
	 * @param nom
	 *            : nom de l'invocation
	 * @param description
	 *            : description de l'invocation
	 * @param s
	 *            : serviteur Ã  invoquer
	 */
	public Invocation(String nom, String description, Serviteur s) throws HeartStoneException {
		super(nom, description);
		setServiteur(s);
	}

	/**
	 * Donne le serviteur Ã  invoquer
	 * 
	 * @return s
	 */
	public Serviteur getServiteur() {
		return serviteur;
	}

	/**
	 * DÃ©finit le serviteur Ã  invoquer
	 * 
	 * @param s
	 *            : serviteur Ã  invoquer
	 * @throws HeartStoneException
	 *             : si le serviteur donné est null
	 */
	public void setServiteur(Serviteur s) throws HeartStoneException {
		if (s == null)
			throw new HeartStoneException("Serviteur invoque invalide");
		this.serviteur = s;
	}

}