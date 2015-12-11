package todoList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;

/*
ArchiverTache permet la suppression d'une tâche après confirmation du client
Au clic on retire la tache de notre collection et on crée/append taches_archivees
*/
public class ArchiverTache extends JFrame
{
	protected JPanel p;
	protected JLabel l1;
  protected JButton b1;

	public ArchiverTache(CollectionTache c, int i)
	{
		setTitle("jArchiverTache");
		p = new JPanel();
		add(p);
		p.setPreferredSize(new Dimension(350,200));
		p.setLayout(new FlowLayout());

		l1 = new JLabel("Etes vous sur de vouloir archiver cette tâche ?");
		p.add(l1);
		b1 = new JButton("Confirmer");
		b1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
					c.archiver_Tache(i);
					dispose();
			}
		});
		p.add(b1);

		pack();
	}
	public ArchiverTache(){
		setTitle("jArchiverTache");
		p = new JPanel();
		add(p);
		p.setPreferredSize(new Dimension(350,200));
		p.setBackground(Color.red);
		p.setLayout(new FlowLayout());

		l1 = new JLabel("Selectionnez une tache à archiver");
		p.add(l1);

		pack();
	}
	
}
