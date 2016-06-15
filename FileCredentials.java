/**
  * FileCredentials.java 
  * @Author Jake Runyan
  * @Project DataBaseProject
  * @About Handles processes associated with the storing and validation of credentials.
  * @Version Last Updated: June 12 2016
  *
  */

//this class will have a file of some weird type and will have the methods addcredentials, verifycredentials, and maybe removecredentails. It will check within a file that it generates fo all these methods.

public class FileCredentials{

	private static String credFilename = "credentials.dtbf"; //databasefile!
	//find some way to check if this exists. a nonexistant one means we gotta create a blank one. Can also parse the folder through bash commands or something and rm *.dtbf or something.

	public FileCredentials(){
		//see above note
		//this should read in the file to a 
	}

	private class CredentialPair{
		String user, pass;
		public CredentialPair(String u, String p){user = u; pass = p;}
		public String getUser(){return user;}
		public String getPass(){return pass;}
	}

	/**
	  * Adds a user/pass combination to the local array of credentials. Also writes a matching user/pass combination 
	  * @param user The username specified. This will be used to verify the availability of a certain username.
	  * @param pass The password associated with this username.
	  * @return TRUE if the credentials were added successfully, FALSE if there was any probem that prevented them from being added.
	  */
	public boolean addCredentials(String user, String pass){
		return true;
	}

	/**
	  * Verifies that a key/pass combo exists already.
	  * @param user The username specified. This will be used to verify the availability of a certain username.
	  * @param pass The password associated with this username.
	  * @return The index of the combo if it exists, -1 if no such user/pass exists.
	  */
	public int kpComboExists(String user, String pass){
		return -1;
	}

	/**
	  * Verifies the accuracy of an input user/pass combo.
	  * @param user The username specified. This will be used to verify the availability of a certain username.
	  * @param pass The password associated with this username.
	  * @return TRUE if the specified credentials exist in the Credentials ArrayList and they are correct, FALSE if they do not exist or are incorrect.
	  */
	public boolean verifyCredentials(String user, String pass){
		return false;
	}

	/**
	  * Syncs the credentials stored in the local Arraylist with the credentials stored in the file.
	  * @note This method favors keeping credentials; It will add credentials from the ArrayList to the file, but will not delete non-present keys.
	  */
	public static void syncCredentials(){

	}

}