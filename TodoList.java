package todoList;

import java.awt.*;
import javax.swing.*;

public class TodoList extends JFrame
{
	protected JPanel pGauche, pDroite;
	protected JButton b1,b2,b3,b4;
	protected JTextField texte[];

	public TodoList(int nombreDeTaches)
	{
		setTitle("jTodoList");

		pGauche = new JPanel();
		pGauche.setBackground(Color.black);
		add(pGauche, "West");
		pGauche.setPreferredSize(new Dimension(150,300));

		pDroite = new JPanel();
		add(pDroite);
		pDroite.setPreferredSize(new Dimension(400,300));

		b1 = new JButton("Add Task");
		b2 = new JButton("MaJ Task");
		b3 = new JButton("Archive Task");
		b4 = new JButton("Show Archived Tasks");

		pGauche.setLayout(new FlowLayout());

		pGauche.add(b1);
		pGauche.add(b2);
		pGauche.add(b3);
		pGauche.add(b4);
		
		pDroite.setLayout(new GridLayout(1,nombreDeTaches));
		for (int i = 0; i < nombreDeTaches; i ++){
			texte[i] = new JTextField("",255);
			pDroite.add(texte[i]);
		}


		pack();
	}

}
