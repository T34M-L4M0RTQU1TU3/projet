package capacite;

import exceptions.HeartStoneException;
import player.Joueur;

/**
 * Permet de piocher un certain nombre de cartes
 * 
 * @author JHIDRI GILLOT
 */
public class Piocher extends Capacite {

	private int nombre;

	/**
	 * @see Capacite
	 * @param nombre
	 *            : nombre de cartes Ã  piocher
	 */
	public Piocher(int nombre) {
		super("Piocher", "pioche " + nombre + " carte(s)");
		setNombre(nombre);
	}

	/**
	 * Donne le nombre de cartes Ã  piocher
	 * 
	 * @return nombre
	 */
	public int getNombre() {
		return nombre;
	}

	/**
	 * DÃ©finit le nombre de cartes Ã  piocher
	 * 
	 * @param nombre
	 *            : le nombre de cartes Ã  piocher
	 */
	public void setNombre(int nombre) {
		if (nombre <= 0)
			throw new IllegalArgumentException("Nombre pioche Invalide");
		this.nombre = nombre;
	}

	/**
	 * Pioche les cartes Ã  la demande du joueur ( Pouvoir du HÃ©ros )
	 * 
	 * @param cible
	 *            : joueur qui pioche
	 * @throws HeartStoneException
	 *             : si la taille du deck est inférieure au nombre de cartes à
	 *             piocher ou que la cible est nulle
	 */
	@Override
	public void executerAction(Object cible) throws HeartStoneException {
		if (cible == null)
			throw new HeartStoneException("Joueur qui pioche null");
		
		if (getNombre() > ((Joueur) cible).getDeck().size())
			throw new HeartStoneException("Il y a moins de " + getNombre() + "cartes restantes dans le deck");
		
		for (int i = 0; i < getNombre(); i++) {
			((Joueur) cible).piocher();
		}
	}

	/**
	 * Aucun effet pour Piocher en dÃ©but de tour
	 */
	@Override
	public void executerEffetDebutTour() {
		// nothing
	}

	/**
	 * Aucun effet pour Piocher Ã  la disparition de la carte
	 */
	@Override
	public void executerEffetDisparition(Object cible) {
		// nothing
	}

	/**
	 * Pioche les cartes Ã  la mise en jeu de la carte
	 * 
	 * @param cible
	 *            : joueur qui pioche
	 * @throws HeartStoneException
	 *             : si la taille du deck est inférieure au nombre de cartes à
	 *             piocher ou que la cible est nulle 
	 */
	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HeartStoneException {
		if (cible == null)
			throw new HeartStoneException("Joueur qui pioche null");
		if (getNombre() > ((Joueur) cible).getDeck().size())
			throw new HeartStoneException("Il y a moins de " + getNombre() + "cartes restantes dans le deck");
		for (int i = 0; i < getNombre(); i++) {
			((Joueur) cible).piocher();
		}
	}

	/**
	 * Aucun effet pour Piocher en fin de tour
	 */
	@Override
	public void executerEffetFinTour() {
		// nothing
	}

}