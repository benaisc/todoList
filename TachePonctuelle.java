package todoList;

import java.lang.String;
import java.util.Date;
import java.util.Calendar;


public class TachePonctuelle extends Tache
{
  public TachePonctuelle()
  {
    super();
  }

  public TachePonctuelle(Date deb, Date fin, String titre, String categorie)
  {
    super(deb,fin,titre,categorie);
  }

  public void setAvancement(int pourcentage){ }

  public boolean isLineaire()
  {
    Calendar dj = Calendar.getInstance();
    return echeance.after(dj.getTime());
  }

  public String toWrite()
  {
    return super.toWrite()+"\n";
  }

  public String toString()
  {
    return super.toString();
  }
}
