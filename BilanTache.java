package todoList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;

/*
BilanTache permet l'affichage de toutes les tâches d'une période donnée;
2 champs de date sont proposés; Au clic on initialise et on affiche
*/
public class BilanTache extends JFrame
{
	protected JPanel p;
	protected JLabel l1,l2;
	protected JTextField t1,t2;
  protected JButton b1;
	//private JTable table;
	//private JScrollPane scrollpane;

	public BilanTache(CollectionTache c)
	{
		setTitle("jBilanTache");
		p = new JPanel();
		add(p);
		p.setPreferredSize(new Dimension(350,200));
		p.setLayout(new FlowLayout());

		l1 = new JLabel("Date début : ");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dateJ=new Date();
		t1 = new JTextField(formatter.format(dateJ),20);
		p.add(l1);
		p.add(t1);

		l2 = new JLabel("Date fin : ");
		t2 = new JTextField(formatter.format(dateJ),20);
		p.add(l2);
		p.add(t2);

		b1 = new JButton("Charger");
		b1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(isThere()){
					System.out.println("Méthode Bilan non-implémentée");
					/*TODO:
					init_taches_bilan(c)
						Charger taches_archivees dans un Array
						Retrait des tâches_archivees qui !(date1<=tache<=date2)
						Ajout des tâches de la collection tq date1<=tache<=date2
						Affichage de tout ça dans JTable
						+ ajout méthode simple calcul taches réalisées à temp, en retard...
					*/
				}
				dispose();
			}
		});
		p.add(b1);

		pack();
	}

	public boolean isThere(){
		return (test_date(t1.getText()) && test_date(t2.getText()));
	}

	public boolean test_date(String date){
		//match : dd/mm/yyyy
		String regex_date="^(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)\\d\\d$";
		return date.matches(regex_date);
	}
}

/*
public void init_taches_bilan(CollectionTache collec){
	int nbTaches=collec.nbTaches();
	if(nbTaches>0){
		table=new JTable(new DefaultTableModel(nbTaches, 1){
			public boolean isCellEditable(int row, int column){return false;}
		}){
			public Component prepareRenderer(TableCellRenderer rend, int row, int col){
				Component compo = super.prepareRenderer(rend,row,col);
				Date dateJour = new Date();
				if(getSelectedRow() == row){
					if(!collec.isLineaire(row)){
						compo.setBackground(Color.red);
					}
				}
				else{
					compo.setBackground(Color.white);
				}
				return compo;
			}
		};
		scrollpane=new JScrollPane(table);
		if(nbTaches>0){
			for(int i=0; i<nbTaches; i++){
				table.setValueAt(collec.getTache(i),i,0);
			}
		}
		table.setFocusable(false);
		table.setRowHeight(20);
		table.setRowSelectionAllowed(true);
		pDroite.add(scrollpane);
	}
	else{
		table=new JTable(nbTaches+1, 1);
		table.setValueAt("Encore aucune tâche !",0,0);
		table.setEnabled(false);
		pDroite.add(table);
	}

	pack();
}
*/
