package capacite;

import exceptions.HeartStoneException;
import player.Ijoueur;

import player.Joueur;

/**
 * Attaque infligÃ©e Ã  un hÃ©ros
 * 
 * @author JHIDRI GILLOT
 */
public class AttaqueDuHero extends Attaque {

	/**
	 * @see Attaque
	 */
	public AttaqueDuHero(String nom, int degats) {
		super(nom, "inflige " + degats + " points de dégats au héros adverse", degats);
	}

	/**
	 * Affichage
	 */
	@Override
	public String toString() {
		return "Capacite [nom=" + getNom() + ", description=" + getDescription() + "]";
	}

	/**
	 * Attaque le hÃ©ros adverse Ã  la demande du joueur ( Pouvoir du HÃ©ros )
	 * 
	 * @param cible
	 *            : le joueur souhaitant attaquer
	 * @throws HeartStoneException
	 *             : si la cible est nulle
	 */
	@Override
	public void executerAction(Object cible) throws HeartStoneException {
		if (cible == null)
			throw new HeartStoneException("Propriétaire de l'attaque du héros null");
		Ijoueur adversaire = ((Joueur) cible).getPlateau().getAdversaire((Ijoueur) cible);

		adversaire.getHero().setVie(adversaire.getHero().getVie() - getDegats());
		if (adversaire.getHero().getVie() <= 0)
			((Joueur) cible).getPlateau().gagnePartie(((Joueur) cible));
	}

	/**
	 * Aucun effet pour AttaqueDuHero en dÃ©but de tour
	 */
	@Override
	public void executerEffetDebutTour() {
		// Nothing
	}

	/**
	 * Aucun effet pour AttaqueDuHero a la disparition d'une carte
	 */
	@Override
	public void executerEffetDisparition(Object cible) {
		// Nothing
	}

	/**
	 * Attaque le hÃ©ros adverse Ã  la mise en jeu de la carte
	 * 
	 * @param cible
	 *            : le joueur souhaitant attaquer
	 * @throws HeartStoneException
	 *             : si la cible est nulle
	 */
	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HeartStoneException {
		if (cible == null)
			throw new HeartStoneException("Propriétaire attaque totale null");
		Ijoueur adversaire = ((Joueur) cible).getPlateau().getAdversaire((Ijoueur) cible);
		adversaire.getHero().setVie(adversaire.getHero().getVie() - getDegats());
		if (adversaire.getHero().getVie() <= 0)
			((Joueur) cible).getPlateau().gagnePartie(((Joueur) cible));
	}

	/**
	 * Aucun effet pour AttaqueDuHero en fin de tour
	 */
	@Override
	public void executerEffetFinTour() {
		// Nothing
	}

}