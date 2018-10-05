package edu.orangecoastcollege.cs272.btomita.ic01;

import java.util.Random;
import java.util.Scanner;
/**
 * JavaMechanics generates a user specified number of random coin flips.
 * @author btomita
 *
 */
public class JavaMechanics
{
    /**
     * Starts the process of generating a user specified number of random coin flips.
     * @param args  Command line arguments
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        System.out.println("How many times do you want to flip?");
        int times = input.nextInt();
        Random rng = new Random();
        for(int i = 0; i < times; i++)
        {
            int random = rng.nextInt(2);
            if(random == 1)
            {
                System.out.println("Heads");
            }
            else
            {
                System.out.println("Tails");
            }
        }
        input.close();

    }

}
