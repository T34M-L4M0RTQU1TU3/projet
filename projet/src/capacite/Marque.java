package capacite;

import cartes.Serviteur;
/**
 * Modifie les points de vie d'un serviteur
 * @author JHIDRI GILLOT
 */
public class Marque extends AttaqueCible {
 private int pointDeVieApresLeMarquage ;
 	/**
 	 * @see Attaque
 	 * @param pointDeVieApresLeMarquage : les points de vie du serviteur adverse après le marquage
 	 */
	public Marque(String nom, int pointDeVieApresLeMarquage) {
		super(nom, 0);
		setpointDeVieApresLeMarquage(pointDeVieApresLeMarquage);
		}

	/**
	 * Donne le nombre de points de vie du serviteur adverse après le marquage
	 * @return pointDeVieApresLeMarquage
	 */
	public int getpointDeVieApresLeMarquage() {
		return pointDeVieApresLeMarquage;
	}

	/**
	 * définit la variable pointDeVieApresLeMarquage
	 */
	public void setpointDeVieApresLeMarquage(int pointDeVieApresLeMarquage) {
		if ( pointDeVieApresLeMarquage <= 0 )
			throw new IllegalArgumentException("Marque <=0 invalide");
		this.pointDeVieApresLeMarquage = pointDeVieApresLeMarquage;
	}
	/**
	 * Affichage
	 */
	@Override
	public String toString() {
		return "Capacite [nom=" + getNom() + ", description=Abaisse Ã  "+getpointDeVieApresLeMarquage()+" les points de vie du serviteur ciblÃ©]";
	}
	/**
	 * Marque sur la cible donnée à la demande du joueur ( Pouvoir du Héros )
	 */
	@Override
	public void executerAction(Object cible) {
		if (!(cible instanceof Serviteur))
			throw new IllegalArgumentException("Marque ne peut Ãªtre utiliser que sur un serviteur");
		
			((Serviteur) cible).setVie(getpointDeVieApresLeMarquage());
		
	}
	/**
	 * Marque sur la cible donnée à la demande du joueur
	 */
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		
		if (!(cible instanceof Serviteur))
			throw new IllegalArgumentException("Marque ne peut Ãªtre utiliser que sur un serviteur");
		
			((Serviteur) cible).setVie(getpointDeVieApresLeMarquage());
		
	};
}