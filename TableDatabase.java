/**
  * TableDatabase.java 
  * @Author Jake Runyan
  * @Project DataBaseProject
  * @About This project simulates different implementations of databases with graphical input/user interface.
  * @Version Last Updated: June 12 2016
  *
  */

public interface TableDatabase<T>{

	//**** Default Fields ****
	public int physicalSize = 0;
	//each impelementing class of TableDatabase should indlude a storage array of some sort.

	//**** Subclass Typedefines ****
		//each implementing class of TableDatabase should include one or more DataObject classes that will depend on the method of storing data.


	//**** Method Stubs ****

	/**
	  * Adds a generic value to the database.
	  */
	public void add(T t);

	/**
	  * Removes specified key and matching value.
	  */
	public void remove(String key);

	/**
	  * Empties the database of all entries.
	  */
	public void makeEmpty();

	/**
	  * Reorders the database into whatever order makes sense for the Database.
	  */
	public void reOrder();

	/**
	  * Generates the next valid index.
	  * @param key the key used  
	  */
	public int generateIndex(String key);

	/**
	  * Destroys this database. Readies for program termination.
	  */
	public void destroyDatabase();
}