package player;

import java.util.ArrayList;


import cartes.*;

public interface Ijoueur {
	
	final int MAX_MANA = 10;
	final int TAILLE_DECK= 15;

	
	
	void finirTour();
	Icarte getCarteEnJeu(String nomCarte) ;
	Icarte getCarteEnMain(String nomCarte) ;
	Hero getHero();
	ArrayList<Icarte> getJeu();
	ArrayList<Icarte> getMain();
	int getMana();
	int getStockMana();
	String getPseudo();
	void jouerCarte(Icarte carte,Object cible);
	void jouerCarte(Icarte carte);
	void perdreCarte(Icarte carte);
	void piocher();
	void prendreTour();
	void utiliserCarte(Icarte carte ,Object cible);
	void utiliserPouvoir(Object cible);


}
