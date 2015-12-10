package todoList;

import java.lang.String;
import java.util.Date;
import java.text.SimpleDateFormat;
//import java.text.ParseException; try/catch ?

public class TacheLongCours extends Tache
{
  public TacheLongCours()
  {
    super();
  }

  public TacheLongCours(Date deb, Date fin, String titre, String categorie)
  {
    super(deb,fin,titre,categorie);
  }

  //TODO: TEST pourcentage > 0 && avancement+pourcentage =< 100
  public void setAvancement(int pourcentage)
  {
    int total = pourcentage+avancement;

    if(pourcentage>0 && total<=100)
      avancement+=pourcentage;
    //TODO: if(avancement+pourcentage >= 100) archiver la tâche
  }

  public String toWrite()
  {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String s;
    s=intitule+"\n"+formatter.format(dateDeb)+
      " "+formatter.format(echeance)+" "+categorie+
      " "+avancement+"\n";

    return s;
  }
  public String toString()
  {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String s;
    s=intitule+" de Catégorie "+categorie+
    "; Debut "+formatter.format(dateDeb)+
    "; Fin "+formatter.format(echeance)+
    "; D'avancement : "+avancement+"%";

    return s;
  }
}
