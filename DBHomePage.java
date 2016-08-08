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
import javax.swing.JTextArea;
import java.awt.Font;

public class DBHomePage extends JPanel implements DBPage{
	//**** FIELDS ****
	static final long serialVersionUID = 1L;
	Color myPrimaryColor = new Color(0,255,0);
	Color mySecondaryColor = new Color(150,250,150);
	User currentUser = null;
	JLabel name,ownedDatabases;
	JTextArea bio;
	JScrollPane bioscroll;
	JPanel bioscrollpanel;
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
		this.setBackground(myPrimaryColor);
		this.setVisible(true);

		//Format THIS page.
		this.setLayout(new BorderLayout());

		//create left side components
		if(currentUser == null){
			name = new JLabel(null + "'s Home");
			bio = new JTextArea("<NO BIO FOUND>");
		}else{
			name = new JLabel(currentUser.name + "'s Home");
			bio = new JTextArea(currentUser.bio);
		}
		bio.setLineWrap(true);
		bio.setWrapStyleWord(true);
		bio.setEditable(false);

		bioscroll = new JScrollPane(bio);

		bioscrollpanel = new JPanel();
		bioscrollpanel.setLayout(new BorderLayout());
		bioscrollpanel.setBackground(myPrimaryColor);
		bioscrollpanel.add(bioscroll, BorderLayout.CENTER);

		logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new logoutButtonListener());

		bioscroll.setBackground(mySecondaryColor);
		bio.setBackground(mySecondaryColor);
		
		//**** MAKE LEFT SIDE PAGE****
		JPanel leftside = new JPanel();
		GroupLayout lsLayout = new GroupLayout(leftside);
		leftside.setLayout(lsLayout);
		leftside.setBackground(myPrimaryColor);
		lsLayout.setVerticalGroup(lsLayout.createSequentialGroup().addComponent(name).addComponent(bioscrollpanel).addComponent(logoutButton));
		lsLayout.setHorizontalGroup(lsLayout.createSequentialGroup().addGroup(lsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(name)
					.addComponent(bioscrollpanel)
					.addComponent(logoutButton)));

		//create right side components
		
		//**** MAKE RIGHT SIDE PAGE****
		JPanel rightside = new JPanel();
		GroupLayout rsLayout = new GroupLayout(rightside);
		rightside.setLayout(rsLayout);
		rightside.setBackground(myPrimaryColor);
		//put together.
		this.add(leftside, BorderLayout.LINE_START);
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