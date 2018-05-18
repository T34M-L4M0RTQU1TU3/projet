package player;

import java.util.ArrayList;
import java.util.Random;

import application.application;
import capacite.AttaqueCible;
import cartes.*;

/**
 * Classe abstraite : pour un joueur
 * @author JHIDRI GILLOT
 * @see Hero
 */
public class Joueur implements Ijoueur {


	private String pseudo ;
	private Hero hero ;
	private int mana;
	private int stockMana ;
	private ArrayList<Icarte> deck =new ArrayList<Icarte>(); ;
	private ArrayList<Icarte> main = new ArrayList<Icarte>();
	private ArrayList<Icarte> jeu = new ArrayList<Icarte>();
	private Iplateau plateau = null  ;	
	private int utilisationPouvoirParTour = 0 ;
 
	
	/**
	 * @param pseudo : pseudo du joueur
	 * @param hero : héros du joueur
	 */
	public Joueur(String pseudo, Hero hero) {
		setPseudo(pseudo);
		setHero(hero);
		setMana(0);
		setStockMana(0);
		deck.addAll(hero.deckSpecial());
		deck.addAll(application.deckBase());		
		for ( Icarte carte : deck )
			((Carte)carte).setJoueur(this);
	}
	
	/**
	 * Donne le plateau auquel appartient le joueur 
	 * @return plateau
	 */
	public Iplateau getPlateau() {
		return plateau;
	}

	/**
	 * Définit le plateau du joueur 
	 * @param plateau : plateau auquel appartient le joueur 
	 */
	public void setPlateau(Iplateau plateau) {
		if (plateau == null)
			throw new IllegalArgumentException("plateau invalide");		
		this.plateau = plateau;
	}
	
	/**
	 * Ajoute une carte au deck du joueur
	 * @param c : carte à ajouter au deck
	 */
	public void addDeck(Icarte c ) {
		if ( c==null )
			throw new IllegalArgumentException("ajout d'une carte null au deck");
		if (deck.size()== TAILLE_DECK)
			throw new IllegalArgumentException("taille du deck > "+TAILLE_DECK);
		deck.add(c);				
	}
	
	/**
	 * @deprecated
	 */
	public void addDeck() {	
		ArrayList<Icarte> A = application.deckBase();
		if(deck.size() + A.size() > TAILLE_DECK)
			throw new IllegalArgumentException("taille du deck > "+TAILLE_DECK);
		deck.addAll(A);
		for ( Icarte carte : this.getJeu() )
			((Carte)carte).setJoueur(this);
	}
    
	/**
	 * Ajoute une carte au jeu du joueur
	 * @param c : carte à ajouter
	 */
	public void addJeu(Icarte c ) {
		if ( c==null )
			throw new IllegalArgumentException("ajout d'une carte null au jeu");
		jeu.add(c);
	}	
	
		/**
		 * Définit le pseudo du joueur
		 * @param pseudo : pseudo du joueur 
		 */
	public void setPseudo(String pseudo) {
		if ( pseudo == null || pseudo.isEmpty() || pseudo.trim().isEmpty() )
			throw new IllegalArgumentException("Pseudo Joueur invalide") ;
		this.pseudo = pseudo;
	}
	
	/**
	 * Donne le pseudo du joueur
	 * @return pseudo
	 */
	@Override
	public String getPseudo() {
		return pseudo ;
	}

	/**
	 * Définit le héros du joueur 
	 * @param hero : héros du joueur
	 */
	public void setHero(Hero hero) {
		if ( hero == null)
			throw new IllegalArgumentException("Hero null invalide") ;
		this.hero = hero;
	}

	/**
	 * Donne le héros du joueur
	 * @return hero
	 */
	@Override
	public Hero getHero() {
		return hero ;
	}
	
	/**
	 * Donne mana max du joueur au tour actuel
	 * @return mana
	 */
	@Override
	public int getMana() {
		return mana ;
	}
	
	/**
	 * Définit le mana max du joueur au tour actuel
	 * @param mana : mana max du joueur
	 */
	public void setMana(int mana) {
		if ( mana < 0)
			throw new IllegalArgumentException("mana < 0");
		this.mana = mana;
	}


	/**
	 * Donne le nombre d'utilisation du pouvoir restant par tour
	 * @return utilisationPouvoirParTour
	 */
	public int getUtilisationPouvoirParTour() {
		return utilisationPouvoirParTour;
	}


	/**
	 * Définit le nombre d'utilisation du pouvoir restant par tour
	 * @param utilisationPouvoirParTour : nombre d'utilisation du pouvoir restant par tour
	 */
	public void setUtilisationPouvoirParTour(int utilisationPouvoirParTour) {
		this.utilisationPouvoirParTour = utilisationPouvoirParTour;
	}

	/**
	 * Donne la liste des cartes en jeu du joueur
	 * @return jeu
	 */
	@Override
	public ArrayList<Icarte> getJeu() {
		return jeu ;
	}

	/**
	 * Donne la liste des cartes en main du joueur
	 * @return main
	 */
	@Override
	public ArrayList<Icarte> getMain() {
		return main ;
	}

	
	/**
	 * Donne le deck du joueur
	 * @return the deck : deck du joueur
	 */
	public ArrayList<Icarte> getDeck() {
		return deck;
	}

	/**
	 * Pioche une carte du deck et l'ajoute à la main du joueur
	 */
	@Override
	public void piocher() {
		if(deck.size()>0)
		{int x = new Random().nextInt(deck.size());
		main.add(deck.remove(x));}
	}

