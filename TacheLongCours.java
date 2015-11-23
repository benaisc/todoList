package todoList;


public class TacheLongCours extends Tache
{

  public TacheLongCours(String fin, String titre)
  {
    super(fin,titre);
  }
  public TacheLongCours(String fin, String titre, String categorie)
  {
    super(fin,titre,categorie);
  }
  public TacheLongCours(String deb, String fin, String titre, String categorie)
  {
    super(deb,fin,titre,categorie);
  }

  //TODO: TEST pourcentage > 0 && avancement+pourcentage =< 100
  public void setAvancement(int pourcentage)
  {
    avancement+=pourcentage;
    //TODO: if(avancement+pourcentage == 100) archiver la tâche
  }
}
