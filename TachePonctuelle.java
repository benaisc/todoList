package todoList;


public class TachePonctuelle extends Tache
{
  public TachePonctuelle(String deb, String titre, String categorie)
  {
    super(deb,titre,categorie);
  }

  public void setAvancement(int pourcentage)
  {
    if(pourcentage > 0)
      avancement=1;
      //TODO: archiver la tâche
    else
      avancement=0;
  }
}
