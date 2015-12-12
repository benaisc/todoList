package todoList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/*
CreerTache permet l'initialisation d'une nouvelle tâche via
une Fenêtre contenant 4 champs (titre, categorie, debut, fin) et
un bouton send qui remplit un Array qui sera récup par
notre TodoList pour ajouter ces nouvelles tâches à la Collection
/!\Donner une date de fin à une tache initialise une TacheLongCours, sinon, Ponctuelle
*/
public class CreerTache extends JFrame
{
	protected JPanel p;
	protected JLabel l1,l2,l3,l4,lsupp;
	protected JCheckBox chk;
	protected JButton b1;
	protected JTextField t1,t2,t3,t4;
	protected ArrayList<Tache> t;

	public CreerTache()
	{
		t = new ArrayList<Tache>();
		setTitle("jCreerTache");
		JPanel p = new JPanel();
		add(p);
		p.setPreferredSize(new Dimension(350,200));
		p.setLayout(new FlowLayout());

		l1 = new JLabel("Titre : ");
		t1 = new JTextField(20);
		p.add(l1);
		p.add(t1);
		l2 = new JLabel("Categorie : ");
		t2 = new JTextField(20);
		p.add(l2);
		p.add(t2);
		l3 = new JLabel("Date début : ");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dateJour = new Date();
		t3 = new JTextField(formatter.format(dateJour),20);
		p.add(l3);
		p.add(t3);
		l4 = new JLabel("Date fin : ");
		t4 = new JTextField("dd/mm/yyyy",20);
		p.add(l4);
		p.add(t4);

		lsupp = new JLabel("Tache au long cours ? : ");
		chk=new JCheckBox();
		p.add(lsupp);
		p.add(chk);

		b1 = new JButton("Add");
		b1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				//TESTS
				boolean verify=true;

				String titr=t1.getText();
				if(titr.equals("")){
					titr="Sans_Titre";
				}
				String oneWordCat=t2.getText();
				if(!oneWordCat.matches("^\\S*$") || oneWordCat.equals("")){
					oneWordCat="Sans_Categorie";
				}
				//match : dd/mm/yyyy
				String regex_date="^(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)\\d\\d$";
				String dd=t3.getText();
				String df=t4.getText();
				if(!test_date(dd)){
					verify=false;
				}
				if(!test_date(df)){
					verify=false;
				}
				if(!test_dates_valides()){
					verify=false;
				}
				//Ssi les champs date sont valides
				if(verify){
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					if(!chk.isSelected()){
						t.add(new TachePonctuelle(fetch_deb(), fetch_fin(), titr, oneWordCat));
					}
					else{
						t.add(new TacheLongCours(fetch_deb(), fetch_fin(), titr, oneWordCat));
					}
					t1.setText("");
					t2.setText("");
					t3.setText(formatter.format(dateJour));
					t4.setText("dd/mm/yyyy");
				}
				else{
					t3.setText("dd/mm/yyyy");
					t4.setText("dd/mm/yyyy");
				}
			}
		});
		p.add(b1);

		pack();
	}

	public boolean isThere(){
		return t.size()>0;
	}

	public boolean test_date(String date){
		//match : dd/mm/yyyy
		String regex_date="^(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)\\d\\d$";
		return date.matches(regex_date);
	}

	public boolean test_dates_valides(){
		Date dd, df;
		dd=fetch_deb();
		df=fetch_fin();

		return dd.before(df);
	}

	public Date fetch_deb(){
		String dd_valide=t3.getText();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
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

	public ArrayList<Tache> fetch(){
		return t;
	}
}
