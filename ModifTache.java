package todoList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.lang.String;
import java.util.Date;
import java.text.SimpleDateFormat;

/*Modifier_Task
	-Ouvrir une fenetre contenant X JTextFields et 1 JButton 'Send'
	-Return une liste de taches des JTextFields sendés successifs*/

public class ModifTache extends JFrame
{
	protected JPanel p1,p2;
	protected JLabel l1;
	protected JList list1;
	protected JButton b1;
	//protected Tache t; //VALEUR A RECUP AU Send
	protected int k; //utilisé pour repérer une tache

	public ModifTache(CollectionTache c)
	{
		setTitle("jModifTache");
		JPanel p1 = new JPanel();
		add(p1,"West");
		p1.setPreferredSize(new Dimension(275,200));
		p1.setBackground(Color.red);
		p1.setLayout(new FlowLayout());

		JPanel p2 = new JPanel();
		add(p2);
		p2.setPreferredSize(new Dimension(350,200));
		p2.setBackground(Color.blue);
		p2.setLayout(new FlowLayout());		

		l1 = new JLabel("Séléctionnez la tâche à modifier :");
		
		p1.add(l1);
		
		list1 = new JList();
		
		list1.setModel(new AbstractListModel(){
		    public int getSize() {
		        return c.nbTaches();
		    }
		    public Object getElementAt(int i) {
		        return c.getTitre(i);
		    }
		});

		list1.addListSelectionListener(new ListSelectionListener(){
            		public void valueChanged(ListSelectionEvent evt){
                		jList1ValueChanged(evt,c);
            		}
        	});

		p1.add(list1);

		b1 = new JButton("Send");
		b1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				System.out.println("Souris cliquée en Send");
			}
		});
		p1.add(b1);

		pack();
	}

	private void jList1ValueChanged(ListSelectionEvent evt, CollectionTache collec){
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
   	}
}
