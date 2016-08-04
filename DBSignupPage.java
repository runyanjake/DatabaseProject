/**
  * DBSignupPage.java 
  * @Author Jake Runyan
  * @Project DataBaseProject
  * @About The signup page.
  * @Version Last Updated: July 6 2016
  *
  */

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

public class DBSignupPage extends JPanel implements DBPage{

	//**** FIELDS ****
	static final long serialVersionUID = 1L;
	JButton signupButton,backButton;
	Color myPrimaryColor = new Color(0,255,0);
	Color mySecondaryColor = new Color(50,255,50);
	JTextField user,pass,vpass,name,bio;
	JLabel juser,jpass,jvpass,jname,jbio;
	/**
	  * Default No args constructor.
	  */
	public DBSignupPage(){
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
		//set up navigation buttons (right side inner page)
		signupButton = new JButton("Sign Up");
		signupButton.addActionListener(new signupButtonListener());
		backButton = new JButton("Go Back");
		backButton.addActionListener(new backButtonListener());
		JPanel navButtons = new JPanel();
		navButtons.setBackground(myPrimaryColor);
		GroupLayout nblayout = new GroupLayout(navButtons);
		navButtons.setLayout(nblayout);
		nblayout.setVerticalGroup(
			nblayout.createSequentialGroup()
				.addComponent(backButton)
				.addComponent(signupButton));
		nblayout.setHorizontalGroup(
			nblayout.createSequentialGroup()
				.addGroup(
						nblayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addComponent(backButton)
							.addComponent(signupButton)));
		inner.add(navButtons,BorderLayout.EAST);
		//set up fields (left/middle inner page)
		JPanel fields = new JPanel();
		GroupLayout layout = new GroupLayout(fields);
		fields.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		fields.setBackground(myPrimaryColor);
		name = new JTextField("John Doe", 1);
		user = new JTextField("johndoe35", 1);
		pass = new JTextField("password123", 1);
		vpass = new JTextField("password123", 1);
		bio = new JTextField("Hey, It's John Doe!", 1);
		jname = new JLabel("Name");
		juser = new JLabel("Username");
		jpass = new JLabel("Password");
		jvpass = new JLabel("Verify Password");
		jbio = new JLabel("A Short Bio");
		
		//set layout for all the input buttons and labels
		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(jname)
					.addComponent(name))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(juser)
					.addComponent(user))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(jpass)
					.addComponent(pass))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(jvpass)
					.addComponent(vpass))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(jbio)
					.addComponent(bio)));
		layout.setHorizontalGroup(
			layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					.addComponent(jname)
					.addComponent(juser)
					.addComponent(jpass)
					.addComponent(jvpass)
					.addComponent(jbio))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(name)
					.addComponent(user)
					.addComponent(pass)
					.addComponent(vpass)
					.addComponent(bio))
				);
		
		//put it all together
		this.add(inner, BorderLayout.LINE_END);
		this.add(fields, BorderLayout.CENTER);
		//make visible
		this.setVisible(true);
	}

	/**
	  * Updates this DBPage.
	  */
	public void updatePage(){
		resetPage();
	}

	/**
	  * Resets this page.
	  */
	public void resetPage(){
		name.setText("John Doe");
		user.setText("johndoe35");
		pass.setText("password123");
		vpass.setText("password123");
		bio.setText("Hey, It's John Doe!");
	}

	/**
	  * Actionlistener for signupButton
	  */
	public class signupButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			FileCredentials fc = new FileCredentials();
			DBWindow frame= (DBWindow)SwingUtilities.getRoot(signupButton);
			if(fc.userExists(user.getText())){
				JOptionPane.showConfirmDialog(frame, "Sorry, that username is already taken.\nPlease choose another.", "Username error!", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
			}else if(!(pass.getText().equals(vpass.getText()))){
				JOptionPane.showConfirmDialog(frame, "Passwords do not match.\nPlease re-enter.", "Password error!", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
			}else{ //nothing was wrong
				System.out.println("New User:\n\tName: " + name.getText() + "\n\tUsername: " + user.getText() + "\n\tPassword: " + pass.getText() + "\n\tBio: " + bio.getText());
				UserDataIO usr = new UserDataIO();
				usr.generateNewUserData(name.getText(),user.getText(),pass.getText(),bio.getText());
				fc.addCredentials(user.getText(), pass.getText());
				frame.attemptNextPage("title");
			}
		}
	}

	/**
	  * Actionlistener for backButton
	  */
	public class backButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			DBWindow frame= (DBWindow)SwingUtilities.getRoot(signupButton);
			frame.attemptNextPage("login");
		}
	}

}