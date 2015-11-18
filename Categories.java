package todoList;

import java.util.Vector;

public class Categories
{
	protected Vector<Categorie> v;

	public Categories()
	{
		v = new Vector<Categorie>();
		v.add(new Categorie());
		v.add(new Categorie("Personnel"));
		v.add(new Categorie("Travail"));
		//TODO: remplir avec fichier contenant liste catégories -> sinon créer+remplir
	}

	public Categorie get(int i)
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
	public boolean contient(Categorie type)
	{
		return v.contains(type);
	}
	public void ajout(Categorie type)
	{
		if(!v.contains(type))
			v.add(type);
		//TODO: ajouter au fichier de catégories
	}
	public void retrait(Categorie type)
	{
		if(v.contains(type))
			v.remove(type);
		//TODO: vérifier+modifier les taches qui possédaient cette catégorie
	}

	public String toString()
	{
		int size=v.size();
		String sum = "Les différentes catégories sont : [";
		for(int i=0; i<size; ++i){
			sum+=v.get(i).get()+", ";
		}
		sum+="]";
		return sum;
	}
}
