package pirateEtTresure;

import java.util.ArrayList;
import java.util.List;
/**
 * Represente un pirate
 *
 */

public class Pirate {
        /**
	 * Le nom du pirate 
	 */
	private char nom;
	 /**
	 * le Tresor  TresureActuel
	 */
	private Tresor TresureActuel;
	/**
	 * La liste des Tresors  presents dans le TresorAime
	 */
	private List<Tresor> TresorAime;
	
	/**
	 * La liste des Pirates qui ont  la jalousie 
	 */
	private List<Pirate> jalousie;
	
        /*
	 * Construit un pirate  dont le nom est donné 
	 * et nom ="" and disponible =false
	 
	 * @param nom le nom du pirate 
	 */
	public Pirate(char n) {
		this.nom = n;
		this.TresorAime = new ArrayList<Tresor>();
		this.jalousie = new ArrayList<Pirate>();
		this.TresureActuel = new Tresor(-1, false);
	}
	
	
	/**
	 * Permet d'obtenir le nom du pirate 
	 * 
	 * @return le nom d'un pirate 
	 */
	public char getNom() {
		return this.nom;
	}
	/**
	 * Permet d'obtenir le trésor  
	 * 
	 * @return le TresureActuel 
	 */
	public Tresor getTresorActuel() {
		return this.TresureActuel;
	}
	
	/**
	 * Permet de specifier l'état du tresor 
	
	 */

	public void setTresorActuel(Tresor t) {
		this.TresureActuel = t;
	}
        
        /**
	 * Ajoute une Jalousie pour un pirate particulier
	 * 
	 * @param  p  le pirate  à qui en joute 
	
	 */
	public void AjouterJalousie(Pirate p) {
		this.jalousie.add(p);
	}
        /**
	 * vérifie s'il y a une Jalousie pour un pirate particulier 
	 * @return la jalousie d'un pirate 
	 */
	public boolean estJalousie(Pirate p) {
		return this.jalousie.contains(p);
	}
         /**
	 * Ajoute une perference Aime  specifié  pour un Tresor 
	 * 
	 * @param  t  le tresor 
	
	 */
	public void AjoutTresorAime(Tresor t) {
		this.TresorAime.add(t);
	}

	public boolean pas_de_prefernces() {
		return this.TresorAime.isEmpty();
	}
        
        /**
	 * Permet d'obtenir le contenu de la list des préferences du Tresor 
	 * @return le TresorAime
	 */
	public List<Tresor> getListeDesTresorsPrefere() {
		return this.TresorAime;
	}

	/**
	 * Permet d'obtenir la position  d'un tresor dans la list aime 
	 * @param t le tresor 
	 * @return i si le tresor n'est pas dans aime ou sinon TresorAime.size +1
	 */
	public int getTresorPrefernce(Tresor t) {
		for (int i = 0; i < this.TresorAime.size(); i++) {
			if (this.TresorAime.get(i) == t) {
				return i;
			}
		}
		return this.TresorAime.size() + 1;
	}
}
