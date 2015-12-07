package todoList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TodoList extends JFrame implements WindowListener
{
	protected JPanel pGauche, pDroite;
	protected JButton b1,b2,b3,b4;
	protected JTable table;
	protected JScrollPane scrollpane;
	protected CollectionTache collec;

	public TodoList()
	{
		setTitle("jTodoList");

		pGauche = new JPanel();
		pGauche.setBackground(Color.black);
		add(pGauche,"West");
		pGauche.setPreferredSize(new Dimension(190,300));
		pGauche.setLayout(new FlowLayout());

		pDroite = new JPanel();
		add(pDroite);
		pDroite.setPreferredSize(new Dimension(750,300));
		pDroite.setLayout(new GridLayout());

		collec=new CollectionTache();

		init_taches();
		init_boutons();

		pack();
	}

	public void init_taches(){
		int nbTaches=collec.nbTaches();
		table=new JTable(nbTaches+1,1);
		scrollpane=new JScrollPane(table);
		if(nbTaches>0){
			for(int i=0; i<nbTaches; i++){
				table.setValueAt(collec.getTache(i),i,0);
			}
		}
		else{
			table.setValueAt("Encore aucune tâche !",0,0);
		}
		table.setEnabled(false);//empeche l'interation avec les cellules
		pDroite.add(scrollpane);
		pack();
	}

	public void init_boutons(){
		b1 = new JButton("Add Task");
		b1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				CreerTache a=new CreerTache();
				a.addWindowListener(new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						collec.ajout(a.fetch());
						pDroite.removeAll();
						init_taches();
						a.dispose();
					}
				});
				a.setVisible(true);
			}
		});
		b2 = new JButton("MaJ Task");
		b2.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				ModifTache a=new ModifTache(collec);
				a.setVisible(true);
			}
		});
		b3 = new JButton("Archive Task");
		b3.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				System.out.println("Souris cliquée en Archive Task");
			}
		});
		b4 = new JButton("Show Archived Tasks");
		b4.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				System.out.println("Souris cliquée en Show Archived Tasks");
			}
		});

		pGauche.add(b1);
		pGauche.add(b2);
		pGauche.add(b3);
		pGauche.add(b4);
		pack();
	}

	public void windowClosing(WindowEvent e) {
	}
	public void windowClosed(WindowEvent e) {
	}
	public void windowOpened(WindowEvent e) {
	}
	public void windowIconified(WindowEvent e) {
	}
	public void windowDeiconified(WindowEvent e) {
	}
	public void windowActivated(WindowEvent e) {
	}
	public void windowDeactivated(WindowEvent e) {
	}
	public void windowGainedFocus(WindowEvent e) {
	}
	public void windowLostFocus(WindowEvent e) {
	}
	public void windowStateChanged(WindowEvent e) {
	}
}
