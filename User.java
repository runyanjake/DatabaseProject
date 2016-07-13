/**
  * User.java 
  * @Author Jake Runyan
  * @Project DataBaseProject
  * @About Represents a user.
  * @Version Last Updated: July 11 2016
  *
  */

import java.util.ArrayList;
import java.io.File;

public class User{

	//**** FIELDS ****
	public String name, username, password, bio;
	ArrayList<String> ownedDTBs;
	int numOwnedDTBs;

	//**** CONSTRUCTORS ****
	/**
	  * Creates a new user from a given file.
	  * @param filename The user's username that should be the name of a file.
	  * @pre filename should correspond to a file. (FileCredentials.fileExists() is true).
	  */
	public User(String filename){
		setupUser(filename);
	}

	public void setupUser(String filename){
		FileCredentials fc = new FileCredentials();
		String curFolder = System.getProperty("user.dir");
		File userFile = new File(curFolder + File.separator + "users" + File.separator + filename + ".dtbf");
		String[] fileContents = FileIO.read(userFile).split("~");
		name = fileContents[0];
		username = fileContents[1];
		password = fileContents[2];
		bio = fileContents[3];
		numOwnedDTBs = fileContents.length - 4;
		//add the filenames into the owned list
		ownedDTBs = new ArrayList<String>();
		for(int a = 0; a < numOwnedDTBs; a++){
			ownedDTBs.add(fileContents[a+4]);
		}
		System.out.println(this);
	}

	//**** METHODS ****
	public String toString(){
		String txt = "Name: "+name+"\nUsername: "+username+"\nPassword: "+password+"\nBio: "+bio+"\nDatabases:\n";
		for(int a = 0; a < numOwnedDTBs; a++){
			txt = txt + "\t" + ownedDTBs.get(a) + "\n";
		}
		return txt;
	}

}