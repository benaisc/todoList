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
	protected float avancement;
	protected Categorie categorie;


	//Rmq: On ne peut pas créer de tache avec date de début sans catégorie.

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

	public void modification_titre(String s)
	{
		intitule=s;
	}
	public void modification_categorie(String s)
	{
		categorie.set(s);
		//TODO : Accès aux Categories ??????????????????????????????????
	}
	public void modification_echeance(Date fin)
	{
		if(dateDeb.before(fin)){
			echeance.setTime(fin.getTime());
		}
		else{
			System.out.println("Erreur modification_echeance : échéance < dateDeb");
		}
	}

	public abstract void setAvancement(float pourcentage);

	public String toString()
  {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		String s = intitule+", de catégorie "+categorie.get()+
		", commence le "+formatter.format(dateDeb)+
		" et fini le "+formatter.format(echeance);
		if(this instanceof TacheLongCours)
			s+=" d'avancement évalué à "+avancement+"%";

		return s;
	}
}
