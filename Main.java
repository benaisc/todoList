package todoList;

import java.awt.*;
import javax.swing.*;

public class Main
{
  public static void main(String[] args) throws java.io.IOException
  {
	CollectionTache collec=new CollectionTache();


	Tache tlc1=new TacheLongCours("13/12/2015","Projet_Java","Travail");
	collec.ajout(tlc1);



	TodoList f=new TodoList();
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	f.initTaches(collec);
	

	/*TODO:
		Gérer les boutons : 
		Add_Task
			-Ouvrir une fenetre contenant X JTextFields et 1 JButton 'Send' 
		Maj_Task
			-Rendre clickable les JLabel, onClick() ouvrir une fenetre,
			-X JTextfields, X JLabels, JButton 'Send'
		Archieve_Task
			-Rendre clickable les JLabel, onClick() ouvrir une fenetre,
			-JLabel("Etes vous sur de vouloir archiver cette tache"), JButton 'Send'
		Archieved_Tasks
			-Ouvre une fenetre déroulante de JLabel rempli des tache_archivee.txt

		__________________
		________OU________(plus chiant)

		1 bouton : ShowArchievedTasks
		Rendre clickable les JLabels, onCLick() une fenetre proposant les boutons : MaJ, DeL, Archive
	*/
		




	//collec.close_Tache();
    	//collec.close_Categories();
  }
}
