package edu.orangecoastcollege.cs272.btomita.ic01;

import java.util.Random;

/**
 * JavaArrays generates 100 random numbers ranging from 25 to 75 and adds them to an array
 * @author Brett Tomita
 *
 */
public class JavaArrays
{
	/**
	 * Starts process of generating 100 random numbers
	 * @param args
	 */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] randomNumbers = new int[100];
        Random rng = new Random();
        //sysout + ctrl + space
        int count = 0;
        for(int i = 0; i < 100; i++)
        {
            int random = rng.nextInt(51) + 25;
            randomNumbers[i] = random;
            System.out.print(random + " ");
            if(count == 19)
            {
                System.out.println();
                count = 0;
            }
            else
            {
                count++;
            }
        }

    }

}
