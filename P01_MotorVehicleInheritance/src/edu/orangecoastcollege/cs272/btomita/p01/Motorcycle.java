package edu.orangecoastcollege.cs272.btomita.p01;

/**
 * Class for a Motorcycle object which inherits from MotorVehicle
 * @author Brett Tomita
 *
 */
public class Motorcycle extends MotorVehicle
{
	/**
	 * Distance between wheels in inches
	 */
	protected double mWheelbase;  

	/**
	 * Returns value of wheel base
	 * @return wheel base
	 */
	public double getWheelbase() 
	{
		return mWheelbase;
	}

	/**
	 * Sets the value of the wheel base
	 * @param wheelbase value of wheel base
	 */
	public void setWheelbase(double wheelbase) {
		mWheelbase = wheelbase;
	}
	
	/**
	 * Default constructor for a Motorcycle
	 * @param mMake make of motorcycle
	 * @param mSpeed speed of motorcycle
	 * @param mVIN VIN of motorcycle
	 * @param mYear year of motorcycle
	 * @param mWheelbase wheelbase of motorcycle
	 */
	public Motorcycle(String mMake, double mSpeed, String mVIN, int mYear, double mWheelbase)
	{
		this.mMake = mMake;
		this.mSpeed = mSpeed;
		this.mVIN = mVIN;
		this.mYear = mYear;
		this.mWheelbase = mWheelbase;
	}
	
	/**
	 * Copy constructor of motorcycle
	 * @param m Motorcycle object
	 */
	public Motorcycle(Motorcycle m)
	{
		this.mMake = m.getMake();
		this.mSpeed = m.getSpeed();
		this.mVIN = m.getVIN();
		this.mYear = m.getYear();
		this.mWheelbase = m.getWheelbase();
	}
	
	/**
	 * Accelerates motorcycle by 30%
	 */
	public void accelerate()
	{
		setSpeed(getSpeed() + getSpeed()*.3);
	}
	
	/**
	 * Decelerates motorcycle by 30%
	 */
	public void decelerate()
	{
		setSpeed(getSpeed() - getSpeed()*.3);
	}
	
	
	/**
	 * Generates hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(mWheelbase);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * Checks if two Motorcycles are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Motorcycle other = (Motorcycle) obj;
		if (Double.doubleToLongBits(mWheelbase) != Double.doubleToLongBits(other.mWheelbase))
			return false;
		return true;
	}

	/**
	 * Represents details of Motorcycle in string format
	 */
	@Override
	public String toString()
	{
		return("[Motorcycle: " + getVIN() + ", " + getYear() + ", " + getMake() + ", " + getSpeed() + " MPH, " + getWheelbase() 
			+"\" wheelbase]");
	}
}
