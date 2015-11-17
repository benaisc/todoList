package todoList;

import java.util.ArrayList;

public class CollectionTache
{
  private ArrayList<Tache> codex;

  public CollectionTache()
  {
    codex=new ArrayList<Tache>();
  }

  public void add(Tache p)
  {
    codex.add(p);
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
