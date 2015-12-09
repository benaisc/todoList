package todoList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;
import java.util.Date;
import java.text.SimpleDateFormat;

/*Modifier_Task
	-Ouvrir une fenetre contenant X JTextFields et 1 JButton 'Send'
	-Return une liste de taches des JTextFields sendés successifs*/

public class ModifTache extends JFrame
{
	protected JPanel p;
	protected JLabel l1,l2,l3,l4;
	protected JTextField t1,t2,t3,t4;
	protected JButton b1;
	//protected Tache t; //VALEUR A RECUP AU Send
	protected int k; //utilisé pour repérer une tache

	public ModifTache(CollectionTache c, int i)
	{
		setTitle("jModifTache");
		p = new JPanel();
		add(p);
		p.setPreferredSize(new Dimension(350,200));
		//p.setBackground(Color.red);
		p.setLayout(new FlowLayout());

		l1 = new JLabel("Titre : ");
		t1 = new JTextField(c.getTitre(i),20);
		p.add(l1);
		p.add(t1);
		l2 = new JLabel("Categorie : ");
		t2 = new JTextField(c.getCategorie(i),20);
		p.add(l2);
		p.add(t2);
		l3 = new JLabel("Date début : ");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		t3 = new JTextField(formatter.format(c.getDebut(i)),20);
		p.add(l3);
		p.add(t3);

		if(c.getTache(i) instanceof TacheLongCours){
			l4 = new JLabel("Date fin : ");
			t4 = new JTextField(formatter.format(c.getEcheance(i)),20);
			p.add(l4);
			p.add(t4);
		}
		b1 = new JButton("Send");
		b1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				System.out.println("Souris cliquée en Send");
			}
		});
		p.add(b1);

		pack();
	}
	public ModifTache(){
		setTitle("jModifTache");
		p = new JPanel();
		add(p);
		p.setPreferredSize(new Dimension(350,200));
		p.setBackground(Color.red);
		p.setLayout(new FlowLayout());

		l1 = new JLabel("Selectionnez une tache");
		p.add(l1);

		pack();
	}

	/*private void jList1ValueChanged(ListSelectionEvent evt, CollectionTache collec){
		String s = (String) list1.getSelectedValue();
		System.out.println("Vous avez séléctionner : "+s);
		for(int i=0; i<collec.nbTaches(); ++i){
			if(s.equals(collec.getTache(i).get_titre())){
				k=i;
				i=collec.nbTaches();
			}
		}
		p2.removeAll();

		JTextField t1,t2,t3,t4;
		t1 = new JTextField(collec.getTitre(k),20);//titre
		p2.add(t1);

		t2 = new JTextField(collec.getCategorie(k),20);//Categorie
		p2.add(t2);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		t3 = new JTextField(formatter.format(collec.getDebut(k)),20);//date deb
		p2.add(t3);

		t4 = new JTextField(formatter.format(collec.getEcheance(k)),20);//Date fin
		p2.add(t4);

		pack();
	}*/
}
