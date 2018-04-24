package capacite;

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

}
