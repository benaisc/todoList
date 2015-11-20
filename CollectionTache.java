package todoList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.Date;

public class CollectionTache
{
  private ArrayList<Tache> codex;
  private ArrayList<Categorie> categories;

  public CollectionTache()
  {
    codex=new ArrayList<Tache>();
    //TODO: remplir avec fichier contenant liste taches
    categories=new ArrayList<Categorie>();
    //TODO: remplir avec fichier contenant liste catégories, sinon :
    categories.add(new Categorie());
    categories.add(new Categorie("Personnel"));
    categories.add(new Categorie("Travail"));
  }


  public void start(){
	String filePath = "~/todoList/taches.txt";
 	//TODO: Tester le path, si le fichier existe : 

	Scanner scanner=new Scanner(new File(filePath));
 
	// On boucle sur chaque champ detecté
	while (scanner.hasNextLine()){
   		String line = scanner.nextLine();
   		System.out.println(line);
		StringTokenizer st = new StringTokenizer(line);
		
		//TODO: Après avoir tokénizer ma line
		Tache T;
		switch(st.nextToken()){
			case(0):
				T=new TachePonctuelle();
			default:
		//TODO: Regarder le 1er token : créer tache Ponctuelle ou tache LongCours
     		while(st.hasMoreTokens()){//TODO: On prend token par token pour remplir cette tache
         		System.out.println(st.nextToken());
     		}
	}
 	scanner.close();
  }

  public void quit(){
	File file = new File ("taches.txt");
	if(file.exists()){
	    System.out.println ("Le fichier existe déjà");
		//TODO:Suppression du fichier + Creation d'un nouveau
	}
	else{
	    try{
		if(file.createNewFile()){
			System.out.println ("Création du fichier réussie");
			int size=codex.size();
			for(int i=0; i<size; ++i){
				file.write(codex[i].toWrite());
			}
		}
		else{
		    System.out.println ("Création du fichier echouée");
		}
	    }
	    catch (IOException exception){
		System.out.println ("Erreur " + exception.getMessage());
	    }
	}
  }

  public int nbTaches()
  {
    return codex.size();
  }
  public boolean contient(Tache t)
  {
    return codex.contains(t);
  }
  public void ajout(Tache t)
  {
    codex.add(t);
  }
  public void retrait(Tache t)
  {
    if(codex.contains(t))
      //TODO: Archiver
			codex.remove(t);
  }

  public int nbCategorie()
  {
    return categories.size();
  }
  public boolean contient(Categorie p)
  {
    return categories.contains(p);
  }
  public void ajout(Categorie p)
  {
    categories.add(p);
  }
  public void retrait(Categorie p)
  {
    //if(categories.contains(p)){
      int size=codex.size();
      for(int i=0; i<size; ++i){
        if(codex.get(i).get_categorie().get()==p.get()){
          codex.get(i).set_categorie("Sans Categorie");
        }
      }
      categories.remove(p);
    //}
  }
  public Categorie get(int i)
  {
	   int size=categories.size();
	    if(i<size)
        return categories.get(i);
  	  else
  	    return categories.get(0);
  }


  public void afficheCollection()
  {
    int size=codex.size();
    System.out.println(size+" tâche(s) restante(s) :");
    int i=0;
    while(i<size){
      System.out.println(codex.get(i).toString());
      ++i;
    }
  }
  public void afficheCategories()
  {
    String sum = "Les différentes catégories sont : [";
    for(Categorie a : categories) {
    	    sum+=a.get()+", ";
    }
    sum+="]";
    System.out.println(sum);
  }

  /*
  TODO: une méthode qui :
  1- Cherche à ouvrir un fichier taches.txt
  2- Si existe, il rempli l'ArrayList de tâches créées à la volée en lisant le fichier
    (Compter le nombre de tokens pour utiliser les bon constructeurs)
  3- Utilisation du logiciel
  4- Supprime le fichier taches.txt
  5- Ecrit un fichier taches.txt des taches de l'ArrayList
  */
  public void tri_echeance(){
    Collections.sort(codex, new DateComparator());
  }

}


class DateComparator implements Comparator<Tache> {
  public int compare(Tache t1, Tache t2) {
	   Date t1d = t1.get_echeance();
     Date t2d = t2.get_echeance();
     if (t1d.after(t2d)) {
       return 1;
     } else if (t1d.before(t2d)) {
       return -1;
     } else {
       return 0;
     }
   }
}
