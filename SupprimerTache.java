package todoList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;

/*
SupprimerTache permet la suppression d'une tâche après demande et confirmation du client
Au clic on retire la tache de notre collection et on crée/append taches_archivees
*/
public class SupprimerTache extends JFrame
{
	protected JPanel p;
	protected JLabel l1;
  protected JButton b1;

	public SupprimerTache(CollectionTache c, int i)
	{
		setTitle("jSupprimerTache");
		p = new JPanel();
		add(p);
		p.setPreferredSize(new Dimension(350,100));
		p.setLayout(new FlowLayout());

		l1 = new JLabel("Etes vous sur de vouloir supprimer cette tâche ?");
		p.add(l1);
		b1 = new JButton("Confirmer");
		b1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
					c.retrait(i);
					dispose();
			}
		});
		p.add(b1);

		pack();
	}
	public SupprimerTache(){
		setTitle("jSupprimerTache");
		p = new JPanel();
		add(p);
		p.setPreferredSize(new Dimension(300,100));
		p.setBackground(Color.red);
		p.setLayout(new FlowLayout());

		l1 = new JLabel("Selectionnez une tache à supprimer");
		p.add(l1);

		pack();
	}

}
