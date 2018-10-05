package edu.orangecoastcollege.cs272.ic04.exceptions01;

import java.util.InputMismatchException;
import java.util.Scanner;

/** 
 * CS 272 - Exceptions example 1
 *
 *  Put the array code in a try block and
 *  catches the array index out of bounds exception
 *  if it occurs -OR- the number format exception if it occurs.
 */
public class Exeptions01
{
    public static void main(String [] args)
    {
    	int [] a = {5, 6, 7};
    	Scanner consoleScanner = new Scanner(System.in);
        
    	// try = code that could cause an exception
    	try{
    	System.out.println("int[] a = {5, 6, 7};");
        System.out.print("What element do you want? ");
        
        
        int index = consoleScanner.nextInt();
        int value = a[index];
        System.out.printf("ar[" + index + "] = " + value);
    	}
    	// catch = handle exceptions
    	// InputMismatchException = expected one data type and received another
    	// that could not be converted
        catch(InputMismatchException e)
    	{
        	System.out.println("Please enter numbers from 0 to " + (a.length - 1) + " only.");
    	}
    	// ArrayIndexOutOfBoundsException = index < 0 -OR- >= length of the array
    	catch(ArrayIndexOutOfBoundsException e)
    	{
    		System.out.println("Valid numbers are from 0 to " + (a.length - 1) + " only.");
    	}
    	// finally = no matter whether an exception occurred or not
    	// finally always executes
    	// Why? Clean up or close resources
    	finally
    	{
    		consoleScanner.close();
    	}
        
    }
}
