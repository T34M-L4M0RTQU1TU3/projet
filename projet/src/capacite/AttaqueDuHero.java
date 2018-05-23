package capacite;

import exceptions.HeartStoneException;
import player.Ijoueur;

import player.Joueur;

/**
 * Attaque infligée à  un héros
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
	 * Attaque le héros adverse à  la demande du joueur ( Pouvoir du Héros )
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
	 * Aucun effet pour AttaqueDuHero en début de tour
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
	 * Attaque le héros adverse à  la mise en jeu de la carte
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