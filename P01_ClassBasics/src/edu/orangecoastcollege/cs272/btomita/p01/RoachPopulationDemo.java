package edu.orangecoastcollege.cs272.btomita.p01;

/**
 * Simulates the population of a group of roaches
 * @author Brett Tomita
 *
 */
public class RoachPopulationDemo 
{
	/**
	 * Begins process of simulating the population of roaches
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		RoachPopulation roaches = new RoachPopulation(10);
		for(int i = 0; i < 4; i++)
		{
			roaches.breed();
			roaches.spray();
			System.out.println(roaches.toString());
		}
	}
}
