package capacite;

import cartes.Serviteur;


public class ImageMirroir extends Invocation {

	public ImageMirroir(String nom,int attaque,int vie,Capacite c) {
		super(nom,"Invoque deux serviteur de Jayna "+attaque+"/"+vie+" ayant la capacite "+c.getClass().getSimpleName(),new Serviteur("Serviteur de Jayna",0,attaque,vie,c));
		
	}

	//+getProprietaire().getHero().getClass().getSimpleName()
	
	@Override
	public String toString() {
		return "Capacite [nom =Image Mirroir, description="+getDescription()+" ]";
	}
}
