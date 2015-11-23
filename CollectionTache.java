package todoList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CollectionTache
{
  private ArrayList<Tache> codex;
  private ArrayList<Categorie> categories;

  public CollectionTache()
  {
    codex=new ArrayList<Tache>();
    start_taches();

    categories=new ArrayList<Categorie>();
    start_categories();
  }

  public void start_taches(){
    String filePath = "./todoList/taches";
    File file = new File(filePath);

    if(file.exists()){
      try{
        Scanner scanner=new Scanner(new File(filePath));
        while(scanner.hasNextLine()){
          String title = scanner.nextLine();
          String line = scanner.nextLine();
          StringTokenizer st = new StringTokenizer(line);

          String dateD=st.nextToken();
          String dateF=st.nextToken();
          String cat=st.nextToken();

          Tache T;
          if(st.hasMoreTokens()){
            T=new TacheLongCours(dateD,dateF,title,cat);
            String avance=st.nextToken();
            T.setAvancement(Integer.parseInt(avance));
          }
          else{
            T=new TachePonctuelle(dateD,dateF,title,cat);
          }
          codex.add(T);
        }
        scanner.close();
      }catch(FileNotFoundException fnf){
        fnf.printStackTrace();
      }
    }
  }

  public void start_categories(){
    String filePath = "./todoList/categories";
    File file = new File(filePath);
    if(file.exists()){
      try{
        Scanner scanner=new Scanner(new File(filePath));
        while(scanner.hasNextLine()){
          String line = scanner.nextLine();
          categories.add(new Categorie(line));
        }
        scanner.close();
      }catch(FileNotFoundException fnf){
        fnf.printStackTrace();
      }
    }
    else{//Le fichier sera créer au quit(), on fait son initialisation
      categories.add(new Categorie());
      categories.add(new Categorie("Personnel"));
      categories.add(new Categorie("Travail"));
    }
  }

  public void retrait(Tache t)
  {
    if(codex.contains(t))
			codex.remove(t);
  }
  public boolean contient(Tache t)
  {
    return codex.contains(t);
  }
  public void ajout(Tache t)
  {
    if(!codex.contains(t))
      codex.add(t);
  }

  public boolean contient(Categorie p)
  {
    return categories.contains(p);
  }
  public Categorie get(int i)
  {
     int size=categories.size();
      if(i<size)
        return categories.get(i);
      else
        return categories.get(0);
  }
  public void ajout(Categorie p)
  {
    if(!categories.contains(p))
      categories.add(p);
  }
  public void retrait(Categorie p)
  {
    if(categories.contains(p)){
      int size=codex.size();
      for(int i=0; i<size; ++i){
        if(codex.get(i).get_categorie().get()==p.get()){
          codex.get(i).set_categorie("Sans_Categorie");
        }
      }
      categories.remove(p);
    }
  }

  public void ecrire_Tache(){
    File file = new File ("./todoList/taches");
    if(file.exists()){
      System.out.println ("Le fichier de taches existe déjà; On le supprime.");
      file.delete();
    }
    try{
      if(file.createNewFile()){
        FileWriter writer = new FileWriter(file);
        System.out.println ("Création du fichier taches réussie");
        int size=codex.size();
        for(int i=0; i<size; ++i){
          String s=codex.get(i).toWrite();
          writer.write(s);
          writer.flush();
        }
        writer.close();
      }
      else{
        System.out.println ("Création du fichier echouée");
      }
    }
    catch (IOException e){
      System.out.println ("Erreur " + e.getMessage());
    }
  }

  public void ecrire_Categories(){
    File file = new File ("./todoList/categories");
    if(file.exists()){
      System.out.println ("Le fichier de categories existe déjà; On le supprime.");
      file.delete();
    }
    try{
      if(file.createNewFile()){
        System.out.println ("Création du fichier categories réussie");
        FileWriter writer = new FileWriter(file);
        int size=categories.size();
        for(int i=0; i<size; ++i){
          String s=categories.get(i).get()+"\n";
          writer.write(s);
          writer.flush();
        }
        writer.close();
      }
      else{
        System.out.println ("Création du fichier echouée");
      }
    }
    catch (IOException e){
      System.out.println ("Erreur " + e.getMessage());
    }
  }
/*
public void archiver_Tache(Tache t)
{
  File file = new File ("taches_archivees.txt");
  if(file.exists()){
    System.out.println ("Le fichier existe déjà");
    //TODO: APPEND les taches au fichier
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
*/

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
