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
		this.plateau = plateau;
	}




	public void addDeck(Icarte c ) {	
		if (deck.size()== TAILLE_DECK)
			throw new IllegalArgumentException("taille du deck > "+TAILLE_DECK);
		if(c.getProprietaire()!=null && c.getProprietaire().getHero().getClass() != this.getHero().getClass() )
			throw new IllegalArgumentException(" carte non attribuable a ce Hero" );
		deck.add(c);
		((Carte)c).setJoueur(this);
		
	}
	public void addDeck() {	
		ArrayList<Icarte> A = application.deckBase();
		if(deck.size() + A.size() > TAILLE_DECK)
			throw new IllegalArgumentException("taille du deck > "+TAILLE_DECK);
		deck.addAll(A);
		for ( Icarte carte : this.getJeu() )
			((Carte)carte).setJoueur(this);
	}
    
	public void addJeu(Icarte c ) {
		jeu.add(c);
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	@Override
	public String getPseudo() {
		return pseudo ;
	}


	public void setHero(Hero hero) {
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
		this.mana = mana;
	}


	@Override
	public ArrayList<Icarte> getJeu() {
		return jeu ;
	}

	@Override
	public ArrayList<Icarte> getMain() {
		return main ;
	}

	
	@Override
	public void piocher() {
		if(deck.size()>0)
		{int x = new Random().nextInt(deck.size());
		main.add(deck.remove(x));}
	}

	@Override
	public Icarte getCarteEnJeu(String nomCarte) {
		for (Icarte c : getJeu() )
			if ( c.getNom().equals(nomCarte) )
					return c ;
		throw new IllegalArgumentException("cette carte n'est pas dans votre jeu !");
	}

	@Override
	public Icarte getCarteEnMain(String nomCarte) {
		for (Icarte c : getMain() )
			if ( c.getNom().equals(nomCarte) )
					return c ;
		throw new IllegalArgumentException("cette carte n'est pas dans votre main !");
	}

	public void setStockMana(int stockMana) {
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
		
		if ( this != plateau.getJoueurCourant() )
				throw new IllegalArgumentException("vous ne pouvez pas jouer tant que ce n'est pas votre tour ");
			
			for(Icarte carte : getJeu())
				carte.executerEffetDebutTour(this);
			
			if ( getMana() <10 )
				setMana(getMana()+1);
				setStockMana(getMana());
				piocher();
				
	}
	
	@Override
	public void finirTour() {
		for(Icarte carte : getJeu())
			carte.executerEffetFinTour(this);
		
		this.getPlateau().finTour(this);
	}

	@Override
	public void jouerCarte(Icarte carte, Object cible) {
		if (!main.contains(carte))
			throw new IllegalArgumentException("cette carte n'est pas dans votre main");
		carte.executerEffetDebutMiseEnJeu(cible);	
		perdreCarte(carte);	
	}

	@Override
	public void jouerCarte(Icarte carte) {
		if (!main.contains(carte))
			throw new IllegalArgumentException("cette carte n'est pas dans votre main");
		carte.executerEffetDebutMiseEnJeu(carte.getProprietaire());
		perdreCarte(carte);	

	}

	
	@Override
	public void perdreCarte(Icarte carte) {
		main.remove(carte);	
	}

	
	

	@Override
	public void utiliserCarte(Icarte carte, Object cible) {
			carte.executerAction(cible);
	}

	@Override
	public void utiliserPouvoir(Object cible) {
		this.getHero().getCapacite().executerAction(cible);

	}

	@Override
	public String toString() {
		return getPseudo()+"-->"+hero+"\n Stock de mana : "+getStockMana()+"\n Pouvoir du héros : "+getHero().getCapacite().getNom()+"-->"+getHero().getCapacite().getDescription();
	}



}
