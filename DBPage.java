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
  Color myPrimaryColor = Color.gray;
  Color mySecondaryColor = Color.white;

	//**** METHODS ****
	public void setupPage();
	public void updatePage();
  public void resetPage();
}