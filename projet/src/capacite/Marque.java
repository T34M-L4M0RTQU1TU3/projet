package capacite;

import cartes.Serviteur;

public class Marque extends AttaqueCible {
 private int min ;
	public Marque(String nom, int min) {
		super(nom, 0);
		setMin(min);
		}

	/**
	 * @return the min
	 */
	public int getMin() {
		return min;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(int min) {
		this.min = min;
	}

	@Override
	public String toString() {
		return "Capacite [nom=" + getNom() + ", description=Abaisse à "+getMin()+" les points de vie du serviteur ciblé]";
	}
	
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		if (cible instanceof Serviteur)
		{
			((Serviteur) cible).setVie(getMin());
		}
	};
}
