package capacite;

import cartes.*;
import exceptions.CibleNullException;
import exceptions.HeartStoneException;
import player.Joueur;

/**
 * Une attaque inflige  des dégats à une cible donnée (héros ou serviteur)
 * 
 * @author JHIDRI GILLOT
 * @see Marque @see Charge
 */
public class AttaqueCible extends Attaque {

	/**
	 * @see Attaque
	 */
	public AttaqueCible(String nom, int degats) {
		super(nom, "inflige " + degats + " points de dégats  à  la cible ", degats);
	}

	/**
	 * Affichage
	 */
	@Override
	public String toString() {
		return "Capacite [nom=" + getNom() + ", description=" + getDescription() + "]";
	}

	/**
	 * Attaque la cible donnée à  la mise en jeu de la carte
	 * 
	 * @param cible
	 *            : cible à  attaquer
	 * @throws HeartStoneException
	 *             : si un serviteur adverse a Provocation et que la cible est un
	 *             autre serviteur ou le héros ou que la cible donnée est nulle
	 */
	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HeartStoneException {
		if (cible == null)
			throw new HeartStoneException("cible null ");
		if (cible instanceof Joueur) {
			for (Icarte c : ((Joueur) cible).getJeu())
				if (((Serviteur) c).getCapacite() instanceof Provocation)
					throw new HeartStoneException("vous ne pouvez pas attaquer le hero tant qu'il y a un serviteur ayant Provocation");

			((Joueur) cible).getHero().setVie(((Joueur) cible).getHero().getVie() - getDegats());

			if (((Joueur) cible).getHero().getVie() <= 0)
				((Joueur) cible).getPlateau()
						.gagnePartie(((Joueur) cible).getPlateau().getAdversaire(((Joueur) cible)));
		}
		if (cible instanceof Serviteur) {
			if (((Serviteur) cible).getCapacite() instanceof Provocation) { // La cible a Provocation
				((Serviteur) cible).setVie(((Serviteur) cible).getVie() - getDegats());
				if (((Serviteur) cible).disparait()) {
					executerEffetDisparition(((Serviteur) cible));
					((Serviteur) cible).getProprietaire().perdreCarte(((Serviteur) cible));
				}
			} else { // La cible n'a pas provocation
				for (Icarte c : ((Serviteur) cible).getProprietaire().getJeu())
					if (((Serviteur) c).getCapacite() instanceof Provocation)
						// Un des serviteurs de l'adversaire a Provocation
						throw new HeartStoneException(
								"vous ne pouvez pas attaquer ce serviteur tant qu'il y a un autre serviteur ayant Provocation");
				// Aucun serviteur de l'adversaire possede Provocation
				((Serviteur) cible).setVie(((Serviteur) cible).getVie() - getDegats());

				if (((Serviteur) cible).disparait()) {
					executerEffetDisparition(((Serviteur) cible));
					((Serviteur) cible).getProprietaire().perdreCarte(((Serviteur) cible));
				}
			}
		}
	}

	/**
	 * Attaque la cible donnée à  la demande du joueur ( Pouvoir du Héros )
	 * 
	 * @param cible
	 *            : cible à  attaquer
	 * @throws HeartStoneException
	 *             : si un serviteur adverse a Provocation et que la cible est un
	 *             autre serviteur ou le héros ou que la cible donnée est nulle
	 */
	@Override
	public void executerAction(Object cible) throws HeartStoneException {
		if (cible == null)
			throw new HeartStoneException("cible null ");
		if (cible instanceof Joueur) {
			if( ((Joueur )cible) == ((Joueur) cible ).getPlateau().getJoueurCourant())
				throw new CibleNullException("pas la bonne cible");
			for (Icarte c : ((Joueur) cible).getJeu())
				if (((Serviteur) c).getCapacite() instanceof Provocation)
					throw new HeartStoneException(
							"vous ne pouvez pas attaquer le hero tant qu'il y a un serviteur ayant Provocation");

			((Joueur) cible).getHero().setVie(((Joueur) cible).getHero().getVie() - getDegats());

			if (((Joueur) cible).getHero().getVie() <= 0)
				((Joueur) cible).getPlateau()
						.gagnePartie(((Joueur) cible).getPlateau().getAdversaire(((Joueur) cible)));
		}
		if (cible instanceof Serviteur) {
			if (((Serviteur) cible).getCapacite() instanceof Provocation) { // La cible a Provocation
				((Serviteur) cible).setVie(((Serviteur) cible).getVie() - getDegats());
				if (((Serviteur) cible).disparait()) {
					executerEffetDisparition(((Serviteur) cible));
					((Serviteur) cible).getProprietaire().perdreCarte(((Serviteur) cible));
				}
			} else { // La cible n'a pas provocation
				for (Icarte c : ((Serviteur) cible).getProprietaire().getJeu())
					if (((Serviteur) c).getCapacite() instanceof Provocation)
						// Un des serviteurs de l'adversaire a Provocation
						throw new HeartStoneException(
								"vous ne pouvez pas attaquer ce serviteur tant qu'il y a un autre serviteur ayant Provocation");
				// Aucun serviteur de l'adversaire possede Provocation
				((Serviteur) cible).setVie(((Serviteur) cible).getVie() - getDegats());

				if (((Serviteur) cible).disparait()) {
					executerEffetDisparition(((Serviteur) cible));
					((Serviteur) cible).getProprietaire().perdreCarte(((Serviteur) cible));
				}
			}
		}
	}

	/**
	 * Aucun effet pour AttaqueCiblee en début de tour
	 */
	@Override
	public void executerEffetDebutTour() {
		// nothing
	}

	/**
	 * Aucun effet pour AttaqueCiblee à  la dispartition de la carte
	 * 
	 * @param cible
	 *            : cible à  attaquer
	 */
	@Override
	public void executerEffetDisparition(Object cible) {
		// nothing
	}

	/**
	 * Aucun effet pour AttaqueCiblee en fin de tour
	 */
	@Override
	public void executerEffetFinTour() {
		// nothing
	}

}