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
    Calendar dj = Calendar.getInstance();

    if(avancement<25){
      dj.add(Calendar.DAY_OF_MONTH,4);
      return echeance.after(dj.getTime());
    }
    else if(avancement<50){
      dj.add(Calendar.DAY_OF_MONTH,2);
      return echeance.after(dj.getTime());
    }
    else if(avancement<75){
      dj.add(Calendar.DAY_OF_MONTH,1);
      return echeance.after(dj.getTime());
    }
    else{
      return echeance.after(dj.getTime());
    }
  }

  public String toWrite()
  {
    return super.toWrite()+" "+avancement+"\n";
  }

  public String toString()
  {
    return super.toString()+"; D'avancement : "+avancement+"%";
  }
}
