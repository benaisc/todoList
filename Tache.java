public class Tache{
	//private Date echeance;
	private String titre;
	private float avancement;
	private Categorie cat;
	public Tache(Date e, String t)
	{
		//echeance = e; Voir la gestion du format Date
		titre = t;
		cat = new cat();
	}
	public Tache(Date e, String t, Categorie c)
	{
		//echeance = e; Voir la gestion du format Date
		titre = t;
		cat = c;
	}
}
