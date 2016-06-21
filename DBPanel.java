/**
  * DBPanel.java 
  * @Author Jake Runyan
  * @Project DataBaseProject
  * @About The Panel in which the GUI for DataBaseProject runs.
  * @Version Last Updated: June 12 2016
  *
  */

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;

public class DBPanel extends JPanel{

  	static final long serialVersionUID = 1L; //For Serializability purposes.

	DBPage title;
	DBPage login;
	DBPage home;

	public DBPanel(){
		super(new CardLayout());
		this.setBackground(Color.gray);
		init();
	}

	/**
	  * Initializes this DatabaseTester's windows.
	  */
	private void init(){
		title = new DBTitlePage();
		login = new DBLoginPage();
		home = new DBHomePage();
	}

	/**
	  * Updates all potions of the GUI.
	  */
	public void updateGUI(){
		title.updatePage();
		login.updatePage();
		home.updatePage();
	}

	/**
	  * Progresses one card forward.
	  */
	public void nextPage(){

	}

}