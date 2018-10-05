package edu.orangecoastcollege.cs272.btomita.p01;

/**
 * Class for a Car object which inherits from MotorVehicle
 * @author Brett Tomita
 *
 */
public class Car extends MotorVehicle
{
	/**
	 * Variable for number of passengers car can hold
	 */
	protected int mPassengers; 

	/**
	 * Retrieves the number of passengers the car can hold
	 * @return number of passengers
	 */
	public int getPassengers() 
	{
		return mPassengers;
	}

	/**
	 * Sets the number of passengers the car can hold
	 * @param passengers
	 */
	public void setPassengers(int passengers) 
	{
		mPassengers = passengers;
	}
	
	/**
	 * Default constructor for Car
	 * @param mMake make of car
	 * @param mSpeed speed of car
	 * @param mVIN VIN of car
	 * @param mYear Year of car
	 * @param mPassengers Maximum passengers car can hold
	 */
	public Car(String mMake, double mSpeed, String mVIN, int mYear, int mPassengers)
	{
		this.mMake = mMake;
		this.mSpeed = mSpeed;
		this.mVIN = mVIN;
		this.mYear = mYear;
		this.mPassengers = mPassengers;
	}
	
	/**
	 * Accelerates car by 20%
	 */
	public void accelerate()
	{
		setSpeed(getSpeed() + getSpeed()*.2);
	}
	
	/**
	 * Decelerates car by 20%
	 */
	public void decelerate()
	{
		setSpeed(getSpeed() - getSpeed()*.2);
	}

	/**
	 * Creates hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mPassengers;
		return result;
	}

	/**
	 * Determines if two Cars are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (mPassengers != other.mPassengers)
			return false;
		return true;
	}
	
	/**
	 * Represents the details of the Car object as a string
	 */
	@Override
	public String toString()
	{
		return("[Car: " + getVIN() + ", " + getYear() + ", " + getMake() +", " + getSpeed() +" MPH, " + getPassengers() + " passengers]");
	}
}
