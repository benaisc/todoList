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
				if(!oneWordCat.matches("/^\\S/")){
					oneWordCat="Sans_Categorie";
				}
				//match : dd/mm/yyyy
				String regex_date="^(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)\\d\\d$";
				String dd=t3.getText();
				String df=t4.getText();
				if(!dd.matches(regex_date)){
					verify=false;
				}
				if(!df.matches(regex_date)){
					verify=false;
				}

				//Ssi les champs date sont valides
				if(verify){
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					try{
						if(!chk.isSelected()){
							t.add(new TachePonctuelle(formatter.parse(dd), formatter.parse(df), titr, oneWordCat));
						}
						else{
							t.add(new TacheLongCours(formatter.parse(dd), formatter.parse(df), titr, oneWordCat));
						}
					}catch(ParseException err){
						err.printStackTrace();
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

	public ArrayList<Tache> fetch(){
		return t;
	}
}
