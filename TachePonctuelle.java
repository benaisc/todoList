package todoList;


public class TachePonctuelle extends Tache
{
  public TachePonctuelle(String fin, String titre)
  {
    super(fin,titre);
  }
  public TachePonctuelle(String fin, String titre, String categorie)
  {
    super(fin,titre,categorie);
  }
  public TachePonctuelle(String deb, String fin, String titre, String categorie)
  {
    super(deb,fin,titre,categorie);
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
