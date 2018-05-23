package exceptions;

import IHM.JouerCarte;

/**
 * Classe qui dérive @see {@link HeartStoneException} : utilisé quand une carte a besoin d'une cible pour résoudre le conflit entre @see Joueur.jouerCarte avec cible ou aps
 * @author Gillot Jhidri 
 *	
 */
@SuppressWarnings("serial")
public class CibleNullException extends HeartStoneException {

	public CibleNullException(String msg) {
		super(msg);
	}

}


