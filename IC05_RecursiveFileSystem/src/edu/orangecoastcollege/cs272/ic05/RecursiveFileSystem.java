package edu.orangecoastcollege.cs272.ic05;

import java.io.File;
import java.util.Scanner;

/**
 * Recursively counts number of files in a directory
 * @author Brett Tomita
 *
 */
public class RecursiveFileSystem 
{
	/**
	 * Takes a directory name and counts number of files
	 * @param fileList  list of files in directory
	 * @return number of files in directory
	 */
	public static int getFileNums(File[] fileList)
	{
		int count = 0;
		if(fileList == null) return count;
		File[] newDirectory = new File[fileList.length - 1];
		count++;
		getFileNums(newDirectory);
		return count;
	}

	/**
	 * Takes in name of directory and prints number of files in it
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a directory: ");
		String directory = input.nextLine();
		File file = new File(directory);
		File[] fileList = file.listFiles();
		System.out.println(getFileNums(fileList));
		input.close();
	}

}
