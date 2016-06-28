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

public class DBWindow extends JFrame{

  static final long serialVersionUID = 1L; //For Serializability purposes.
  DBPage title;
  DBPage login;
  DBPage home;

	public DBWindow(String title){
		  super(title);
      this.init();
	}

  /**
    * Initializes this DatabaseTester's windows.
    */
  private void init(){
    JPanel window = new JPanel(new CardLayout());
    window.setBackground(Color.gray);
    this.add(window);
    title = new DBTitlePage();
    login = new DBLoginPage();
    home = new DBHomePage();
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
    * Progresses one card forward.
    */
  public void nextPage(){

  }

}