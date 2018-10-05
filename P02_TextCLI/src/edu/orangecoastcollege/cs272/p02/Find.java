package edu.orangecoastcollege.cs272.p02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Find
 * @author Brett Tomita
 * @version 3/12/17
 * 
 * This program searches files and prints out 
 * all lines containing a keyword.
 */
public class Find
{
	/**
	 * Starts process of finding keywords in given files
	 * @param args
	 * @throws FileNotFoundException
	 */
    public static void main(String[] args) throws FileNotFoundException
    { 
       if (args.length < 1)
       { 
          System.out.println("Usage: Find keyword sourcefile1 sourcefile2 . . .");
          return;
       }
       
       // TODO: Here are some hints. Complete the program.
       String keyword = args[0];
       char[] keys = keyword.toCharArray();
       for (int i = 1; i < args.length; i++)
       {
    	   String filename = args[i];
    	   try
    	   {
    			 Scanner fileScanner = new Scanner(new File(filename));
    			 while(fileScanner.hasNextLine())
    			 {
    				 String line = fileScanner.nextLine();
    				 char[] chars = line.toCharArray();
    				 for(int j = 0; j < chars.length; j++)
    				 {
    					 boolean match = false;
    					 int temp = j; // copy of j to iterate through next loop without changing value of j
    				 for(char item : keys)
    				 {
    					 if(chars[temp] == item) 
    					 {
    					 	match = true;
    					 }
    					 else 
    					 {
    					 	match = false;
    					 	break;
    					 }
    					 temp++;
    				 }
    				 if(match) System.out.println(filename + ": " + line);
    				 }
    			 }
    	   }
    	   catch(FileNotFoundException e)
    	   {
    		   System.out.println("File " + filename + " could not be found");
    	   }
      }
    }
}

