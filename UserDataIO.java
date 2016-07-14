/**
  * UserData.java 
  * @Author Jake Runyan
  * @Project DataBaseProject
  * @About Handles processes associated with the storing of user data..
  * @Version Last Updated: July 9 2016
  *
  */

import java.io.File;

public class UserDataIO{

	public UserDataIO(){

	}

	/**
	  * 
	  * Generates a new template file for the user.
	  * @param name The name of the user
	  * @param user The user's username.
	  * @param pass The user's password.
	  * @param bio The user's bio.
	  */
	public void generateNewUserData(String name, String user, String pass, String bio){
		String fileContents = name + "~" + user + "~" + pass + "~" + bio + "~";
		String curFolder = System.getProperty("user.dir");
		File userFile = new File(curFolder + File.separator + "users" + File.separator + user + ".dtbf");
		FileIO.overWrite(fileContents, userFile);
	}

	/**
	  * Adds a database to a specific user.
	  * @param databaseFileName The database to be added.
	  * @param user The user who is getting the database added.
	  */
	public void addDatabase(String databaseFileName, String user){
		String curFolder = System.getProperty("user.dir");
		FileIO.addToFile(databaseFileName + ".dtbf~", new File(curFolder + File.separator + "users" + File.separator + user + ".dtbf"));
	}

	/**
	  * IF I CREATE LIKE A USER.JAVA file it'll return that.
	  */
	public void loadUser(String user){

	}

}