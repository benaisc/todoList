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
		//TODO: remplir avec fichier contenant liste catégories -> sinon créer+remplir
	}

	public String get(int i)
	{
		int size=v.size();
		if(i<size)
			return v.get(i);
		else
			return v.get(0);
	}
	public int taille()
	{
		return v.size();
	}
	public boolean contient(String type)
	{
		return v.contains(type);
	}
	public void ajout(String type)
	{
		if(!v.contains(type))
			v.add(type);
		//TODO: ajouter au fichier de catégories
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
