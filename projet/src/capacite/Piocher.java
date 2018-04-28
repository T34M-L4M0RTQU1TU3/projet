package capacite;

import player.Joueur;

public class Piocher extends Capacite {
	private int nombre;
	public Piocher(int nombre) {
		super("Piocher", "pioche "+nombre+" carte(s)");
		setNombre(nombre);
	}
	/**
	 * @return the nombre
	 */
	public int getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	@Override
	public void executerAction(Object cible) {
		int i ;
		
		for ( i=0;i< getNombre();  i++)
			{((Joueur)cible).piocher();
			
			}
	}
	@Override
	public void executerEffetDebutTour() {
		//nothing
		
	}
	@Override
	public void executerEffetDisparition(Object cible) {
		//nothing
		
	}
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		int i ;
		
		for ( i=0;i< getNombre();  i++)
			{((Joueur)cible).piocher();
			
			}
		
	}
	@Override
	public void executerEffetFinTour() {
		//nothing
		
	}

}
