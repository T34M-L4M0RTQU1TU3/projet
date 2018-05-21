package capacite;

import cartes.*;
import exceptions.HeartStoneException;
import player.*;

/**
 * Invoque autant de serviteurs que le nombre de seviteurs adverses ( propre Ã 
 * Rexxar )
 * 
 * @author JHIDRI GILLOT
 */
public class MultiClonage extends Invocation {

	/**
	 * @param attaque
	 *            : attaque des serviteurs
	 * @param vie
	 *            : vie des serviteurs
	 * @param c
	 *            : capacitÃ© des serviteurs
	 * @param j
	 *            : joueur propriÃ©taire des serviteurs
	 */
	public MultiClonage(String nom, int attaque, int vie, Capacite c, Ijoueur j) throws HeartStoneException {
		super(nom, "Invoque autant de chien " + attaque + "/" + vie + " avec la capacite "
				+ c.getClass().getSimpleName() + ", que de serviteurs adverses",
				new Serviteur("chien", 0, attaque, vie, c, j));
	}

	/**
	 * Affichage
	 */
	@Override
	public String toString() {
		return "Capacite [nom =" + getNom() + ", description=" + getDescription() + "]";
	}

	/**
	 * Invocation Multiclonnage Ã  la demande du joueur ( Pouvoir du HÃ©ros )
	 * 
	 * @param cible
	 *            : joueur propriÃ©taire des serviteurs
	 * @throws HeartStoneException
	 *             : si la cible est nulle
	 */
	@Override
	public void executerAction(Object cible) throws HeartStoneException {
		if (cible == null)
			throw new HeartStoneException("Le propriétaire du multiclonnage est null");
		for (int i = 0; i < ((Joueur) cible).getPlateau().getAdversaire(((Joueur) cible)).getJeu().size(); i++) {
			Serviteur s = getServiteur().clone();
			s.setNom(s.getNom() + " " + (i + 1));
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
	}

	/**
	 * Aucun effet pour Multiclonnage en dÃ©but de tour
	 */
	@Override
	public void executerEffetDebutTour() {
		// Nothing
	}

	/**
	 * Aucun effet pour Multiclonnage Ã  la disparition de la carte
	 * 
	 * @param cible
	 *            : joueur propriÃ©taire des serviteurs
	 */
	@Override
	public void executerEffetDisparition(Object cible) {
		// Nothing
	}

	/**
	 * Invocation Multiclonnage Ã  la mise en jeu de la carte
	 * 
	 * @param cible
	 *            : joueur propriÃ©taire des serviteurs
	 * @throws HeartStoneException
	 *             : si la cible est nulle
	 */
	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HeartStoneException {
		if (cible == null)
			throw new HeartStoneException("Le propriétaire du multiclonnage est null");
		for (int i = 0; i < ((Joueur) cible).getPlateau().getAdversaire(((Joueur) cible)).getJeu().size(); i++) {
			Serviteur s = getServiteur().clone();
			s.setNom(s.getNom() + " " + (i + 1));
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
	}

	/**
	 * Aucun effet pour Multiclonnage en fin de tour
	 */
	@Override
	public void executerEffetFinTour() {
		// Nothing
	}

}