package IHM;

import application.application;
import cartes.Carte;
import exceptions.CibleNullException;
import exceptions.HeartStoneException;
import player.Joueur;
import player.Plateau;

public class JouerCarte extends Interaction {

	public JouerCarte(Interaction suivant) {
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
		application.es.print("saisissez le nom de la carte à jouer");		
		String nomCarte = application.es.readLine();
		
		Joueur joueur = (Joueur) ((Plateau ) o ).getJoueurCourant() ;
		Carte carteAJouer = (Carte) joueur.getCarteEnMain(nomCarte);
		try {
			joueur.jouerCarte(carteAJouer) ;
			}
		catch(CibleNullException e) {
			Interaction sousIhm = application.initialiserSousInterface();
			//if souSIHM EST VIDE !
			String choix = application.sousMenu(sousIhm);

			sousIhm.interagir(choix, ((Plateau)	o));
		}	
			catch(HeartStoneException e)
		{
			application.es.print(e.getMessage());;
		}
		
	}

	@Override
	public String getDescription() {
		return "Jouer une carte de ta main";
	}

}
