package edu.orangecoastcollege.cs272.ic04.vehicle;

/**
 * Exception for if a car has an illegal number of wheels
 * @author Brett Tomita
 *
 */
public class IllegalNumberOfWheelsException extends Exception 
{
	//Default constructor has no parameters
	public IllegalNumberOfWheelsException()
	{
		super("Needs more wheels!");
	}
	
	/**
	 * IllegalNumberOfWheelsException method for a custom message
	 * @param message
	 */
	public IllegalNumberOfWheelsException(String message)
	{
		super(message);
	}
	
}
