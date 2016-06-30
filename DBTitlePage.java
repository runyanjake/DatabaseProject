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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DBTitlePage extends JPanel implements DBPage{
	//**** FIELDS ****
	static final long serialVersionUID = 1L;
	JButton beginButton;

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
		this.setBackground(Color.cyan);
		this.setLayout(new BorderLayout());
		//set up button
		beginButton = new JButton();
		beginButton.addActionListener(new startButtonListener());
		this.add(beginButton, BorderLayout.CENTER);
		//make visible
		this.setVisible(true);
	}

	/**
	  * Updates this DBPage.
	  */
	public void updatePage(){

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