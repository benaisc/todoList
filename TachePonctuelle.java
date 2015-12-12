package todoList;

import java.lang.String;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;


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
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String s;
    s=intitule+"\n"+formatter.format(dateDeb)+
      " "+formatter.format(echeance)+" "+categorie+"\n";

    return s;
  }

  public String toString()
  {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String s;
    s=intitule+" de Catégorie "+categorie+
      "; Debut "+formatter.format(dateDeb)+
      "; Fin "+formatter.format(echeance);

    return s;
  }
}
