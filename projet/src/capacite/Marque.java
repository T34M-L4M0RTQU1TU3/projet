package capacite;

import cartes.Serviteur;

public class Marque extends AttaqueCible {
 private int pointDeVieApresLeMarquage ;
	public Marque(String nom, int pointDeVieApresLeMarquage) {
		super(nom, 0);
		setpointDeVieApresLeMarquage(pointDeVieApresLeMarquage);
		}

	/**
	 * @return the pointDeVieAprèsLeMarquage
	 */
	public int getpointDeVieApresLeMarquage() {
		return pointDeVieApresLeMarquage;
	}

	/**
	 * @param pointDeVieAprèsLeMarquage the pointDeVieAprèsLeMarquage to set
	 */
	public void setpointDeVieApresLeMarquage(int pointDeVieApresLeMarquage) {
		if ( pointDeVieApresLeMarquage <= 0 )
			throw new IllegalArgumentException("Marque <=0 invalide");
		this.pointDeVieApresLeMarquage = pointDeVieApresLeMarquage;
	}

	@Override
	public String toString() {
		return "Capacite [nom=" + getNom() + ", description=Abaisse à "+getpointDeVieApresLeMarquage()+" les points de vie du serviteur ciblé]";
	}

	@Override
	public void executerAction(Object cible) {
		if (!(cible instanceof Serviteur))
			throw new IllegalArgumentException("Marque ne peut être utiliser que sur un serviteur");
		
			((Serviteur) cible).setVie(getpointDeVieApresLeMarquage());
		
	}
	
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		
		if (!(cible instanceof Serviteur))
			throw new IllegalArgumentException("Marque ne peut être utiliser que sur un serviteur");
		
			((Serviteur) cible).setVie(getpointDeVieApresLeMarquage());
		
	};
}