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

public class DBSignupPage extends JPanel implements DBPage{

	//**** FIELDS ****
	static final long serialVersionUID = 1L;
	JButton signupButton;
	Color myColor = Color.GREEN;
	JTextField user,pass,vpass,name,bio;

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
		this.setBackground(myColor);
		this.setLayout(new BorderLayout());
		//Format page
		JPanel inner = new JPanel(new BorderLayout());
		inner.setBackground(myColor);
		//set up button (right side inner page)
		signupButton = new JButton("Sign Up");
		signupButton.addActionListener(new signupButtonListener());
		inner.add(signupButton,BorderLayout.PAGE_END);
		//set up fields (left/middle inner page)
		JPanel fields = new JPanel();
		GroupLayout layout = new GroupLayout(fields);
		fields.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		fields.setBackground(myColor);
		name = new JTextField("Name", 1);
		user = new JTextField("Username", 1);
		pass = new JTextField("Password", 1);
		vpass = new JTextField("Verify Password", 1);
		bio = new JTextField("Bio", 1);
		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addComponent(name)
				.addComponent(user)
				.addComponent(pass)
				.addComponent(vpass)
				.addComponent(bio));
		layout.setHorizontalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(name)
				.addComponent(user)
				.addComponent(pass)
				.addComponent(vpass)
				.addComponent(bio));
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

	}

	/**
	  * Actionlistener for Button
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
				//create new user account, modify the user/pass file, and generate a new user file.
				fc.addCredentials(user.getText(), pass.getText());
				frame.attemptNextPage("title");
			}
		}
	}

}