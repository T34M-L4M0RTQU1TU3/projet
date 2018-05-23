package IHM;

import exceptions.HeartStoneException;
/**
 * @author Gillot,Jhidri
 * la classe Interaction est une classe abstraite qui permet d'effectuer un choix
 * @see ChoixChasseur  ChoixMage .....
*/

public abstract class Interaction {
	
	private Interaction suivant = null;
	
	public Interaction(Interaction suivant) {
		this.suivant = suivant;
	}
	/**
	 * @return l'interraction suivante
	 */
	public Interaction getSuivant() {
		return suivant;
	}
	/**
	 * renvoi vrai si le choix reçu en paramètre est "Abondonner"
	 */
	public  boolean saitInteragir(String choix) {
		return	getDescription().equals(choix);
	}
	
	public abstract void executerInteraction(Object o) throws HeartStoneException;
	
	public abstract String getDescription();
	/**
	 * redirige le choix vers le responsable qui sais l'executer
	 */
	public void interagir(String choix,Object o) throws HeartStoneException {
		if(saitInteragir(choix))
			executerInteraction(o);
		else {
			if(suivant != null)
				suivant.interagir(choix, o);				
		}
	}

}