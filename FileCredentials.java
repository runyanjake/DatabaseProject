/**
  * FileCredentials.java 
  * @Author Jake Runyan
  * @Project DataBaseProject
  * @About Handles processes associated with the storing and validation of credentials.
  * @Version Last Updated: June 12 2016
  *
  */

//this class will have a file of some weird type and will have the methods addcredentials, verifycredentials, and maybe removecredentails. It will check within a file that it generates fo all these methods.

import java.io.File;

public class FileCredentials{

	private static String credFilename = "credentials.dtbf"; //databasefile!
	private static File credFile;
	//find some way to check if this exists. a nonexistant one means we gotta create a blank one. Can also parse the folder through bash commands or something and rm *.dtbf or something.

	public FileCredentials(){
		String curFolder = System.getProperty("user.dir");
		credFile = new File(curFolder + File.separator + "credentials" + File.separator + credFilename);
	}

	/**
	  * Inner class that represents a user/pass combo
	  */
	private class CredentialPair{
		String user, pass;
		public CredentialPair(String u, String p){user = u; pass = p;}
		public String getUser(){return user;}
		public String getPass(){return pass;}
		public String toString(){return "User: " + user + "  Pass: " + pass + "\n";}
	}

	/**
	 * Reads in the list of user/pass credentials stored in ./<credFilename>
	 * @return Returns the list of credentials stored in the credentials file.
	 */
	public CredentialPair[] importCredentials(){
		String out = FileIO.read(credFile);

		String[] kpCombos = out.split("~");
		int numCreds = kpCombos.length;
		CredentialPair[] creds = new CredentialPair[numCreds];
		for(int a = 0; a < numCreds; a++){
			String[] usrpss = kpCombos[a].split("`");
			creds[a] = new CredentialPair(usrpss[0], usrpss[1]);
		}

		return creds;
	}

	/**
	  * Adds a user/pass combination to the local array of credentials. Also writes a matching user/pass combination 
	  * @param user The username specified. This will be used to verify the availability of a certain username.
	  * @param pass The password associated with this username.
	  * @return TRUE if the credentials were added successfully, FALSE if there was any probem that prevented them from being added.
	  */
	public boolean addCredentials(String user, String pass){
		if(!userExists(user)){
			FileIO.addToFile(user+"`"+pass+"~", credFile); //write function not working yet
			return true;
		}
		return false;
	}

	/**
	  * Verifies that a key/pass combo exists already.
	  * @param user The username specified. This will be used to verify the availability of a certain username.
	  * @return True if the combo exists, false if no such user/pass exists.
	  */
	public boolean userExists(String user){
		CredentialPair[] creds = importCredentials();
		for(CredentialPair c : creds){
			if(c.user.equals(user)){
				return true;
			}
		}
		return false;
	}

	/**
	  * Checks to see if this user has a corresponding file for it in the ./users folder.
	  * @return user The user to check.
	  */
	public boolean userFileExists(String user){
		String curFolder = System.getProperty("user.dir");
		File userFile = new File(curFolder + File.separator + "users" + File.separator + user + ".dtbf");
		if(userFile.exists()){
			return true;
		}
		return false;
	}

	/**
	  * Checks to see if this database name has a corresponding file for it in the ./databases folder.
	  * @return database The database to check.
	  */
	public boolean databaseFileExists(String dtb){
		String curFolder = System.getProperty("user.dir");
		File userFile = new File(curFolder + File.separator + "databases" + File.separator + dtb + ".dtbf");
		if(userFile.exists()){
			return true;
		}
		return false;
	}

	/**
	  * Verifies the accuracy of an input user/pass combo.
	  * @param user The username specified. This will be used to verify the availability of a certain username.
	  * @param pass The password associated with this username.
	  * @return 1 if the specified credentials exist in the Credentials ArrayList and they are correct
	  *  	0 if they do not exist or are incorrect
	  * 	-1 if the user does not have a corresponding file.
	  */
	public int validateCredentials(String user, String pass){
		CredentialPair[] creds = importCredentials();
		
		for(CredentialPair c : creds){
			if(c.user.equals(user) && c.pass.equals(pass)){
				if(!userFileExists(user)){
					System.out.println("A filesystem error occurred: no such user file exists.");
					return -1;
				}
				return 1;
			}
		}
		return 0;
	}

}