	/**
	 * Retourne la carte demandée présente dans le jeu du joueur
	 * @param nomCarte : nom de la carte
	 */
	@Override
	public Icarte getCarteEnJeu(String nomCarte) {
		if ( pseudo == null || pseudo.isEmpty() || pseudo.trim().isEmpty() )
			throw new IllegalArgumentException("nom de la carte rechercher en jeu invalide");
		for (Icarte c : getJeu() )
			if ( c.getNom().equals(nomCarte) )
					return c ;
		throw new IllegalArgumentException("cette carte n'est pas dans votre jeu !");
	}

	/**
	 * Retourne la carte demandée présente dans la main du joueur
	 * @param nomCarte : nom de la carte
	 */
	@Override
	public Icarte getCarteEnMain(String nomCarte) {
		if ( pseudo == null || pseudo.isEmpty() || pseudo.trim().isEmpty() )
			throw new IllegalArgumentException("nom de la carte rechercher en main invalide");
		for (Icarte c : getMain() )
			if ( c.getNom().equals(nomCarte) )
					return c ;
		throw new IllegalArgumentException("cette carte n'est pas dans votre main !");
	}
	public void setStockMana(int stockMana) {
		 if( stockMana < 0)
			 throw new IllegalArgumentException("Stock mana < 0");
		this.stockMana = stockMana;
	}

	/**
	 * Donne le mana restant du joueur pour le tour actuel
	 * @return stockMana
	 */
	@Override
	public int getStockMana() {
		return stockMana;
	}

	/**
	 * Démarre le tour du joueur, pioche une carte, augmente de 1 le mana total ( si < MAX_MANA ) et lance l' EffetDebutTour
	 * de la capacité de chaque serviteur en jeu
	 */
	@Override
	public void prendreTour() {
		if(!plateau.estDermarree())
			throw new IllegalArgumentException("vous ne pouvez pas jouer tant que la partie n'est pas dÃ©marÃ©e");		
	//	if (  plateau.getJoueurCourant() == null )
		//	throw new IllegalArgumentException("joueur courent null");		
		if ( this != plateau.getJoueurCourant() )
				throw new IllegalArgumentException("vous ne pouvez pas jouer tant que ce n'est pas votre tour ");			
		for(Icarte carte : getJeu())
			carte.executerEffetDebutTour(this);			
		if ( getMana() <MAX_MANA )
			setMana(getMana()+1);
		setStockMana(getMana());
		piocher();				
	}
	
	/**
	 * Met fin au tour du joueur, rend tous les serviteurs inactifs actifs, et réinitialise le nombre d'utilisations
	 * du pouvoir par tour	
	 */
	@Override
	public void finirTour() {
		for(Icarte carte : getJeu())
			carte.executerEffetFinTour(this);		
		setUtilisationPouvoirParTour(0);		
		this.getPlateau().finTour(this);
	}

	/**
	 * Retire une carte de la main, la place sur le jeu et lance sa capacité
	 * @param carte : carte à jouer
	 * @param cible : cible pour la capacité ( si EffetMiseEnJeu )
	 */
	@Override
	public void jouerCarte(Icarte carte, Object cible) {
		if ( this.getStockMana() < carte.getCout())
			throw new IllegalArgumentException("vous n'avez pas assez de Mana !");
		if ( cible == null )
			throw new IllegalArgumentException("Cible null dans jouer Carte avec cible ");
		if (!main.contains(carte))
			throw new IllegalArgumentException("cette carte n'est pas dans votre main");
		carte.executerEffetDebutMiseEnJeu(cible);	
		setStockMana(getStockMana()-carte.getCout());
		main.remove(carte);	
	}

	/**
	 * Retire une carte de la main, la place sur le jeu 
	 * @param carte : carte à jouer
	 */
	@Override
	public void jouerCarte(Icarte carte) {
		if(carte instanceof Sort)
			if ( ((Sort)carte).getCapacite() instanceof AttaqueCible)
				throw new IllegalArgumentException("CIBLE NULL EXCEPTION ! ");
				
		if ( this.getStockMana() < carte.getCout())
			throw new IllegalArgumentException("vous n'avez pas assez de Mana !");
		if (!main.contains(carte))
			throw new IllegalArgumentException("cette carte n'est pas dans votre main");
		carte.executerEffetDebutMiseEnJeu(carte.getProprietaire());
		setStockMana(getStockMana()-carte.getCout());
		main.remove(carte);	
	}

	/**
	 * Retire la carte du jeu du joueur
	 * @param carte : carte à retirer
	 */
	@Override
	public void perdreCarte(Icarte carte) {
		for (Icarte c : getJeu())
			c.executerEffetDisparition(this);
		jeu.remove(carte);	
	}	
	
	/**
	 * Utilise une carte en jeu
	 * @param carte : carte à utiliser
	 * @param cible : cible à attaquer
	 */
	@Override
	public void utiliserCarte(Icarte carte, Object cible) {
			carte.executerAction(cible);
	}

	/**
	 * Utilise le pouvoir du héros
	 * @param cible : cible du pouvoir
	 */
	@Override
	public void utiliserPouvoir(Object cible) {
		if(getUtilisationPouvoirParTour() != 0 ) 
			throw new IllegalArgumentException("vous avez dÃ©ja utiliser votre pouvoir à ce tour !");		
			getHero().getCapacite().executerAction(cible);
			setUtilisationPouvoirParTour(1);
	}

	/**
	 * Affichage
	 */
	@Override
	public String toString() {
		return getPseudo()+"-->"+hero+"\n Stock de mana : "+getStockMana()+"\n Pouvoir du hÃ©ros : "+getHero().getCapacite().getNom()+"-->"+getHero().getCapacite().getDescription();
	}

}