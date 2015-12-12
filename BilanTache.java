package todoList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class BilanTache extends JFrame
{
	protected JPanel p;
	protected JLabel l;
	private JTable table;
	private JScrollPane scrollpane;

	public BilanTache(CollectionTache c)
	{
		setTitle("jBilanTache");
		p = new JPanel();
		add(p);
		p.setPreferredSize(new Dimension(650,200));
		p.setLayout(new GridLayout());

		if(c.nbArchive()>0)
			init_taches_bilan(c);
		else{
			l=new JLabel("Aucune tâche archivée !");
			p.add(l);
		}

		pack();
	}

	public void init_taches_bilan(CollectionTache archive){
		int nbTaches=archive.nbTaches();
		table=new JTable(new DefaultTableModel(nbTaches, 1){
			public boolean isCellEditable(int row, int column){return false;}
		});
		scrollpane=new JScrollPane(table);
		for(int i=0; i<nbTaches; i++){
			table.setValueAt(archive.getArchive(i),i,0);
		}
		table.setFocusable(false);
		table.setRowHeight(20);
		table.setRowSelectionAllowed(true);
		p.add(scrollpane);
	}
}
