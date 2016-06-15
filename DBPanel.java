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

public class DBPanel extends JPanel{

  	static final long serialVersionUID = 1L; //For Serializability purposes.

	JPanel homePage;
	JPanel loginPage;
	JPanel landingPage;

	public DBPanel(){
		super(new CardLayout());
		this.setBackground(Color.gray);
		init();
	}

	/**
	  * Initializes this DatabaseTester's windows.
	  */
	private void init(){
		
	}

}