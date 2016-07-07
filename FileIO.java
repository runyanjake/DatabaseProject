/**
  * FileIO.java 
  * @Author Jake Runyan
  * @Project DataBaseProject
  * @About Handles file IO for the program. Writes and reads from template files.
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
	private static void read(String s, File input){
		try{
			FileReader fread = new FileReader(input);
			BufferedReader in = new BufferedReader(fread);
			//TODO: FINISH 
		}catch(FileNotFoundException e){
			System.out.println("Error: File Not Found: " + input);
		}

	}

	/**
	  * Writes to a input file from a String.
	  * @param s The String we wish to write data from.
	  * @param output The output file we would like to write to.
	  */
	private static void write(String s, File output){
		try{
			FileWriter fwrite = new FileWriter(output);
			BufferedWriter out = new BufferedWriter(fwrite);
			//TODO: FINISH 
		}catch(IOException e){
			System.out.println("Error: File Not Found: " + output);
		}

	}

	/**
	  * Converts a generic TableDatabase to a String TableDatabase for use with the write method.
	  * -- HELPER METHOD FOR write(T,output) --
	  */
	private static TableDatabase<String> dbToString(TableDatabase<?> T){
		return null;
	}

}