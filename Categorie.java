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
  }

	public String get()
	{
		return nom;
	}
	public void set(String s)
	{
		nom=s;
	}
}
