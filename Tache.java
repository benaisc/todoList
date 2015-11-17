package todoList;

java.util.Date;
java.lang.String;

public abstract class Tache
{
	protected Date dateDeb;
	protected Date echeance;
	protected String intitule;
	protected float avancement;
	protected String categorie;

	public Tache(String fin, String titre)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    try{
			Date dateF = formatter.parse(fin);
    }catch(ParseException e){
    	e.printStackTrace();
  	}
		dateDeb = new Date();
		echeance = dateF;
		intitule = titre;
		avancement = 0,0;
		categorie = "Sans Categorie";
	}

	public Tache(String fin, String titre, String cat)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    try{
			Date dateF = formatter.parse(fin);
    }catch(ParseException e){
    	e.printStackTrace();
  	}
		dateDeb = new Date();
		echeance = dateF;
		intitule = titre;
		avancement = 0,0;
		categorie = cat;
	}

	public Tache(String deb, String fin, String titre)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    try{
    	Date dateD = formatter.parse(deb);
			Date dateF = formatter.parse(fin);
    }catch(ParseException e){
    	e.printStackTrace();
  	}
		dateDeb = dateD;
		echeance = dateF;
		intitule = titre;
		avancement = 0,0;
		categorie = "Sans Categorie";
	}
	public Tache(String deb, String fin, String titre, String cat)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try{
			Date dateD = formatter.parse(deb);
			Date dateF = formatter.parse(fin);
		}catch(ParseException e){
			e.printStackTrace();
		}
		dateDeb = dateD;
		echeance = dateF;
		intitule = titre;
		avancement=0,0;
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
		if(dateDeb < fin){
			echeance=fin;
		}
		else{
			System.out.println("Erreur dans la saisie de l'échéance.");
		}
	}

	public abstract void setAvancement(int pourcentage);

	public String toString()
  {
		return intitule+", de catégorie "+categorie+
		", commence le "+dateDeb.toString()+" et fini le "+echeance.toString()+
		" d'avancement évalué à "+avancement*100+"%.";
	}
}
