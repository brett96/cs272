package edu.orangecoastcollege.cs272.btomita.ic11.model;

/**
 * Class for car object
 * @author Brett
 *
 */
public class Car 
{
	private int mID;
	private int mCityMPG;
	private String mDescription;
	private String mFuelType;
	private int mHighwayMPG;
	private int mHorsepower;
	private boolean mHybrid;
	private String mMake;
	
	public Car(int id, String make, String description, int horsepower, String fuelType, int cityMPG, int highwayMPG,
			boolean hybrid) {
		// TODO Auto-generated constructor stub
		super();
		mID = id;
		mMake = make;
		mDescription = description;
		mHorsepower = horsepower;
		mFuelType = fuelType;
		mCityMPG = cityMPG;
		mHighwayMPG = highwayMPG;
		mHybrid = hybrid;
	}

	public int getCityMPG() 
	{
		return mCityMPG;
	}
	
	public void setCityMPG(int cityMPG) 
	{
		mCityMPG = cityMPG;
	}
	
	public String getDescription() {
		return mDescription;
	}
	
	public void setDescription(String description) {
		mDescription = description;
	}
	
	public String getFuelType() {
		return mFuelType;
	}
	
	public void setFuelType(String fuelType) {
		mFuelType = fuelType;
	}
	
	public int getHighwayMPG() {
		return mHighwayMPG;
	}
	
	public void setHighwayMPG(int highwayMPG) {
		mHighwayMPG = highwayMPG;
	}
	
	public int getHorsepower() {
		return mHorsepower;
	}
	
	public void setHorsepower(int horsepower) {
		mHorsepower = horsepower;
	}
	
	public boolean getHybrid() {
		return mHybrid;
	}
	
	public void setHybrid(boolean hybrid) {
		mHybrid = hybrid;
	}
	
	public String getMake() {
		return mMake;
	}
	
	public void setMake(String make) {
		mMake = make;
	}
	
	public int getID() {
		return mID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mCityMPG;
		result = prime * result + ((mDescription == null) ? 0 : mDescription.hashCode());
		result = prime * result + ((mFuelType == null) ? 0 : mFuelType.hashCode());
		result = prime * result + mHighwayMPG;
		result = prime * result + mHorsepower;
		result = prime * result + (mHybrid ? 1231 : 1237);
		result = prime * result + mID;
		result = prime * result + ((mMake == null) ? 0 : mMake.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (mCityMPG != other.mCityMPG)
			return false;
		if (mDescription == null) {
			if (other.mDescription != null)
				return false;
		} else if (!mDescription.equals(other.mDescription))
			return false;
		if (mFuelType == null) {
			if (other.mFuelType != null)
				return false;
		} else if (!mFuelType.equals(other.mFuelType))
			return false;
		if (mHighwayMPG != other.mHighwayMPG)
			return false;
		if (mHorsepower != other.mHorsepower)
			return false;
		if (mHybrid != other.mHybrid)
			return false;
		if (mID != other.mID)
			return false;
		if (mMake == null) {
			if (other.mMake != null)
				return false;
		} else if (!mMake.equals(other.mMake))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [mID=" + mID + ", mCityMPG=" + mCityMPG + ", mDescription=" + mDescription + ", mFuelType="
				+ mFuelType + ", mHighwayMPG=" + mHighwayMPG + ", mHorsepower=" + mHorsepower + ", mHybrid=" + mHybrid
				+ ", mMake=" + mMake + "]";
	}
	
	
}
