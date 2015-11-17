package todoList;

import java.util.Vector<E>;

public class Categorie
{
	protected String cat;





	public Categorie()
	{
		v = new Vector<String>();
		v.add("Sans Categorie");
		v.add("Personnel");
		v.add("Travail");
	}

	public void add(String type)
	{
		v.add(type);
	}

	public void remove(String type)
	{
		if(v.contains(type))
			v.remove(type);
		//TODO: vérifier+modifier les taches qui possédaient cette catégorie
	}

	public void toString()
	{
		System.out.println("Les différentes catégories sont "+v.toString());
	}
}
