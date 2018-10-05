package edu.orangecoastcollege.cs272.ic12.model;

public class Car {

	private int mID;
	private String mMake;
	private String mDescription;
	private int mHorsepower;
	private String mFuelType;
	private int mCityMPG;
	private int mHighwayMPG;
	private boolean mHybrid;

	/**
	 * Constructor for car object
	 * @param id
	 * @param make
	 * @param description
	 * @param horsepower
	 * @param fuelType
	 * @param cityMPG
	 * @param highwayMPG
	 * @param hybrid
	 */
	public Car(int id, String make, String description, int horsepower, String fuelType, int cityMPG,
			int highwayMPG, boolean hybrid) {
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

	/**
	 * Returns car ID
	 * @return
	 */
	public int getID() {
		return mID;
	}

	/**
	 * Returns make of car
	 * @return
	 */
	public String getMake() {
		return mMake;
	}

	/**
	 * Returns car description
	 * @return
	 */
	public String getDescription() {
		return mDescription;
	}

	/**
	 * Returns horsepower of car
	 * @return
	 */
	public int getHorsepower() {
		return mHorsepower;
	}

	/**
	 * Returns fuel type of car
	 * @return
	 */
	public String getFuelType() {
		return mFuelType;
	}

	/**
	 * Returns city mpg
	 * @return
	 */
	public int getCityMPG() {
		return mCityMPG;
	}

	/**
	 * Returns highway mpg
	 * @return
	 */
	public int getHighwayMPG() {
		return mHighwayMPG;
	}

	/**
	 * Specifies if car is hybrid
	 * @return
	 */
	public boolean getHybrid() {
		return mHybrid;
	}

	/**
	 * Sets make of car
	 * @param make
	 */
	public void setMake(String make) {
		mMake = make;
	}

	/**
	 * Sets description of car
	 * @param description
	 */
	public void setDescription(String description) {
		mDescription = description;
	}

	/**
	 * Sets horsepower of car
	 * @param horsepower
	 */
	public void setHorsepower(int horsepower) {
		mHorsepower = horsepower;
	}

	/**
	 * Sets fuel type of car
	 * @param fuelType
	 */
	public void setFuelType(String fuelType) {
		mFuelType = fuelType;
	}

	/**
	 * Sets car's city mpg
	 * @param cityMPG
	 */
	public void setCityMPG(int cityMPG) {
		mCityMPG = cityMPG;
	}

	/**
	 * Sets car's highway mpg
	 * @param highwayMPG
	 */
	public void setHighwayMPG(int highwayMPG) {
		mHighwayMPG = highwayMPG;
	}

	/**
	 * Specifies if car is hybrid
	 * @param hybrid
	 */
	public void setHybrid(boolean hybrid) {
		mHybrid = hybrid;
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
		return "Car [Make=" + mMake + ", Description=" + mDescription + ", Horsepower=" + mHorsepower + ", FuelType="
				+ mFuelType + ", City MPG=" + mCityMPG + ", Highway MPG=" + mHighwayMPG + ", Hybrid=" + mHybrid + "]";
	}
}
