package todoList;

import java.util.Date;
import java.lang.String;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public abstract class Tache
{
	protected Date dateDeb;
	protected Date echeance;
	protected String intitule;
	protected int avancement;
	protected Categorie categorie;


	//Ne garder que le constructeur full ?

	public Tache(String fin, String titre)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    try{
			Date dateF = formatter.parse(fin);
			dateDeb = new Date();
			echeance = new Date();
			echeance.setTime(dateF.getTime());
    }catch(ParseException e){
    	e.printStackTrace();
  	}
		categorie=new Categorie();
		intitule = titre;
		avancement = 0;
	}

	public Tache(String fin, String titre, String cat)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    try{
			Date dateF = formatter.parse(fin);
			dateDeb = new Date();
			echeance = new Date();
			echeance.setTime(dateF.getTime());
    }catch(ParseException e){
    	e.printStackTrace();
  	}
		categorie=new Categorie(cat);
		intitule = titre;
		avancement = 0;
	}

	public Tache(String deb, String fin, String titre, String cat)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try{
			Date dateD = formatter.parse(deb);
			Date dateF = formatter.parse(fin);
			dateDeb = new Date();
			dateDeb.setTime(dateD.getTime());
			echeance = new Date();
			echeance.setTime(dateF.getTime());
		}catch(ParseException e){
			e.printStackTrace();
		}
		categorie=new Categorie(cat);
		intitule = titre;
		avancement=0;
	}

	public String get_titre()
	{
		return intitule;
	}
	public String get_categorie()
	{
		return categorie.get();
	}
	public Date get_debut()
	{
		return dateDeb;
	}
	public Date get_echeance()
	{
		return echeance;
	}

	public void set_titre(String s)
	{
		intitule=s;
	}
	public void set_categorie(String s)
	{
		categorie.set(s);
	}
	public void set_echeance(Date fin)
	{
		if(dateDeb.before(fin)){
			echeance.setTime(fin.getTime());
		}
		else{
			System.out.println("Erreur modification_echeance : échéance < dateDeb");
		}
	}

	public abstract void setAvancement(int pourcentage);

	public String toString()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		String s = intitule+" de Catégorie "+categorie.get()+
		"; du "+formatter.format(dateDeb)+" au "+formatter.format(echeance)+";";
		if(this instanceof TacheLongCours)
			s+=" d'avancement : "+avancement+"%";

		return s;
	}

	public String toWrite()
  {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		String s;
		if(this instanceof TacheLongCours)
			s=intitule+"\n"+formatter.format(dateDeb)+" "+formatter.format(echeance)+" "+categorie.get()+" "+avancement+"\n";
		else
			s=intitule+"\n"+formatter.format(dateDeb)+" "+formatter.format(echeance)+" "+categorie.get()+"\n";

		return s;
	}
}
