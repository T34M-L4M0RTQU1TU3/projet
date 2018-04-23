package capacite;

public class MultiClonage extends Invocation {

	public MultiClonage(String nom,int pAttaque,int pVie,Capacite c) {
		
		super(nom,new Serviteur(nom.substring(15),0,pAttaque,pVie,c));
	}
	



	@Override
	public String toString() {
		return "Capacite [nom ="+getNom()+", description=Invoque autant de "+getNom().substring(15)+" "+getServiteur().getPAttaque()+"/"+getServiteur().getPVie()+"avec la capacité "+getServiteur().getCapacite().getClass().getSimpleName()+",que de serviteurs adverses]";
	}
	
	
}
