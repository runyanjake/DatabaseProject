/**
  * DBLoginPage.java 
  * @Author Jake Runyan
  * @Project DataBaseProject
  * @About The Panel in which the login page for DataBaseProject runs.
  * @Version Last Updated: June 14 2016
  *
  */

import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import java.awt.Color;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;


public class DBLoginPage extends JPanel implements DBPage{
	//**** FIELDS ****
	static final long serialVersionUID = 1L;
	Color myColor = Color.yellow;
	JButton loginButton, signupButton;
	JTextField user, pass;

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
		//set up page.
		this.setBackground(myColor);
		this.setLayout(new BorderLayout());
		//Format page
		JPanel inner = new JPanel();
		GroupLayout layout = new GroupLayout(inner);
		inner.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		inner.setBackground(myColor);
		//set up text field.
		user = new JTextField("Username", 23);
		pass = new JTextField("Password", 1);
		//set up butttons
		loginButton = new JButton("Log In");
		loginButton.addActionListener(new loginButtonListener());
		signupButton = new JButton("Sign Up");
		signupButton.addActionListener(new signupButtonListener());
		//put togetheer using GroupLayout's group setup
		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addComponent(user)
				.addComponent(pass)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(loginButton)
					.addComponent(signupButton)));
		layout.setHorizontalGroup(
			layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(user)
					.addComponent(pass)
					.addComponent(loginButton))
				.addComponent(signupButton));
		this.add(inner);
		//set visible
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
	public class loginButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			DBWindow frame = (DBWindow)SwingUtilities.getRoot(loginButton);
			FileCredentials fc = new FileCredentials();
			if(fc.validateCredentials(user.getText(), pass.getText()) == 1){
				frame.currentUser = user.getText();
				((DBHomePage)(frame.home)).setUser(new User(user.getText()));
				frame.attemptNextPage("home");
			}else if(fc.validateCredentials(user.getText(), pass.getText()) == 0){
				JOptionPane.showConfirmDialog(frame, "Invalid Credentials.\nPlease try again or select 'Sign Up'.", "Error!", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
			}else{
				JOptionPane.showConfirmDialog(frame, "Your user file appears to have been deleted :(\nYou'll have to create a new account.\n Sorry.", "Filesystem Error!", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	  * Actionlistener for Button
	  */
	public class signupButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			DBWindow frame = (DBWindow)SwingUtilities.getRoot(signupButton);
			frame.attemptNextPage("signup");
		}
	}

}