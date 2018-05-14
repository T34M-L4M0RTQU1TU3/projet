package player;

import java.util.ArrayList;
import java.util.Random;

import application.application;

import cartes.*;


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
	 * @param pseudo
	 * @param hero
	 * @param mana
	 * @param deck
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
	

	public Iplateau getPlateau() {
		return plateau;
	}


	public void setPlateau(Iplateau plateau) {
		if (plateau == null)
			throw new IllegalArgumentException("plateau invalide");
		
		this.plateau = plateau;
	}




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
    
	public void addJeu(Icarte c ) {
		if ( c==null )
			throw new IllegalArgumentException("ajout d'une carte null au jeu");
		jeu.add(c);
	}
	
	public void setPseudo(String pseudo) {
		if ( pseudo == null || pseudo.isEmpty() || pseudo.trim().isEmpty() )
			throw new IllegalArgumentException("Pseudo Joueur invalide") ;
		this.pseudo = pseudo;
	}
	
	@Override
	public String getPseudo() {
		return pseudo ;
	}


	public void setHero(Hero hero) {
		if ( hero == null)
			throw new IllegalArgumentException("Hero null invalide") ;
		this.hero = hero;
	}

	@Override
	public Hero getHero() {
		return hero ;
	}
	
	@Override
	public int getMana() {
		return mana ;
	}
	

	public void setMana(int mana) {
		if ( mana < 0)
			throw new IllegalArgumentException("mana < 0");
		this.mana = mana;
	}


	/**
	 * @return the utilisationPouvoirParTour
	 */
	public int getUtilisationPouvoirParTour() {
		return utilisationPouvoirParTour;
	}


	/**
	 * @param utilisationPouvoirParTour the utilisationPouvoirParTour to set
	 */
	public void setUtilisationPouvoirParTour(int utilisationPouvoirParTour) {
		this.utilisationPouvoirParTour = utilisationPouvoirParTour;
	}


	@Override
	public ArrayList<Icarte> getJeu() {
		return jeu ;
	}

	@Override
	public ArrayList<Icarte> getMain() {
		return main ;
	}

	
	/**
	 * @return the deck
	 */
	public ArrayList<Icarte> getDeck() {
		return deck;
	}


	@Override
	public void piocher() {
		if(deck.size()>0)
		{int x = new Random().nextInt(deck.size());
		main.add(deck.remove(x));}
	}

	@Override
	public Icarte getCarteEnJeu(String nomCarte) {
		if ( pseudo == null || pseudo.isEmpty() || pseudo.trim().isEmpty() )
			throw new IllegalArgumentException("nom de la carte rechercher en jeu invalide");
		for (Icarte c : getJeu() )
			if ( c.getNom().equals(nomCarte) )
					return c ;
		throw new IllegalArgumentException("cette carte n'est pas dans votre jeu !");
	}

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

	@Override
	public int getStockMana() {
		return stockMana;
	}

	@Override
	public void prendreTour() {
		if(!plateau.estDermarree())
			throw new IllegalArgumentException("vous ne pouvez pas jouer tant que la partie n'est pas démarée");
		
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
	
	@Override
	public void finirTour() {
		for(Icarte carte : getJeu())
			carte.executerEffetFinTour(this);
		
		setUtilisationPouvoirParTour(0);
		
		this.getPlateau().finTour(this);
	}

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

	@Override
	public void jouerCarte(Icarte carte) {
		if ( this.getStockMana() < carte.getCout())
			throw new IllegalArgumentException("vous n'avez pas assez de Mana !");
		if (!main.contains(carte))
			throw new IllegalArgumentException("cette carte n'est pas dans votre main");
		carte.executerEffetDebutMiseEnJeu(carte.getProprietaire());
		setStockMana(getStockMana()-carte.getCout());
		main.remove(carte);	

	}

	
	@Override
	public void perdreCarte(Icarte carte) {
		for (Icarte c : getJeu())
			c.executerEffetDisparition(this);
		jeu.remove(carte);	
	}

	
	

	@Override
	public void utiliserCarte(Icarte carte, Object cible) {
			carte.executerAction(cible);
	}

	@Override
	public void utiliserPouvoir(Object cible) {
		if(getUtilisationPouvoirParTour() != 0 ) 
			throw new IllegalArgumentException("vous avez déja utiliser votre pouvoir se tour la !");
		
			getHero().getCapacite().executerAction(cible);
			setUtilisationPouvoirParTour(1);
	}

	@Override
	public String toString() {
		return getPseudo()+"-->"+hero+"\n Stock de mana : "+getStockMana()+"\n Pouvoir du héros : "+getHero().getCapacite().getNom()+"-->"+getHero().getCapacite().getDescription();
	}



}
