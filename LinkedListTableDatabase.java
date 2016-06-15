/**
  * LinkedListTableDatabase.java 
  * @Author Jake Runyan
  * @Project DataBaseProject
  * @About The instantiation of a Database that uses a singly linked list as its datatype.
  * @Version Last Updated: June 12 2016
  *
  */

import java.util.ArrayList;

public class LinkedListTableDatabase<T> implements TableDatabase<T>{

	//**** Fields ****
	public int physicalSize = 0; //physicalsize will mirror the arraylist's length
	ArrayList<LinkedListNode> list;

	private class LinkedListNode{
		private int value;
		private String key;
		public LinkedListNode(int val,String k){value = val; key = k;}
		public int getValue(){return value;}
		public String getKey(){return key;}
	}



	//**** Method Implementations ****

	/**
	  * Adds a generic value to the database.
	  */
	public void add(T t){

	}

	/**
	  * removes 
	  */
	public void remove(String key){

	}

	/**
	  * Empties the database of all entries.
	  */
	public void makeEmpty(){

	}

	/**
	  * Reorders the database into whatever order makes sense for the Database.
	  */
	public void reOrder(){

	}

	/**
	  * Generates the next valid index.
	  * @param key The key specified.  
	  */
	public int generateIndex(String key){
		return -1;
	}

	/**
	  * Destroys this database. Readies for program termination.
	  */
	public void destroyDatabase(){

	}


}