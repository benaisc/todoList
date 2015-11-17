package todoList;

public class Main
{
  public static void main(String[] args)  throws java.io.IOException
  {
    System.out.println("Hello World");

    TachePonctuelle tp1=new Tache("05/12/2015","Nettoyer_Voiture");
    TachePonctuelle tp2=new Tache("05/12/2015","Nettoyer_Cabanon","JARDIN");

    TacheLongCours tlc1=new Tache("05/12/2015","Nettoyer_Maison");
    TacheLongCours tlc2=new Tache("13/12/2015","Projet_Java","TRAVAIL");
    TacheLongCours tlc3=new Tache("01/01/2016","07/01/2016","Nettoyer_Foie","PERSONNEL");
  }
}
