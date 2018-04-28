package player;

import java.util.ArrayList;

import capacite.*;

import cartes.*;

public class Joueur implements Ijoueur {
	private String pseudo ;
	private Hero hero ;
	private int mana;
	private int stockMana ;
	private ArrayList<Icarte> deck =new ArrayList<Icarte>(); ;
	private ArrayList<Icarte> main = new ArrayList<Icarte>();
	private ArrayList<Icarte> jeu = new ArrayList<Icarte>();
	//private Plateau plateau ;
 
	
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
		
	}

	public void addDeck(Icarte c ) {
		
		deck.add(c);

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
		main.add(deck.remove(0));
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
		setMana(getMana()+1);
		setStockMana(getMana());
		piocher();
	}
	
	@Override
	public void finirTour() {
		
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
		carte.executerEffetDebutMiseEnJeu(this);
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
