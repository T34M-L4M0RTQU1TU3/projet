package player;

import java.util.ArrayList;
import java.util.Random;

import cartes.Icarte;
import cartes.Serviteur;

public class Plateau implements Iplateau {

	private ArrayList<Ijoueur> players = new ArrayList<Ijoueur>();
	private Ijoueur joueurCourant = null;
	private static Plateau plateauCourant = new Plateau();
	private boolean demarree = false;

	/**
	 * @return the plateauCourant
	 */
	public static Plateau getPlateauCourant() {
		return plateauCourant;
	}

	@Override
	public void ajouterJoueur(Ijoueur joueur) {
		if (joueur == null)
			throw new IllegalArgumentException("Joueur null exception");
		if (players.size() >= 2)
			throw new IllegalArgumentException("un battle est entre 2 guerrier et non pas plus !");
		if (players.contains(joueur))
			throw new IllegalArgumentException("ajouterJoueur ce joueur à déjà été ajouté a la partie ");
		players.add(joueur);
		((Joueur) joueur).setPlateau(this);
	}

	@Override
	public Ijoueur getJoueurCourant() {
		if (!estDermarree())
			return null;

		if (players.size() != 2)
			throw new IllegalArgumentException("faut qu'il y es 2 joueur pour pouvoir savoir le jour courant ");

		if (joueurCourant == null)
			throw new IllegalArgumentException("Joueur courant null ");

		return joueurCourant;
	}

	@Override
	public void setJoueurCourant(Ijoueur joueur) {
		if (joueur == null)
			throw new IllegalArgumentException("joueurCourant null ");

		if (!players.contains(joueur))
			throw new IllegalArgumentException("setJoueurCourant le joueur n'est pas dans cette partie");

		if (!estDermarree())
			throw new IllegalArgumentException("La partie n'a pas encore démarrer pour appeler setJoueurCourant");

		if (joueur == joueurCourant)
			throw new IllegalArgumentException("il est deja le joueur courant");

		joueurCourant = joueur;
	}

	@Override
	public Ijoueur getAdversaire(Ijoueur joueur) {
		if (!estDermarree())
			throw new IllegalArgumentException("IL N'Y PAS D'ADVERSAIRE INSCRIT POUR LE MOMENT");

		if (joueur == null)
			throw new IllegalArgumentException("vous chercher l'adversaire d'un null ");

		if (!players.contains(joueur))
			throw new IllegalArgumentException("getAdversaire le joueur n'est pas dans cette partie");

		if (joueur == players.get(0))
			return players.get(1);

		return players.get(0);
	}

	@Override
	public void demarrerPartie() {
		if (players.size() != 2)
			throw new IllegalArgumentException("La partie ne px pas etre démarrer tant qu'il n'y a pas 2 joueurs");

		setDemarree(true);
		int x = new Random().nextInt(2);
		setJoueurCourant(players.get(x));

	}

	@Override
	public boolean estDermarree() {
		return demarree;
	}

	/**
	 * @param demarree
	 *            the demarree to set
	 */
	public void setDemarree(boolean demarree) {
		this.demarree = demarree;
	}

	@Override
	public void finTour(Ijoueur joueur) {
		if (joueur == null)
			throw new IllegalArgumentException("un null ne px pas finir son tour ");

		if (!players.contains(joueur))
			throw new IllegalArgumentException("finTour le joueur n'est pas dans cette partie");

		if (joueur == getJoueurCourant()) {
			setJoueurCourant(((Joueur) joueur).getPlateau().getAdversaire(joueur));

		}

		else
			throw new IllegalArgumentException(" ne t'excite pas trop fdp c'est pas a toi de jouer putain ");
	}

	@Override
	public void gagnePartie(Ijoueur joueur) {

		System.out.println(joueur.getPseudo() + " est le gagnant de ce combat acharné qui a duré 8 nuits et 7 jours ");
		System.exit(0);

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String s = ""  ;
		s=s+players.get(0).toString()+"\n" ;
		if ( players.get(0) == getJoueurCourant())
		{
			s =s+">>>> TOUR <<<<\n### Ta main ###\n###############\n";
			for ( Icarte carte :players.get(0).getMain())
				s+="### "+carte.toString()+"\n";
			s+="###############\n";
			s=s+"==================================\n";
			for ( Icarte carte :players.get(0).getJeu())
				s+="### "+carte.toString()+(((Serviteur)carte).isJouable()?"(jouable)":"(en attente)")+"\n";
		   s+="==================================\n";
		}
		else {
			s=s+"==================================\n";
			for ( Icarte carte :players.get(0).getJeu())
				s+="### "+carte.toString()+(((Serviteur)carte).isJouable()?"(jouable)":"(en attente)")+"\n";
		   s+="==================================\n";

		}
		s=s+players.get(1).toString()+"\n" ;
		if ( players.get(1) == getJoueurCourant())
		{
			s =s+">>>> TOUR <<<<\n### Ta main ###\n###############\n";
			for ( Icarte carte :players.get(1).getMain())
				s+="### "+carte.toString()+"\n";
			s+="###############\n";
			s=s+"==================================\n";
			for ( Icarte carte :players.get(1).getJeu())
				s+="### "+carte.toString()+(((Serviteur)carte).isJouable()?"(jouable)":"(en attente)")+"\n";
		   s+="==================================\n";
		}
		else {
			s=s+"==================================\n";
			for ( Icarte carte :players.get(1).getJeu())
				s+="### "+carte.toString()+(((Serviteur)carte).isJouable()?"(jouable)":"(en attente)")+"\n";
		   s+="==================================\n";
		}

		return s ;
	}

}

























