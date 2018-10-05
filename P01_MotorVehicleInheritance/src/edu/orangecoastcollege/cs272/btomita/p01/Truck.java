package edu.orangecoastcollege.cs272.btomita.p01;

/**
 * Class for a Truck object which inherits from MotorVehicle
 * @author Brett Tomita
 *
 */
public class Truck extends MotorVehicle
{
	/**
	 * How many pounds the truck can carry
	 */
	protected int mPayload; 

	/**
	 * Retrieves payload of Truck
	 * @return payload
	 */
	public int getPayload() 
	{
		return mPayload;
	}

	/**
	 * Sets payload of Truck
	 * @param payload payload
	 */
	public void setPayload(int payload) 
	{
		mPayload = payload;
	}
	
	/**
	 * Default constructor for Truck object
	 * @param mMake Make of Truck
	 * @param mSpeed Speed of Truck
	 * @param mVIN Truck's VIN
	 * @param mYear Year of Truck
	 * @param mPayload Payload of Truck
	 */
	public Truck(String mMake, double mSpeed, String mVIN, int mYear, int mPayload)
	{
		this.mMake = mMake;
		this.mSpeed = mSpeed;
		this.mVIN = mVIN;
		this.mYear = mYear;
		this.mPayload = mPayload;
	}
	
	/**
	 * Accelerates Truck by 10%
	 */
	public void accelerate()
	{
		setSpeed(getSpeed() + getSpeed()*.1);
	}
	
	/**
	 * Decelerates Truck by 10%
	 */
	public void decelerate()
	{
		setSpeed(getSpeed() - getSpeed()*.1);
	}

	/**
	 * Generates hash code
	 */
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + mPayload;
		return result;
	}

	/**
	 * Checks if two Trucks are equal
	 */
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Truck other = (Truck) obj;
		if (mPayload != other.mPayload)
			return false;
		return true;
	}
	
	/**
	 * Represents details of Truck in string format
	 */
	@Override
	public String toString()
	{
		return("[Truck: " + getVIN() + ", " + getYear() + ", " + getMake() +", " + getSpeed() +" MPH, " + getPayload() + " lb payload]");
	}
	
}
