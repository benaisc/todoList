package todoList;


public class TacheLongCours extends Tache
{

  public TacheLongCours(String fin, String titre, int num)
  {
    super(fin,titre,num);
  }
  public TacheLongCours(String fin, String titre, String categorie)
  {
    super(fin,titre,categorie);
  }
  public TacheLongCours(String deb, String fin, String titre, String categorie)
  {
    super(deb,fin,titre,categorie);
  }
  public TacheLongCours(String deb, String fin, String titre, int num)
  {
    super(deb,fin,titre,num);
  }

  //TODO: TEST pourcentage > 0 && avancement+pourcentage =< 1
  public void setAvancement(int pourcentage)
  {
    avancement+=pourcentage;
    //TODO: if(avancement+pourcentage == 1) archiver la tâche
  }
}
