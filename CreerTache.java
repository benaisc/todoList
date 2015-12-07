package todoList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
/*Add_Task
	-Ouvre une fenetre contenant des JTextFields et 1 JButton 'Send'
	-Return une liste de taches des JTextFields sendés successifs*/
public class CreerTache extends JFrame
{
	protected JPanel p;
	protected JLabel l1,l2,l3,l4;
	protected JButton b1;
	protected JTextField t1,t2,t3,t4;
	protected ArrayList<Tache> t; //VALEUR A RECUP AU Send

	public CreerTache()
	{
		t = new ArrayList<Tache>();
		setTitle("jCreerTache");
		JPanel p = new JPanel();
		add(p);
		p.setPreferredSize(new Dimension(350,200));
		//p.setBackground(Color.black);
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

		b1 = new JButton("Add");
		b1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				t.add(new TachePonctuelle(t3.getText(),t4.getText(),t1.getText(),t2.getText()));
				t1.setText("");
				t2.setText("");
				t3.setText(formatter.format(dateJour));
				t4.setText("dd/mm/yyyy");
			}
		});
		p.add(b1);

		pack();
	}
	public ArrayList<Tache> fetch(){
		return t;
	}

}
