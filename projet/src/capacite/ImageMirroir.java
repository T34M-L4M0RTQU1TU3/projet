package capacite;

public class ImageMirroir extends Invocation {

	public ImageMirroir(String nom,int pAttaque,int pVie,Capacite c) {
		super(nom,new Serviteur("Serviteur de "+getProprietaire().getHero().getClass().getSimpleName(),0,pAttaque,pVie,c));
	}

	
	
	@Override
	public String toString() {
		return "Capacite [nom =Image Mirroir, description=Invoque deux serviteur de "+getProprietaire().getHero().getClass().getSimpleName()+" "+getServiteur().getPAttaque()+"/"+getServiteur().getPVie()+" ayant la capacite"+getServiteur().getPAttaque()+"/"+getServiteur().getPVie()+"avec la capacité "+getServiteur().getCapacite().getClass().getSimpleName()+"]";
	}
}
