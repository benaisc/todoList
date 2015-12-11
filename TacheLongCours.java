package todoList;

import java.lang.String;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;


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
  public TacheLongCours(Date deb, Date fin, String titre, String categorie, int av)
  {
    super(deb,fin,titre,categorie,av);
  }

  public void setAvancement(int pourcentage)
  {
    avancement=pourcentage;
  }

  public boolean isLineaire(){
    Calendar c = Calendar.getInstance();

    if(avancement<=25){
      c.add(Calendar.DAY_OF_MONTH,4);
      return c.before(echeance);
    }
    else if(avancement<=50){
      c.add(Calendar.DAY_OF_MONTH,2);
      return c.before(echeance);
    }
    else if(avancement<=75){
      c.add(Calendar.DAY_OF_MONTH,1);
      return c.before(echeance);
    }
    else{
      return c.before(echeance);
    }
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
