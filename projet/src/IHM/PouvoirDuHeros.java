package IHM;


import exceptions.CibleNullException;
import exceptions.HeartStoneException;
import player.Plateau;

import application.application;

public class PouvoirDuHeros extends Interaction {

	public PouvoirDuHeros(Interaction suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(String choix) {
		if(getDescription().equals(choix))
			return true;
		return false;
	}

	@Override
	public void executerInteraction(Object o) throws HeartStoneException {
	 

		try {
			((Plateau)	o).getJoueurCourant().utiliserPouvoir(((Plateau)	o).getJoueurCourant());
		}
		catch(CibleNullException e)
		{
			Interaction sousIhm = application.initialiserSousInterface();
			//if souSIHM EST VIDE !
			String choix = application.sousMenu(sousIhm);

			sousIhm.interagir(choix, ((Plateau)	o));
		}catch(HeartStoneException e)
		{
			application.es.print(e.getMessage());;
		}

		
	}

	@Override
	public String getDescription() {
		return "Utiliser le pouvoir de votre héros";
	}

}
