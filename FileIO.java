/**
  * FileIO.java 
  * @Author Jake Runyan
  * @Project DataBaseProject
  * @About Handles file IO for the program. 
  * 	Not to be confused with user authentification, which happens through FileCredentials.java. 
  * 	Writes and reads from template files.
  * @Version Last Updated: June 12 2016
  *
  */

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileIO{

	/**
	  * Reads from a input file to a String.
	  * @param s The String we wish to compile data to.
	  * @param input The input file we would like to read from.
	  */
	public static String read(File input){
		String ans = "";
		try{	
			FileReader fread = new FileReader(input);
			BufferedReader in = new BufferedReader(fread);
			String temp = "";
			while((temp = in.readLine()) != null){
				ans = ans + temp;
			}
		}catch(FileNotFoundException e){
			System.out.println("Error: File Not Found: " + input);
			return null;
		}catch(IOException e){
			System.out.println("Error: File reading failed for file: " + input);
			return null;
		}
		return ans;
	}

	/**
	  * Writes to a input file from a String. THIS OVERWRITES WHAT WAS ALREADY ON THE FILE.
	  * @param s The String we wish to write data from.
	  * @param output The output file we would like to write to.
	  */
	public static void overWrite(String s, File output){
		try{
			FileWriter fwrite = new FileWriter(output);
			BufferedWriter out = new BufferedWriter(fwrite);
			out.write(s,0,s.length());
			out.close();
		}catch(IOException e){
			System.out.println("Error: File Not Found: " + output);
		}

	}

	/**
	  * Adds a string to a file.
	  * @param s The String we wish to add.
	  * @param output The output file we would like to write to.
	  */
	public static void addToFile(String s, File output){
		try{
			String toWrite = read(output); //do this before we open it to write
			FileWriter fwrite = new FileWriter(output);
			BufferedWriter out = new BufferedWriter(fwrite);
			toWrite = toWrite + s;
			out.write(toWrite,0,toWrite.length());
			out.close();
		}catch(IOException e){
			System.out.println("Error: File Not Found: " + output);
		}

	}

	

}