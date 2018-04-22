/**
 * contiens toute les capacités du jeu
 */
package capacite;

/**
 * @author achraf
 *
 */
public interface Icapacite {
	
	
	
	/**
	 * execution quand elle est en plateau
	 * 
	 */
 void executerAction(Object cible );
 
	/**
	 * execution au debut de chaque tour
	 *
	 */
 void executerEffetDebutTour(Object cible );
 
	/**
	 * effet apres disparition
	 *
	 */
 void executerEffetDisparition(Object cible );
	/**
	 * 
	 * effet mise en jeu par exemple invocation ou inflige dégats 
	 *
	 */
 void executerEffetMiseEnJeu(Object cible );
 String getDescription();
 String getNom();
 
}
