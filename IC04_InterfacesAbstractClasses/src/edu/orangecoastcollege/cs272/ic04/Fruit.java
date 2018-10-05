package edu.orangecoastcollege.cs272.ic04;

/**
 * Abstract class for Fruit object which implements Edible
 * @author Brett Tomita
 *
 */
public abstract class Fruit implements Edible
{
	/**
	 * Stores the variety of the fruit
	 */
	protected String mVariety;
	/**
	 * Stores the calories of the fruit
	 */
	protected int mCalories;
	
	/**
	 * Returns the variety of the fruit
	 * @return variety
	 */
	public String getVariety() 
	{
		return mVariety;
	}
	
	/**
	 * Sets variety of fruit
	 * @param variety
	 */
	public void setVariety(String variety) 
	{
		this.mVariety = variety;
	}
	
	/**
	 * Gets the amount of calories in a fruit
	 * @return calories
	 */
	public int getCalories() 
	{
		return mCalories;
	}
	
	/**
	 * Sets the amount of calories in a fruit
	 * @param calories
	 */
	public void setCalories(int calories) 
	{
		this.mCalories = calories;
	}

	/**
	 * Generates hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mCalories;
		result = prime * result + ((mVariety == null) ? 0 : mVariety.hashCode());
		return result;
	}

	/**
	 * Checks if two fruits are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fruit other = (Fruit) obj;
		if (mCalories != other.mCalories)
			return false;
		if (mVariety == null) {
			if (other.mVariety != null)
				return false;
		} else if (!mVariety.equals(other.mVariety))
			return false;
		return true;
	}
	
	/**
	 * Default constructor for a Fruit object
	 * @param mVariety
	 * @param mCalories
	 */
	protected Fruit(String mVariety, int mCalories)
	{
		super();
		this.mVariety = mVariety;
		this.mCalories = mCalories;
	}
}
