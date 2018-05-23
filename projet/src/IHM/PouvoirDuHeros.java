package IHM;


import exceptions.CibleNullException;
import exceptions.HeartStoneException;
import player.Plateau;

import application.application;
/**
 * @author Gillot,Jhidri
 * la classe P correspont au choix dans le sousMenu qui permet de cibler le Hero adverse 
 */
public class PouvoirDuHeros extends Interaction {

	public PouvoirDuHeros(Interaction suivant) {
		super(suivant);
	}

	
	/**
	 * utilise le pouvoir du hero sur le hero adversaire / cible en cas de besoin  
	 */
	@Override
	public void executerInteraction(Object o) throws HeartStoneException {
	 

		try {
			((Plateau)	o).getJoueurCourant().utiliserPouvoir(((Plateau)o).getJoueurCourant());
		}
		catch(CibleNullException e)
		{
			Interaction sousIhm = application.initialiserSousInterface();
			//if souSIHM EST VIDE !
			String choix = application.sousMenu(sousIhm);

			sousIhm.interagir(choix, ((Plateau)	o));
		}catch(HeartStoneException e)
		{
			System.err.println(e.getMessage());
		}

		
	}

	/**
	 * @return renvoi la description 
	 */
	@Override
	public String getDescription() {
		return "Utiliser le pouvoir de votre héros";
	}

}