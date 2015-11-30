package todoList;

import java.awt.*;
import javax.swing.*;

public class TodoList extends JFrame
{
	protected JPanel pGauche, pDroite;
	protected JButton b1,b2,b3,b4;
	protected JLabel [] texte;

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

		b1 = new JButton("Add Task");
		b2 = new JButton("MaJ Task");
		b3 = new JButton("Archive Task");
		b4 = new JButton("Show Archived Tasks");

		pGauche.add(b1);
		pGauche.add(b2);
		pGauche.add(b3);
		pGauche.add(b4);

		pack();
	}

	public void initTaches(CollectionTache c)
	{
		int nbTaches=c.nbTaches();
		
		pDroite.setLayout(new GridLayout(nbTaches,1));

		texte = new JLabel[nbTaches];

		for (int i=0; i<nbTaches; i++){
			texte[i] = new JLabel(c.getTache(i));
			pDroite.add(texte[i]);
		}

		pack();
	}


}
