package IHM;

import application.application;
import capacite.Charge;
import capacite.Marque;
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
		application.es.print("saisissez le nom de la carte à jouer :\n--->");		
		String nomCarte = application.es.readLine();
		
		Joueur joueur = (Joueur) ((Plateau ) o ).getJoueurCourant() ;
		Carte carteAJouer = (Carte) joueur.getCarteEnMain(nomCarte);
		if(carteAJouer instanceof Sort &&( ((Sort)carteAJouer).getCapacite() instanceof Charge))
			{application.es.print("donner le nom du serviteur a cibler :\n--->");		
			String nomCible = application.es.readLine();
			Carte carteACibler = (Carte) joueur.getCarteEnJeu(nomCible);
				joueur.jouerCarte(carteAJouer, carteACibler);	
					}
		else if(carteAJouer instanceof Sort &&( ((Sort)carteAJouer).getCapacite() instanceof Marque))
		{application.es.print("donner le nom du serviteur a cibler :\n--->");		
		String nomCible = application.es.readLine();
		Carte carteACibler = (Carte) joueur.getPlateau().getAdversaire(joueur).getCarteEnJeu(nomCible);
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
				System.err.printf("%100s\n",e.getMessage());
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