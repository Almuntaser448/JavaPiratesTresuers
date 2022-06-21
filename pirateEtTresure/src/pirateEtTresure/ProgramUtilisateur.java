 package pirateEtTresure;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
 /**
 * Represente un Program Utilisateur 
 * 
*
 * @ author BASHITI Almuntaser 
 * @ author FLISSI Said 
 * @ author MICHAELI Noé
 *
 */
 public class ProgramUtilisateur {
        /**
	 * création de ArrayList des Tresors  
	 */
	public static List<Tresor> lesTresors = new ArrayList<Tresor>();
	 /**
	 * création de ArrayList des Pirates 
	 */
	public static List<Pirate> LesPirates = new ArrayList<Pirate>();

         /**
	 * initialisation du nombre des objets qui permet d'entrer un nombre ou un caractére 
	 */
	public static void initialisation(int nombreTotalDesObjets) {
		int charValue = nombreTotalDesObjets; // this is the number you enter
		char lettre = (char) (charValue + 64); // this is the character you want
		int i = 0;
		for (char c = 'A'; c <= lettre; ++c) {
			LesPirates.add(new Pirate(c));
			lesTresors.add(new Tresor(i + 1, true));
			i++;
		}
	}
	
	
        /**
	 * Permet de verifier si les conditions sont bien  respectées 
	 * @return vrai si la condition respecté ou sinon faux 
	 */
	 
	public static boolean verif() {
		boolean ConditionRespecte = true;
		for (int i = 0; i < LesPirates.size(); i++) {
			if (LesPirates.get(i).pas_de_prefernces()) {
				char lettre = (char) ((i + 1) + 64);
				ConditionRespecte = false;
				System.out.println("erreur le pirate " + lettre + " n'a pas de prefernces ");
			}
		}
		if (ConditionRespecte) {
			return true;
		}
		return false;
	}
	
	/**
	 * Ajoute des relations entre les Pirates 
	 *
	 * @param sc un Scnaner qui permet de faire la saisie 
	 */

	public static void ajoutDesRelations(Scanner sc) {
		String pirateArraydeChar = "";
		System.out.println("Merci de saisire les pirates qui sont jalous l'un pour l'autre sepearé par un espace");
		pirateArraydeChar += sc.nextLine();
		char nomDesPirate[] = pirateArraydeChar.toCharArray();
		List<Pirate> LesPiratesJalouseEntreEux = new ArrayList<Pirate>();
		
		for (int i = 0; i < LesPirates.size(); i++) {
			for (int y = 0; y < nomDesPirate.length; y = y + 2) {
				if (LesPirates.get(i).getNom() == nomDesPirate[y]) {
					LesPiratesJalouseEntreEux.add(LesPirates.get(i));
				}
			}
		}
		// changement des relations
		for (int i = 0; i < LesPiratesJalouseEntreEux.size(); i++) {
			for (int y = 0; y < LesPiratesJalouseEntreEux.size(); y++) {
				if (!(LesPiratesJalouseEntreEux.get(i) == LesPiratesJalouseEntreEux.get(y))) {
					LesPiratesJalouseEntreEux.get(i).AjouterJalousie(LesPiratesJalouseEntreEux.get(y));
				}
			}
		}
	}
        /**
	 *Utilise une solution Naive pour limiter la compliexite on utilise la liste des tresor prefer de chaque pirate 
																							//
	 */

	public static void SoultionNaive() {
		for (int i = 0; i < LesPirates.size(); i++) {
			for (int y = 0; y < LesPirates.get(i).getListeDesTresorsPrefere().size(); y++) {
										
				if (LesPirates.get(i).getListeDesTresorsPrefere().get(y).getDispo() == true) {
					LesPirates.get(i).setTresorActuel(LesPirates.get(i).getListeDesTresorsPrefere().get(y));
					LesPirates.get(i).getListeDesTresorsPrefere().get(y).setDispo(false);
					break;
				}
			}
		}
	}
        
        
        /**
	 * Permet de faire une modification et un echange entre les objets 
	 *
	 * @param sc un Scnaner qui permet de faire la saisie
	 */
	public static void EchangerDesObjets(Scanner sc) {
		System.out.println(
				"Veuiliez entre le nom de premier pirate en suite le nom du deuxieme pirate separe par espace");
		String LesPiratesPourEchanger = "";
		Tresor temp = new Tresor(-1, true);
		LesPiratesPourEchanger += sc.nextLine();
		for (int i = 0; i < LesPirates.size(); i++) {
			if (LesPirates.get(i).getNom() == LesPiratesPourEchanger.charAt(0)) { 
			// 0 est pour la premier pirate 1 c'est l'espace et 2 est le deuxieme pirate
																					// 
																					
				if (LesPirates.get(i).getTresorActuel().getNom() != -1) {
					temp = LesPirates.get(i).getTresorActuel();
					for (int y = 0; y < LesPirates.size(); y++) {
						if (LesPirates.get(y).getNom() == LesPiratesPourEchanger.charAt(2)) {
							LesPirates.get(i).setTresorActuel(LesPirates.get(y).getTresorActuel());
							LesPirates.get(y).setTresorActuel(temp);
							System.out.println("les tresors sont bien modifie");
						}
					}
				}
			}
		}
	}
        /**
	 * Permet de faire le cout total de jalousie pour  les pirates 
	 * et ensuite faire l'affichage 
	 */
	public static void AffichageCout() {
		int Cout = 0;
		for (int i = 0; i < LesPirates.size(); i++) {
			for (int y = 0; y < LesPirates.size(); y++) {
				if (LesPirates.get(i).estJalousie(LesPirates.get(y))) {
					if (LesPirates.get(i).getTresorPrefernce(LesPirates.get(y).getTresorActuel()) < LesPirates.get(i)
							.getTresorPrefernce(LesPirates.get(i).getTresorActuel())) {
						System.out.println("Le pirate " + LesPirates.get(i).getNom() + " est jalouse du pirate "
								+ LesPirates.get(y).getNom());
						Cout += 1;
						break;
					} 

				}
			}

		}
		if (Cout == 1) {
			System.out.println("La cout totale de cette solutions est " + Cout + " seul pirate jaloux");
		} else if (Cout == 0) {
			System.out.println("Bravo dans cette solution il n'y a pas des pirates jaloux");

		} else {
			System.out.println("La cout totale de cette solutions est " + Cout + " pirates jaloues");

		}
	}

	public static void MessageDeRappele() {
		for (int i = 0; i < LesPirates.size(); i++) {
			System.out.println(LesPirates.get(i).getNom() + " : o" + LesPirates.get(i).getTresorActuel().getNom());
		}
	}
        
         /**
	 * Ajoute une preference d'un Tresor pour un Pirate particulier  
	 *
	 * @param sc un Scnaner qui permet de faire la saisie
	 */
	public static void AjouterPrefernces(Scanner sc) {
		System.out.println("veuiliz entrer la prefernces comme l'example suivante\n A 1 2 3...n");
		String ListePirateEtTresor = "";
		ListePirateEtTresor += sc.nextLine();
		char PiarteEtTresorEnArray[] = ListePirateEtTresor.toCharArray();
		for (int i = 0; i < LesPirates.size(); i++) {
			if (LesPirates.get(i).getNom() == PiarteEtTresorEnArray[0]) {
				for (int z = 2; z < PiarteEtTresorEnArray.length; z = z + 2) {
					for (int y = 0; y < lesTresors.size(); y++) {

						if (lesTresors.get(y).getNom() == Character.getNumericValue(PiarteEtTresorEnArray[z])) {
							LesPirates.get(i).AjoutTresorAime(lesTresors.get(y));
						}
					}
				}
			}
		}

	}
        
          /**
	 * Permet de choisir une option  en choisissant un chiffre donné   
	 *
	 * @param sc un Scnaner qui permet de faire la saisie
	 */
	public static int ChoisirUneOption(Scanner sc) {
		boolean erreurDeEntrer = false;
		int i = 0;
		do {
			try {
				i = sc.nextInt();
				sc.nextLine();
				if (i > 3 || i < 1) {
					System.out.println("Merci de bien indiquer un chiffre entre 1 et 3");
					erreurDeEntrer = true;

				} else {
					return i;
				}
			} catch (InputMismatchException e) {
				erreurDeEntrer = true;
				System.out.println("Merci de bien indiquer un chiffre ");
				sc.nextLine();
			}
		} while (erreurDeEntrer);
		return 0;
	}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean erreurDeType = false;
		System.out.println(
				"Bonjour et Binevnue dans l'application de simulation de simulation de distrubtion des tresors");
		System.out.println("Veuiliez ecrire le nombre de Pirates qui doit etre la meme que les Tresors");
		int i = 0;
		do {
			try {
				i = sc.nextInt();
				sc.nextLine();

			} catch (InputMismatchException e) {
				System.out.println("Merci de bien indiquer un chiffre ");
				erreurDeType = true;
			}
		} while (erreurDeType);

		initialisation(i);
		boolean finDePreparations = false;
		while (!finDePreparations) {

			System.out.println(
					"Choisir l'option que vous voulez faire\n 1 pour ajouter une relation entre les pirate (la raltion sera ajoute a tout les pirates entree)\n 2 pour ajouter des prefrences a un pirate donne \n 3 pour finir et passer a l'etape suivanet (chaque pirate doit avoir sa propre liste de prefirences)");

			i = ChoisirUneOption(sc);
			switch (i) {
			case 1:
				ajoutDesRelations(sc);
				break;
			case 2:
				AjouterPrefernces(sc);
				break;
			case 3:
				if (verif()) {
					finDePreparations = true;
				}
				break;
			}
		}
		SoultionNaive();
		boolean fin = false;
		while (!fin) {
			System.out.println(" \n \n \n");
System.out.println("la solution actuel est :");
			MessageDeRappele();
			System.out.println("\n");
			System.out.println(
					"veiuliez choisr une option: \n 1 pour Echanger les tresors entre deux pirates \n 2 pour afficher la cout actuelle\n 3 pour finir la program");

			i = ChoisirUneOption(sc);
			switch (i) {
			case 1:
				EchangerDesObjets(sc);// fin
				break;
			case 2:
				AffichageCout();
				break;
			case 3:
				fin = true;
				break;
			}
		}
		sc.close();
		System.out.println("Merci de nous avoir utilise\nAu revoir");
	}
}
