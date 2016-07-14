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
import javax.swing.GroupLayout;

public class DBHomePage extends JPanel implements DBPage{
	//**** FIELDS ****
	static final long serialVersionUID = 1L;
	Color myColor = Color.black;
	User currentUser = null;

	/**
	  * Default No args constructor.
	  */
	public DBHomePage(){
		setupPage();
	}

	public void setUser(User u){
		currentUser = u;
	}

	//**** METHODS ****
	/**
	  * Initializes this DBPage.
	  */
	public void setupPage(){
		this.setBackground(myColor);
		this.setVisible(true);
	}

	/**
	  * Updates this DBPage. This should happen every time the page is switched to.
	  */
	public void updatePage(){
		System.out.println(currentUser);
		//Format THIS page.
		this.setLayout(new BorderLayout());
		//create left side components
		
		//make left side page
		JPanel leftside = new JPanel();
		GroupLayout lsLayout = new GroupLayout(leftside);
		leftside.setLayout(lsLayout);
		leftside.setBackground(myColor);
		//create right side components
		
		//make right side page
		JPanel rightside = new JPanel();
		GroupLayout rsLayout = new GroupLayout(rightside);
		rightside.setLayout(rsLayout);
		rightside.setBackground(myColor);
		//put together.
		this.add(leftside, BorderLayout.PAGE_START);
		this.add(rightside,BorderLayout.CENTER);
	}
}