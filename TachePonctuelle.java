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

  public void setAvancement(int pourcentage)
  {
    avancement=1;
  }
}
