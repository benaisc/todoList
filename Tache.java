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
	protected String categorie;

	public Tache()
	{
		dateDeb = new Date();
		echeance = new Date();
		categorie="Sans_Categorie";
		intitule = "Sans_Titre";
		avancement=0;
	}
	public Tache(Date deb, Date fin, String titre, String cat)
	{
		dateDeb = new Date();
		echeance = new Date();
		dateDeb.setTime(deb.getTime());
		echeance.setTime(fin.getTime());
		categorie=cat;
		intitule = titre;
		avancement=0;
	}

	public String get_titre()
	{
		return intitule;
	}
	public String get_categorie()
	{
		return categorie;
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
		categorie=s;
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
	public abstract String toString();
	public abstract String toWrite();

}
