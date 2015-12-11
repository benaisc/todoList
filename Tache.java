package todoList;

import java.util.Date;
import java.lang.String;


public abstract class Tache
{
	protected String intitule;
	protected String categorie;
	protected Date dateDeb;
	protected Date echeance;
	protected int avancement;

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
		dateDeb = deb;
		echeance = fin;
		categorie=cat;
		intitule = titre;
		avancement=0;
	}
	public Tache(Date deb, Date fin, String titre, String cat, int av)
	{
		dateDeb = deb;
		echeance = fin;
		categorie=cat;
		intitule = titre;
		avancement=av;
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
	public int get_avancement()
	{
		return avancement;
	}
	public void set_titre(String s)
	{
		intitule=s;
	}
	public void set_categorie(String s)
	{
		categorie=s;
	}
	public void set_debut(Date deb)
	{
		dateDeb=deb;
	}
	public void set_echeance(Date fin)
	{
		echeance=fin;
	}

	public abstract void setAvancement(int pourcentage);
	public abstract boolean isLineaire();
	public abstract String toString();
	public abstract String toWrite();

}
