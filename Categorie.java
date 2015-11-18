package todoList;


public class Categorie
{
	protected String nom;

	public Categorie()
	{
    nom="Sans Categorie";
  }
  public Categorie(String s)
  {
    nom=s;
		//if(!contient(s)){ajout(s);}
  }

	public String get()
	{
		return nom;
	}
	
	public void set(String s)
	{
		nom=s;
		//TODO: ajouter au fichier de catégories
	}
}
