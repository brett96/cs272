package edu.orangecoastcollege.cs272.btomita.p01;

/**
 * Abstract base class for MotorVehicles
 * @author Brett Tomita
 *
 */
public abstract class MotorVehicle 
{
	public abstract class Cycle{};
	
	/**
	 * Make of vehicle
	 */
	protected String mMake;
	/**
	 * Speed of vehicle
	 */
	protected double mSpeed;
	/**
	 * Vehicle's VIN
	 */
	protected String mVIN;
	/**
	 * Year of vehicle
	 */
	protected int mYear;
	
	/**
	 * Retrieve make of vehicle
	 * @return make
	 */
	public String getMake() {
		return mMake;
	}
	
	/**
	 * Set make of vehicle
	 * @param mMake make
	 */
	public void setMake(String mMake) {
		this.mMake = mMake;
	}
	
	/**
	 * Retrieve speed of vehicle
	 * @return speed
	 */
	public double getSpeed() {
		return mSpeed;
	}
	
	/**
	 * Set speed of vehicle
	 * @param mSpeed speed
	 */
	public void setSpeed(double mSpeed) {
		this.mSpeed = mSpeed;
	}
	
	/**
	 * Retrieve VIN of vehicle
	 * @return VIN
	 */
	public String getVIN()
	{
		return mVIN;
	}
	
	/**
	 * Retrieve year of vehicle
	 * @return year
	 */
	public int getYear() {
		return mYear;
	}
	
	/**
	 * Set year of vehicle
	 * @param mYear year
	 */
	public void setYear(int mYear) {
		this.mYear = mYear;
	}
	
	/**
	 * Represents vehicle details in string format
	 */
	@Override
	public String toString() {
		return "MotorVehicle [mMake=" + mMake + ", mSpeed=" + mSpeed + ", mVIN=" + mVIN + ", mYear=" + mYear + "]";
	}
	
	/**
	 * Generates hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mMake == null) ? 0 : mMake.hashCode());
		long temp;
		temp = Double.doubleToLongBits(mSpeed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((mVIN == null) ? 0 : mVIN.hashCode());
		result = prime * result + mYear;
		return result;
	}
	
	/**
	 * Checks if two vehicles are equal
	 */
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MotorVehicle other = (MotorVehicle) obj;
		if (mMake == null) {
			if (other.mMake != null)
				return false;
		} else if (!mMake.equals(other.mMake))
			return false;
		if (Double.doubleToLongBits(mSpeed) != Double.doubleToLongBits(other.mSpeed))
			return false;
		if (mVIN == null) {
			if (other.mVIN != null)
				return false;
		} else if (!mVIN.equals(other.mVIN))
			return false;
		if (mYear != other.mYear)
			return false;
		return true;
	}
	
	
}
