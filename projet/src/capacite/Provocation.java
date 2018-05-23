package capacite;

/**
 * Oblige le camp adverse à détruire ce serviteur avant d'attaquer le héros
 * ou un autre serviteur
 * 
 * @author JHIDRI GILLOT
 *
 */
public class Provocation extends Capacite {

	/**
	 * @see Capacite
	 */
	public Provocation() {
		super("Provocation", "Les attaques n'atteindront pas votre Héros");
	}

	/**
	 * Aucun effet pour Provocation à la mise en jeu de la carte
	 * 
	 * @param cible
	 *            : serviteur affecté par Provocation
	 */
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		// nothing
	}

	/**
	 * Aucun effet pour Provocation à la demande du joueur
	 * 
	 * @param cible
	 *            : serviteur affecté par Provocation
	 */
	@Override
	public void executerAction(Object cible) {
		// nothing
	}

	/**
	 * Aucun effet pour Provocation en début de tour
	 */
	@Override
	public void executerEffetDebutTour() {
		// nothing
	}

	/**
	 * Aucun effet pour Provocation à la disparition de la carte
	 * 
	 * @param cible
	 *            : serviteur affecté par Provocation
	 */
	@Override
	public void executerEffetDisparition(Object cible) {
		// nothing
	}

	/**
	 * Aucun effet pour Provocation en fin de tour
	 */
	@Override
	public void executerEffetFinTour() {
		// nothing
	}

}