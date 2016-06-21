/**
  * DBLoginPage.java 
  * @Author Jake Runyan
  * @Project DataBaseProject
  * @About The Panel in which the login page for DataBaseProject runs.
  * @Version Last Updated: June 14 2016
  *
  */

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class DBLoginPage extends JPanel implements DBPage{
	//**** FIELDS ****
	static final long serialVersionUID = 1L;

	/**
	  * Default No args constructor.
	  */
	public DBLoginPage(){
		setupPage();
	}

	//**** METHODS ****
	/**
	  * Initializes this DBPage.
	  */
	public void setupPage(){
		this.setBackground(Color.YELLOW);
		this.setVisible(true);
	}

	/**
	  * Updates this DBPage.
	  */
	public void updatePage(){

	}
}