package todoList;

public class Main
{
  public static void main(String[] args)  throws java.io.IOException
  {
    Categorie categories=new Categorie();
    System.out.println(categories.toString());

    

    TachePonctuelle tp1=new TachePonctuelle("05/12/2015","Nettoyer_Voiture",0);
    System.out.println(tp1.toString());
    //TachePonctuelle tp2=new Tache("05/12/2015","Nettoyer_Cabanon","JARDIN");

    //TacheLongCours tlc1=new Tache("05/12/2015","Nettoyer_Maison",0);
    //TacheLongCours tlc2=new Tache("13/12/2015","Projet_Java",2);
    //TacheLongCours tlc3=new Tache("01/01/2016","07/01/2016","Nettoyer_Foie",1);
  }
}
