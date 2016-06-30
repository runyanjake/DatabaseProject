/**
  * DataBaseProject.java 
  * @Author Jake Runyan
  * @Project DataBaseProject
  * @About Main Class.
  * @Version Last Updated: June 12 2016
  *
  */

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class DatabaseProject{

  DBWindow frame;

  public static void main(String[] args){
    DatabaseProject dbp = new DatabaseProject();
  }

  public DatabaseProject(){
    initializeDB();
  }

  public void initializeDB(){
    frame = new DBWindow("DataBaseProject");
    frame.addWindowListener(new DBWindowListener());
    frame.setBounds(0,0, 400, 300);
    frame.setVisible(true);
  }

  public class DBWindowListener implements WindowListener{
    public void windowClosing(WindowEvent e){
      int a = JOptionPane.showConfirmDialog(frame, "Are you sure you would like to exit?", "Goodbye!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
      if(a==1){
        initializeDB();
      }else{
        System.exit(0);
      }
    }
    public void windowDeactivated(WindowEvent e){}
    public void windowOpened(WindowEvent e){}
    public void windowClosed(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowActivated(WindowEvent e){}
    
  }

}