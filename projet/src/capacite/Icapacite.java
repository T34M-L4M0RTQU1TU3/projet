/**
 * contiens toute les capacités du jeu
 */
package capacite;

/**
 * @author achraf
 *
 */
public interface Icapacite {
 void executerAction(Object cible );
 void executerEffetDebutTour(Object cible );
 void executerEffetDisparition(Object cible );
 void executerEffetMiseEnJeu(Object cible );
 String getDescription();
 String getNom();
 
}
