package todoList;


public class TachePonctuelle extends Tache
{

  public TachePonctuelle(String fin, String titre, int num)
  {
    super(fin,titre,num);
  }
  public TachePonctuelle(String fin, String titre, String categorie)
  {
    super(fin,titre,categorie);
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
