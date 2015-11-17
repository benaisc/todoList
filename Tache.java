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
	protected String categorie;


	//Rmq: On ne peut pas créer de tache avec date de début sans catégorie.
	//TODO: Ajouter la catégorie aux Categorie si elle n'existe pas déjà

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
		intitule = titre;
		avancement = 0;
		categorie = "Sans Categorie";
	}

	public Tache(String fin, String titre, String cat)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    try{
			Date dateF = formatter.parse(fin);
			dateDeb = new Date();
			echeance.setTime(dateF.getTime());
    }catch(ParseException e){
    	e.printStackTrace();
  	}
		intitule = titre;
		avancement = 0;
		categorie = cat;
	}

	public Tache(String deb, String fin, String titre, String cat)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try{
			Date dateD = formatter.parse(deb);
			Date dateF = formatter.parse(fin);
			dateDeb.setTime(dateD.getTime());
			echeance.setTime(dateF.getTime());
		}catch(ParseException e){
			e.printStackTrace();
		}
		intitule = titre;
		avancement=0;
		categorie=cat;
	}

	public void modification_titre(String s)
	{
		intitule=s;
	}
	public void modification_categorie(String c)
	{
		categorie=c;
	}
	public void modification_echeance(Date fin)
	{
		if(dateDeb.before(fin)){
			echeance.setTime(fin.getTime());
		}
		else{
			System.out.println("Erreur dans la saisie de l'échéance.");
		}
	}

	public abstract void setAvancement(int pourcentage);

	public String toString()
  {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		return intitule+", de catégorie "+categorie+
		", commence le "+formatter.format(dateDeb)+
		" et fini le "+formatter.format(echeance)+
		" d'avancement évalué à "+avancement+"%";
	}
}
