package todoList;

import java.awt.*;
import javax.swing.*;

public class Main
{
  public static void main(String[] args) throws java.io.IOException
  {
  	TodoList f=new TodoList();
  	f.setVisible(true);
  	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	/*TODO:
    HANDLE LE ON_CLOSE

		Gérer les boutons :
		Maj_Task
			-Rendre clickable les JLabel, onClick() ouvrir une fenetre,
			-X JTextfields, X JLabels, JButton 'Send'
		Archieve_Task
			-Rendre clickable les JLabel, onClick() ouvrir une fenetre,
			-JLabel("Etes vous sur de vouloir archiver cette tache"), JButton 'Send'
		Archieved_Tasks
			-Ouvre une fenetre déroulante de JLabel rempli des tache_archivee.txt
	*/
  }
}
