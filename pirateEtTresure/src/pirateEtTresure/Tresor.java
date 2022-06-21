

package pirateEtTresure;
  /**
 * Represente un Tresor 
 
 */
   public class Tresor {
       /**
	 * Le nom du Tresor
	 */
	private int Nom;
	/**
	 * la disponibilité
	 */
	private boolean disponible;
	
	public Tresor(int i,boolean dispo) {
	this.Nom=i;
	this.disponible=dispo;
	}
	/**
	 * Permet de verifier la disponibilité
	 * return disponible 
	 */
	public boolean getDispo() {
	return this.disponible ;
	}
	
	/**
	 * un set permet d'acceder a la disponibilité
	 * return dispo pour un Tresor  
	 */
	
	public void setDispo(boolean d) {
	this.disponible=d;
	}
	/**
	 * Permet d'obtenir le nom du Tresor
	 * @return le nom
	 */
	public int getNom() {
	return this.Nom ;
	}
 
}
