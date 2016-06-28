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
  DBPage title;
  DBPage login;
  DBPage home;
  JPanel window;
  static final String TITLE = "title";
  static final String LOGIN = "login";
  static final String HOME = "home";

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
    window.add((JPanel)title, TITLE);
    window.add((JPanel)login, LOGIN);
    window.add((JPanel)home, HOME);
  }

  /**
    * Updates all potions of the GUI.
    */
  public void updateGUI(){
    title.updatePage();
    login.updatePage();
    home.updatePage();
  }

  /**
    * Progresses one card forward. Calls helper methods that verify accessability.
    * @param target The target card to flip to. By default this should be the "next" card.
    */
  public void attemptNextPage(String target){
    //Determine what to do based on the next card.

    //ON TITLE PAGE, ATTEMPTING LOGIN
      if(target.equals(LOGIN)){ //if using login.
        ((CardLayout)window.getLayout()).show(window, target); //(LOGIN)
      }else{ //if using signup feature (change to else if)
        //TODO
      }

    //ON LOGIN PAGE, ATTEMPTING HOME
      //TODO: write validation method, can possibly throw different errors.
      if(target.equals(HOME) && true){ //AND if validated
        ((CardLayout)window.getLayout()).show(window, target); //(HOME)
      }else if(target.equals(HOME)){ //not validated
        //JOptionPane some error message and refresh the current window
      }

    //ON HOME PAGE, ATTEMPTION VARIOUS FUNCTIONALITY
      //write if statement for all options.
      if(false){
        ((CardLayout)window.getLayout()).show(window, target);
      }
    
  }

  /**
    *
    */


}