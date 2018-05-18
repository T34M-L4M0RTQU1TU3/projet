package capacite;

import player.Joueur;

/**
 * Permet de piocher un certain nombre de cartes
 * @author JHIDRI GILLOT
 */
public class Piocher extends Capacite {
	
	private int nombre;
	
	/**
	 * @see Capacite
	 * @param nombre : nombre de cartes à piocher
	 */
	public Piocher(int nombre) {
		super("Piocher", "pioche "+nombre+" carte(s)");
		setNombre(nombre);
	}
	/**
	 * Donne le nombre de cartes à piocher
	 * @return nombre
	 */
	public int getNombre() {
		return nombre;
	}
	
	/**
	 * Définit le nombre de cartes à piocher
	 * @param nombre : le nombre de cartes à piocher
	 */
	public void setNombre(int nombre) {
		if(nombre <= 0)
			throw new IllegalArgumentException("Nombre pioche Invalide");
		this.nombre = nombre;
	}
	
	/**
	 * Pioche les cartes à la demande du joueur ( Pouvoir du Héros )
	 * @param cible : joueur qui pioche
	 */
	@Override
	public void executerAction(Object cible) {
		if ( getNombre() > ((Joueur)cible).getDeck().size())
			throw new IllegalArgumentException("Impossible de piocher ce nombre de carte "); 		
		for (int  i=0;i< getNombre();  i++)
			{((Joueur)cible).piocher();			
			}
	}
	
	/**
	 * Aucun effet pour Piocher en début de tour
	 */
	@Override
	public void executerEffetDebutTour() {
		//nothing		
	}
	
	/**
	 * Aucun effet pour Piocher à la disparition de la carte
	 */
	@Override
	public void executerEffetDisparition(Object cible) {
		//nothing		
	}
	
	/**
	 * Pioche les cartes à la mise en jeu de la carte
	 * @param cible : joueur qui pioche
	 */
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		if ( getNombre() > ((Joueur)cible).getDeck().size())
			throw new IllegalArgumentException("Impossible de piocher ce nombre de carte "); 		
		for (int i=0;i< getNombre();  i++)
			{
				((Joueur)cible).piocher();
			}		
	}
	
	/**
	 * Aucun effet pour Piocher en fin de tour
	 */
	@Override
	public void executerEffetFinTour() {
		//nothing		
	}

}