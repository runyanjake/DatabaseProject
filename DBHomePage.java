/**
  * DBHomePage.java 
  * @Author Jake Runyan
  * @Project DataBaseProject
  * @About The Panel in which the home page for DataBaseProject runs.
  * @Version Last Updated: June 14 2016
  *
  */

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class DBHomePage extends JPanel implements DBPage{
	//**** FIELDS ****
	static final long serialVersionUID = 1L;


	//**** METHODS ****
	/**
	  * Initializes this DBPage.
	  */
	public void setupPage(){
		this.setBackground(Color.BLACK);
		this.setVisible(true);
	}

	/**
	  * Updates this DBPage.
	  */
	public void updatePage(){

	}
}