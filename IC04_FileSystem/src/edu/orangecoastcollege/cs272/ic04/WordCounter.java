package edu.orangecoastcollege.cs272.ic04;

import java.io.*;
import java.util.Scanner;

/**
 * Reading and processing text files.
 * 
 * Reads a text file, line by line, counts the number of words per line, prints
 * out each line of the poem, preceded by number of the number of words in that
 * line.
 * 
 */
public class WordCounter
{
    public void countWords(String inputFile, String outputFile) throws FileNotFoundException
    {
        // 1. Construct the Scanner and PrintWriter objects
        // TODO: your work here
    	Scanner fileScanner = new Scanner(new File(inputFile));
       
    	// Write to a text file
    	PrintWriter fileWriter = new PrintWriter(new File(outputFile));
        
        // 2. Read the input file, writing the output for each line
        // TODO: your work here
    	// Use while loop to read through the file one line at a time
    	// While file has another line...
        while(fileScanner.hasNextLine())
        {
        	// Read it
        	String line = fileScanner.nextLine();
        	// line = Peter Piper picked a peck of pickled peppers.
        	
        	// split method creates an array of Strings where each element is split
        	// wherever a certain character appears
        	String[] words = line.split(" ");
        	
        	// Write number of words (array length) and message (line) 
        	// to output file
        	fileWriter.println(words.length + "   " + line);
        }
        
        // 3. Close all files
        // TODO: your work here
        fileWriter.close();
        fileScanner.close();
       
    }

    /**
     * Run as an application like this.
     */
    public static void main(String[] args) throws Exception
    {
        WordCounter app = new WordCounter();
        // Set up the input and output file names (hard-coded for this problem)
        app.countWords("Peter.txt", "output.txt");
    }
}
