package todoList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;
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
	protected JLabel l1,l2,l3,l4,lsupp;
	protected JTextField t1,t2,t3,t4;
	protected JCheckBox chk;
	protected boolean type_tache;

	public ModifTache(CollectionTache c, int i)
	{
		setTitle("jModifTache");
		p = new JPanel();
		add(p);
		p.setPreferredSize(new Dimension(350,200));
		p.setLayout(new FlowLayout());

		l1 = new JLabel("Titre : ");
		t1 = new JTextField(c.getTitre(i),20);
		p.add(l1);
		p.add(t1);
		l2 = new JLabel("Categorie : ");
		t2 = new JTextField(c.getCategorie(i),20);
		p.add(l2);
		p.add(t2);

		lsupp = new JLabel("Modifier la catégorie des autres taches ?");
		chk = new JCheckBox();
		p.add(lsupp);
		p.add(chk);

		l3 = new JLabel("Date début : ");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		t3 = new JTextField(formatter.format(c.getDebut(i)),20);
		p.add(l3);
		p.add(t3);

		l4 = new JLabel("Date fin : ");
		t4 = new JTextField(formatter.format(c.getEcheance(i)),20);
		p.add(l4);
		p.add(t4);

		if(c.getTache(i) instanceof TacheLongCours){
			//TODO: avancement
			type_tache=true;
		}
		else{type_tache=false;}

		pack();
	}

	public ModifTache(){
		setTitle("jModifTache");
		p = new JPanel();
		add(p);
		p.setPreferredSize(new Dimension(350,200));
		p.setBackground(Color.red);
		p.setLayout(new FlowLayout());

		l1 = new JLabel("Selectionnez une tache à modifier");
		p.add(l1);

		pack();
	}

	public Tache fetch(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try{
			if(type_tache)
				return new TacheLongCours(formatter.parse(t3.getText()),formatter.parse(t4.getText()),t1.getText(),t2.getText());
			else
				return new TachePonctuelle(formatter.parse(t3.getText()),formatter.parse(t4.getText()),t1.getText(),t2.getText());
		}catch(ParseException err){
			err.printStackTrace();
			return new TachePonctuelle();
		}
	}

	public String fetch_cat(){
		return t2.getText();
	}

	public boolean checkbox(){
		return chk.isSelected();
	}
}
