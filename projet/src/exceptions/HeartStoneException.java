package exceptions;
/**
 * Classe d'exception liée au principe du jeu , exemple passez de mana , carte introuvable ....
 * @author town
 */
@SuppressWarnings("serial")
public class HeartStoneException extends Exception {


	public HeartStoneException(String msg) {
		super(msg);	
	}



}
