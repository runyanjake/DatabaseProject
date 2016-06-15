/**
  * DataBaseProject.java 
  * @Author Jake Runyan
  * @Project DataBaseProject
  * @About Main Class.
  * @Version Last Updated: June 12 2016
  *
  */

public class DatabaseProject{

	public static void main(String[] args){
		DBFrame frame = new DBFrame("DataBaseProject");
    DBPanel window = new DBPanel();
    frame.add(window);
    frame.setBounds(0,0, 250, 250);
    frame.setVisible(true);
	}

}