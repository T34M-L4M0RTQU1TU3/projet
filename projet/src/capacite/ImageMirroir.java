package capacite;

import cartes.Serviteur;

public class ImageMirroir extends Invocation {

	public ImageMirroir(String nom,int pAttaque,int pVie,Capacite c) {
		super(nom,new Serviteur("Serviteur de Jayna",0,pAttaque,pVie,c));
		
	}

	//+getProprietaire().getHero().getClass().getSimpleName()
	
	@Override
	public String toString() {
		return "Capacite [nom =Image Mirroir, description=Invoque deux serviteur de Jayna "+getServiteur().getAttaque()+"/"+getServiteur().getVie()+" ayant la capacite "+getServiteur().getCapacite().getClass().getSimpleName()+" ]";
	}
}
