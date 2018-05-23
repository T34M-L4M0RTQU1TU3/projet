package capacite;

import cartes.Icarte;
import cartes.Serviteur;
import exceptions.HeartStoneException;
import player.*;

/**
 * Invoque un serviteur spécifique
 * 
 * @author JHIDRI GILLOT
 */
public class InvocationDeServiteur extends Invocation {

	/**
	 * Invoque un serviteur spécifique
	 * 
	 * @param attaque
	 *            : attaque du serviteur
	 * @param vie
	 *            : vie du serviteur
	 * @param c
	 *            : capacité du serviteur
	 * @param j
	 *            : joueur propriétaire du serviteur
	 * @param nomServiteur
	 *            : nom du serviteur
	 */
	public InvocationDeServiteur(String nom, int attaque, int vie, Capacite c, Ijoueur j, String nomServiteur) throws HeartStoneException {
		super(nom, "Invoque un \"" + nomServiteur + "\" " + attaque + "/" + vie,
				new Serviteur(nomServiteur, 0, attaque, vie, c, j));
	}

	/**
	 * Invoque un serviteur
	 * 
	 * @param attaque
	 *            : attaque du serviteur
	 * @param vie
	 *            : vie du serviteur
	 * @param c
	 *            : capacité du serviteur
	 * @param j
	 *            : joueur propriétaire du serviteur
	 */
	public InvocationDeServiteur(String nom, int attaque, int vie, Capacite c, Ijoueur j) throws HeartStoneException {
		super(nom, "Invoque un serviteur " + attaque + "/" + vie, new Serviteur("serviteur", 0, attaque, vie, c, j));
	}

	/**
	 * Affichage
	 */
	@Override
	public String toString() {
		return "Capacite [nom =" + getNom() + ", description=" + getDescription() + "]";
	}

	/**
	 * Invocation d'un serviteur à  la demande du joueur ( Pouvoir du Héros )
	 * 
	 * @param cible
	 *            : joueur propriétaire du serviteur
	 * @throws HeartStoneException
	 *             : si la cible est nulle
	 */
	@Override
	public void executerAction(Object cible) throws HeartStoneException {
		if (cible == null)
			throw new HeartStoneException("Propriétaire de l'invocation null");
		((Joueur) cible).addJeu(getServiteur());
	}

	/**
	 * Aucun effet pour InvocationDeServiteur en début de tour
	 */
	@Override
	public void executerEffetDebutTour() {
		// nothing
	}

	/**
	 * Aucun effet pour InvocationDeServiteur à  la disparition de la carte
	 */
	@Override
	public void executerEffetDisparition(Object cible) {
		// nothing
	}

	/**
	 * Invocation d'un serviteur à  la mise en jeu de la carte
	 * 
	 * @param cible
	 *            : joueur propriétaire du serviteur
	 * @throws HeartStoneException:
	 *             si la cible est nulle
	 */
	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HeartStoneException {
		if (cible == null)
			throw new HeartStoneException("Propriétaire de l'invocation null");
		Serviteur s = getServiteur().clone();
	
		for (Icarte c : ((Joueur) cible).getJeu()) {
			if (((Serviteur) c).getCapacite() instanceof EffetPermanent) {
				int boosteVie = ((EffetPermanent) ((Serviteur) c).getCapacite()).getbPDV();
				s.setVie(s.getVie() + boosteVie);
				int boosteAttaque = ((EffetPermanent) ((Serviteur) c).getCapacite()).getbPAT();
				s.setAttaque(s.getAttaque() + boosteAttaque);
			}
		}
		((Joueur) cible).addJeu(s);
	}

	/**
	 * Aucun effet pour InvocationDeServiteur en fin de tour
	 */
	@Override
	public void executerEffetFinTour() {
		// nothing
	}

}