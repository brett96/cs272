package edu.orangecoastcollege.cs272.btomita.ic02;
import java.util.Scanner;

/**
 * Calculates the numeric value of a letter grade
 * @author Brett Tomita
 *
 */
public class Grade {
	/**
	 * Main method - takes in letter grade and calculates and returns numeric grade
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		double numericGrade = -1;
		System.out.print("Enter a letter grade: ");
		String grade = input.next().toLowerCase();
		input.close();
		char[] letterGrade = grade.toCharArray();
		for(char element : letterGrade)
		{
			switch(element)
			{
			case 'a': numericGrade = 4;
			break;
			case 'b': numericGrade = 3;
			break;
			case 'c': numericGrade = 2;
			break;
			case 'd': numericGrade = 1;
			break;
			case 'f': numericGrade = 0;
			break;
			}
			if(element == '-' && numericGrade > 0) { numericGrade -= 0.3;}
			else if(element == '+' && numericGrade != 4 && numericGrade > 0) { numericGrade += 0.3;}
		}
		System.out.println("Numeric value: " + numericGrade);
	}
}