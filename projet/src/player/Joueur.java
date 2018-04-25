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
		((Carte)c).setJoueur(this);
	}
    
	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	@Override
	public String getPseudo() {
		return pseudo ;
	}

	/**
	 * @param hero the hero to set
	 */
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
	
	/**
	 * @param mana the mana to set
	 */
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
		for (Icarte c : jeu )
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



	/**
	 * @param stockMana the stockMana to set
	 */
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
		// TODO Auto-generated method stub

	}




	@Override
	public void jouerCarte(Icarte carte, Object cible) {
		

	}

	@Override
	public void jouerCarte(Icarte carte) {
		if (carte instanceof Serviteur)
		{	{jeu.add(carte);
			 if (  ((Serviteur) carte).getCapacite() instanceof InvocationDeServiteur)
			 	{
				 jeu.add(((InvocationDeServiteur) ((Serviteur) carte).getCapacite()).getServiteur()) ;
			 	}
			 if (  ((Serviteur) carte).getCapacite() instanceof ImageMirroir)
			 	{
				 jeu.add(((ImageMirroir) ((Serviteur) carte).getCapacite()).getServiteur()) ;
				 jeu.add(((ImageMirroir) ((Serviteur) carte).getCapacite()).getServiteur()) ;
			 	}
			 
			 }
			
			 main.remove(carte);
			}
		
		
		if( carte instanceof Sort)
			if(((Sort) carte).getCapacite() instanceof Piocher )
			{
			int i ;
			
			for ( i=0;i< ((Piocher)((Sort) carte).getCapacite()).getNombre();  i++)
				piocher();
			
			main.remove(carte);
			}	
		
			
	}

	@Override
	public void perdreCarte(Icarte carte) {
		
	}

	
	

	@Override
	public void utiliserCarte(Icarte carte, Object cible) {
		if ( carte instanceof Serviteur)
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
