package IHM;

import application.application;
import capacite.Charge;
import cartes.Carte;
import cartes.Sort;
import exceptions.CibleNullException;
import exceptions.HeartStoneException;
import player.Joueur;
import player.Plateau;
/**
 * @author Gillot,Jhidri
 * la classe JouerCarte correspont au choix permettant de JouerCarte
 */
public class JouerCarte extends Interaction {

	public JouerCarte(Interaction suivant) {
		super(suivant);

	}


/**
 * demande la carte a jouer et la joue 
 */
	@Override
	public void executerInteraction(Object o) throws HeartStoneException {
		application.es.println("saisissez le nom de la carte à jouer");		
		String nomCarte = application.es.readLine();
		
		Joueur joueur = (Joueur) ((Plateau ) o ).getJoueurCourant() ;
		Carte carteAJouer = (Carte) joueur.getCarteEnMain(nomCarte);
		if(carteAJouer instanceof Sort &&( ((Sort)carteAJouer).getCapacite() instanceof Charge))
			{application.es.println("donner le nom du serviteur a cibler ");		
			String nomCible = application.es.readLine();
			Carte carteACibler = (Carte) joueur.getCarteEnJeu(nomCible);
				joueur.jouerCarte(carteAJouer, carteACibler);	
					}
		else 
		try {
			joueur.jouerCarte(carteAJouer) ;
			}
		catch(CibleNullException e) {
			Interaction sousIhm = application.initialiserSousInterface();

			String choix = application.sousMenu(sousIhm);

			sousIhm.interagir(choix, ((Carte)	o));
		}	
			catch(HeartStoneException e)
		{
			application.es.print(e.getMessage());;
		}
		
	}
	/**
	 * @return renvoi la description
	 */

	@Override
	public String getDescription() {
		return "Jouer une carte de ta main";
	}

}