/**
  * DBTitlePage.java 
  * @Author Jake Runyan
  * @Project DataBaseProject
  * @About The Panel in which the title page for DataBaseProject runs.
  * @Version Last Updated: June 14 2016
  *
  */

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DBTitlePage extends JPanel implements DBPage{
	//**** FIELDS ****
	static final long serialVersionUID = 1L;
	JButton beginButton;
	Color myPrimaryColor = new Color(255,0,0);
	Color mySecondaryColor = new Color(255,50,50);

	/**
	  * Default No args constructor.
	  */
	public DBTitlePage(){
		setupPage();
	}

	//**** METHODS ****
	/**
	  * Initializes this DBPage.
	  */
	public void setupPage(){
		//set up page.
		this.setBackground(myPrimaryColor);
		this.setLayout(new BorderLayout());
		//Format page
		JPanel inner = new JPanel(new BorderLayout());
		inner.setBackground(myPrimaryColor);
		//set up button
		beginButton = new JButton("Begin!");
		beginButton.addActionListener(new startButtonListener());
		inner.add(beginButton,BorderLayout.PAGE_END);
		//put it all together
		this.add(inner, BorderLayout.LINE_END);
		//make visible
		this.setVisible(true);
	}

	/**
	  * Updates this DBPage.
	  */
	public void updatePage(){
		//nothing
	}

	/**
	  * Resets this page.
	  */
	public void resetPage(){
		//nothing
	}

	/**
	  * Actionlistener for Button
	  */
	public class startButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			DBWindow frame = (DBWindow)SwingUtilities.getRoot(beginButton);
			frame.attemptNextPage("login");
		}
	}

}