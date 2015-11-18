package todoList;

public class Main
{
  public static void main(String[] args)  throws java.io.IOException
  {
    Categories categories=new Categories();
    System.out.println(categories.toString());



    Tache tp1=new TachePonctuelle("05/12/2015","Nettoyer_Voiture");
    Tache tp2=new TachePonctuelle("05/12/2015","Nettoyer_Cabanon","Jardin");
    //TacheLongCours tlc1=new Tache("05/12/2015","Nettoyer_Maison","Personnel");
    //TacheLongCours tlc2=new Tache("13/12/2015","Projet_Java","Travail");
    //Tache tlc3=new TacheLongCours("01/01/2016","07/01/2016","Nettoyer_Foie","Personnel");

    CollectionTache collec=new CollectionTache();
    collec.add(tp1);
    collec.add(tp2);
    //collec.add(tlc3);
    collec.afficheCollection();

  }
}
