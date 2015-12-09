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
    Handle suppression tache

		Gérer les boutons :
		Archieved_Tasks
			-Ouvre une fenetre déroulante rempli des tache_archivee.txt
	*/
  }
}
