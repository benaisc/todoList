package todoList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/*
ModifTache permet la création d'une nouvelle tâche via
une Fenêtre contenant 3 ou 4 champs initialisés (titre, categorie, debut et? fin)
A la fermeture de la fenêtre on écrase la tache d'origine pour une nouvelle tache
*/
public class ModifTache extends JFrame
{
	protected JPanel p;
	protected JLabel l1,l2,l3,l4,l5,lsupp;
	protected JTextField t1,t2,t3,t4,t5;
	protected JCheckBox chk;
	protected JButton b1;
	protected boolean isLongCours;

	public ModifTache(Tache c)
	{
		setTitle("jModifTache");
		p = new JPanel();
		add(p);
		p.setPreferredSize(new Dimension(350,200));
		p.setLayout(new FlowLayout());

		l1 = new JLabel("Titre : ");
		t1 = new JTextField(c.get_titre(),20);
		p.add(l1);
		p.add(t1);
		l2 = new JLabel("Categorie : ");
		t2 = new JTextField(c.get_categorie(),20);
		p.add(l2);
		p.add(t2);

		lsupp = new JLabel("Modifier la catégorie des autres taches ?");
		chk = new JCheckBox();
		p.add(lsupp);
		p.add(chk);

		l3 = new JLabel("Date début : ");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		t3 = new JTextField(formatter.format(c.get_debut()),20);
		p.add(l3);
		p.add(t3);

		l4 = new JLabel("Date fin : ");
		t4 = new JTextField(formatter.format(c.get_echeance()),20);
		p.add(l4);
		p.add(t4);

		if(c instanceof TacheLongCours){
			l5 = new JLabel("Avancement : ");
			t5 = new JTextField(Integer.toString(c.get_avancement()),5);
			p.add(l5);
			p.add(t5);
			isLongCours=true;
		}
		else{isLongCours=false;}

		b1 = new JButton("Ok");
		b1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(isThere()){
					c.set_titre(fetch_titre());
					c.set_categorie(fetch_categorie());
					c.set_debut(fetch_deb());
					c.set_echeance(fetch_fin());
					if(isLongCours){
						c.setAvancement(fetch_avancement());
					}
					dispose();
				}
			}
		});
		p.add(b1);

		pack();
	}

	public ModifTache(){
		setTitle("jModifTache");
		p = new JPanel();
		add(p);
		p.setPreferredSize(new Dimension(300,100));
		p.setBackground(Color.red);

		l1 = new JLabel("Selectionnez une tache à modifier");
		p.add(l1);

		pack();
	}

	public boolean isThere(){
		return (test_date(t3.getText()) && test_date(t4.getText()));
	}
	//match : dd/mm/yyyy
	public boolean test_date(String date){
		String regex_date="^(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)\\d\\d$";
		return date.matches(regex_date);
	}

	public String fetch_titre(){
		String titre=t1.getText();
		if(titre.equals("")){
			titre="Sans_Titre";
		}
		return titre;
	}

	public String fetch_categorie(){
		String oneWordCat=t2.getText();
		//match : no spaces ou null
		if(!oneWordCat.matches("/^\\S/")){
			oneWordCat="Sans_Categorie";
		}
		return oneWordCat;
	}

	public Date fetch_deb(){
		String dd_valide=t3.getText();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date deb;
		try{
			if(test_date(dd_valide)){
				return formatter.parse(dd_valide);
			}
			else{
				return new Date();
			}
		}catch(ParseException err){
			err.printStackTrace();
			return new Date();
		}
	}

	public Date fetch_fin(){
		String df_valide=t4.getText();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try{
			if(test_date(df_valide)){
				return formatter.parse(df_valide);
			}
			else{
				return new Date();
			}
		}catch(ParseException err){
			err.printStackTrace();
			return new Date();
		}
	}

	public int fetch_avancement(){
		String av=t5.getText();
		int val=0;
		if(av.matches("\\d+")){val=Integer.parseInt(av);}
		return val;
	}

	public boolean checkbox(){
		return chk.isSelected();
	}

}
