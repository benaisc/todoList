package todoList;

import java.util.Vector;

public class Categorie
{
	protected Vector<String> v;

	public Categorie()
	{
		v = new Vector<String>();
		v.add("Sans Categorie");
		v.add("Personnel");
		v.add("Travail");
	}

	public void ajout(String type)
	{
		v.add(type);
	}

	public void retrait(String type)
	{
		if(v.contains(type))
			v.remove(type);
		//TODO: vérifier+modifier les taches qui possédaient cette catégorie
	}

	public String toString()
	{
		return "Les différentes catégories sont "+v.toString();
	}
}
