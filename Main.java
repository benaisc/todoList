package todoList;

public class Main
{
  public static void main(String[] args)  throws java.io.IOException
  {

    Tache tp1=new TachePonctuelle("05/12/2015","Nettoyer_Voiture");
    Tache tp2=new TachePonctuelle("05/12/2015","Nettoyer_Cabanon","Jardin");

    Tache tlc1=new TacheLongCours("13/12/2015","Projet_Java","Travail");
    Tache tlc2=new TacheLongCours("01/01/2016","07/01/2016","Nettoyer_Foie","Personnel");

    CollectionTache collec=new CollectionTache();
    collec.ajout(tp1);
    collec.ajout(tp2);
    collec.ajout(tlc1);
    collec.ajout(tlc2);

    collec.afficheCollection();
    collec.afficheCategories();

  }
}
