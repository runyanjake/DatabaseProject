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
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DBHomePage extends JPanel implements DBPage{
	//**** FIELDS ****
	static final long serialVersionUID = 1L;
	Color myColor = Color.green;
	User currentUser = null;
	JLabel name,bio,ownedDatabases;
	JButton logoutButton,makeButton,editButton;
	JScrollPane scroll;
	JList<String> databases;

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

		//Format THIS page.
		this.setLayout(new BorderLayout());

		//create left side components
		if(currentUser == null){
			name = new JLabel(null + "'s Home");
			bio = new JLabel("<NO BIO FOUND>");
		}else{
			name = new JLabel(currentUser.name + "'s Home");
			bio = new JLabel(currentUser.bio);
		}
		
		logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new logoutButtonListener());
		
		//make left side page
		JPanel leftside = new JPanel();
		GroupLayout lsLayout = new GroupLayout(leftside);
		leftside.setLayout(lsLayout);
		leftside.setBackground(myColor);
		lsLayout.setVerticalGroup(lsLayout.createSequentialGroup().addComponent(name).addComponent(bio).addComponent(logoutButton));
		lsLayout.setHorizontalGroup(lsLayout.createSequentialGroup().addGroup(lsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(name)
					.addComponent(bio)
					.addComponent(logoutButton)));

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

	/**
	  * Updates this DBPage. This should happen every time the page is switched to.
	  */
	public void updatePage(){
		System.out.println("Opening:\n" + currentUser);
		if(currentUser == null){
			name.setText(null + "'s Home");
			bio.setText("<NO BIO FOUND>");
		}else{
			name.setText(currentUser.name + "'s Home");
			bio.setText(currentUser.bio);
		}
	}

	/**
	  * Resets this page.
	  */
	public void resetPage(){
		currentUser = null;
		updatePage();
	}

	/**
	  * Actionlistener for Button
	  */
	public class logoutButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			DBWindow frame = (DBWindow)SwingUtilities.getRoot(logoutButton);
			((DBLoginPage)(frame.login)).updatePage();
			currentUser = null;
			frame.attemptNextPage("login");
		}
	}

}