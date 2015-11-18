package todoList;

import java.util.ArrayList;

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
    if(categories.contains(p))
      //TODO: Passer en revue toute les tâches, mettre à Sans Categories les == p
      categories.remove(p);
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
    int size=categories.size();
    String sum = "Les différentes catégories sont : [";
    for(int i=0; i<size; ++i){
	     sum+=categories.get(i).get()+", ";
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
}
