package cartes;

import capacite.*;
import exceptions.HeartStoneException;
import player.*;

/**
 * Un sort qui s'effectue et disparait instantanément du jeu
 * @author JHIDRI GILLOT
 */
public class Sort extends Carte {
	
	private Capacite capacite ;
	
	/**
	 * @param nom : nom du sort
	 * @param cout : coût du sort
	 * @param c : capacité du sort
	 * @param j : propriétaire du sort
	 */
	public Sort(String nom, int cout,Capacite c,Ijoueur j) {
		super(nom, cout,j);
		setCapacite(c);
	}
	
	/**
	 * Donne la capacité du sort
	 * @return capacite
	 */
	public Capacite getCapacite() {
		return capacite;
	}
	
	/**
	 * Définit la capacité du sort
	 * @param capacite : capacité du sort
	 * @throws IllegalArgumentException : en cas de capacité null pour un sort ce qui le rend inutile , au moins pour cette version du jeu
	 */
	public void setCapacite(Capacite capacite) {
		if(capacite == null)
			throw new IllegalArgumentException("Capacite null dans un sort Invalide");
		this.capacite = capacite;
	}
	
	/**
	 * Affichage
	 */
	@Override
	public String toString() {
		return "Sort [ "+super.toString()+" ] " + capacite;
	}
	
	/**
	 * Toujours true car un sort disparait dès qu'il est mis en jeu
	 */
	@Override
	public Boolean disparait() {	
		return true;
	}


	/**
	 * Lance le sort à la demande du joueur 
	 * @param cible : cible de la capacité
	 */
	@Override
	public void executerAction(Object cible)throws HeartStoneException {
		capacite.executerAction(cible);
	}

	/**
	 * lance l'effet de mise en jeu de la capacité du sort
	 * @param cible : cible de la capacité
	 */
	@Override
	public void executerEffetDebutMiseEnJeu(Object cible) throws HeartStoneException{
		capacite.executerEffetMiseEnJeu(cible);			
	}

	/**
	 * lance l'effet de début de tour de la capacité du sort
	 * @param cible : cible de la capacité
	 */
	@Override
	public void executerEffetDebutTour(Object cible) {
		capacite.executerEffetDebutTour();
	}

	/**
	 * lance l'effet de disparition de la capacité du sort
	 * @param cible : cible de la capacité
	 */
	@Override
	public void executerEffetDisparition(Object cible) throws HeartStoneException{
		capacite.executerEffetDisparition(cible);		
	}

	/**
	 * lance l'effet de fin de tour de la capacité du sort
	 * @param cible : cible de la capacité
	 */
	@Override
	public void executerEffetFinTour(Object cible) {
		capacite.executerEffetFinTour();		
	}

}