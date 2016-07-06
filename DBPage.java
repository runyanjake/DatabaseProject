/**
  * DBPage.java 
  * @Author Jake Runyan
  * @Project DataBaseProject
  * @About The interface that determines behavior for all Pages in the DatabaseProject.
  * @Version Last Updated: June 14 2016
  *
  */

import java.awt.Color;

public interface DBPage {
	//**** FIELDS ****
	static final long serialVersionUID = 1L;
  Color myColor = Color.gray;

	//**** METHODS ****
	public void setupPage();
	public void updatePage();
}