/**
  * DBFrame.java 
  * @Author Jake Runyan
  * @Project DataBaseProject
  * @About The Frame window for the DataBaseProject.
  * @Version Last Updated: June 12 2016
  *
  */

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

public class DBWindow extends JFrame{

  static final long serialVersionUID = 1L; //For Serializability purposes.
  DBPage title, login, home, signup;
  JPanel window;
  static final String TITLE = "title";
  static final String LOGIN = "login";
  static final String HOME = "home";
  static final String SIGNUP = "signup";
  String currentUser = null;

	public DBWindow(String title){
		  super(title);
      this.init();
	}

  /**
    * Initializes this DatabaseTester's windows.
    */
  private void init(){
    //Setup Frame/Panel
    window = new JPanel(new CardLayout());
    window.setBackground(Color.gray);
    this.add(window);
    //Add into CardLayout.
    title = new DBTitlePage();
    login = new DBLoginPage();
    home = new DBHomePage();
    signup = new DBSignupPage();
    window.add((JPanel)title, TITLE);
    window.add((JPanel)login, LOGIN);
    window.add((JPanel)home, HOME);
    window.add((JPanel)signup, SIGNUP);
  }

  /**
    * Updates all potions of the GUI.
    */
  public void updateGUI(){
    title.updatePage();
    login.updatePage();
    home.updatePage();
    signup.updatePage();
  }

  /**
    * Progresses one card forward. Calls helper methods that verify accessability.
    * @param target The target card to flip to. By default this should be the "next" card.
    */
  public void attemptNextPage(String target){
    if(target.equals(LOGIN)){
        ((CardLayout)window.getLayout()).show(window, LOGIN);
        this.setTitle("Log In");
    }else if(target.equals(HOME)){
        ((CardLayout)window.getLayout()).show(window, HOME);
        this.setTitle(currentUser+"'s Homepage");
    }else if(target.equals(SIGNUP)){
        ((CardLayout)window.getLayout()).show(window, SIGNUP);
        this.setTitle("Sign Up");
    }else if(target.equals(TITLE)){
        ((CardLayout)window.getLayout()).show(window, TITLE);
        this.setTitle("Jake's Database Project");
    }
    
  }

  /**
    *
    */


}