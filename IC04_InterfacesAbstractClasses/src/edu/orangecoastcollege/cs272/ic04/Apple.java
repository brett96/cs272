package edu.orangecoastcollege.cs272.ic04;

/**
 * Class for an Apple object which inherits from Fruit
 * @author Brett Tomita
 *
 */
public class Apple extends Fruit
{
	/**
	 * Stores color of apple
	 */
	private String mColor;
	
	/**
	 * Default constructor for apple
	 * @param mVariety Variety
	 * @param mCalories Calories
	 * @param mColor Color
	 */
	public Apple(String mVariety, int mCalories, String mColor)
	{
		super(mVariety, mCalories); // Replaces with Fruit: Calls Fruit and supplies w/ 
		//mVariety and mCalories.  Java will supply this if you don't
		this.mColor = mColor;
	}
	
	/**
	 * Returns color of apple
	 * @return color
	 */
	public String getColor() 
	{
		return mColor;
	}

	/**
	 * Sets color of apple
	 * @param color
	 */
	public void setColor(String color) 
	{
		mColor = color;
	}
	
	/**
	 * Generates hash code
	 */
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((mColor == null) ? 0 : mColor.hashCode());
		return result;
	}

	/**
	 * Checks if two apples are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apple other = (Apple) obj;
		if (mColor == null) {
			if (other.mColor != null)
				return false;
		} else if (!mColor.equals(other.mColor))
			return false;
		return true;
	}

	/**
	 * Describes how to eat an apple
	 */
	public String howToEat()
	{
		return "Wash, core, slice and enjoy!";
	}
	
	/**
	 * Represents apple object as a string
	 */
	@Override
	public String toString()
	{
		return ("Apple [Variety = " + getVariety() + ", Calories = " + getCalories() + ", Color = " 
				+ getColor() + ", How To Eat: " + howToEat() + "]");
	}
}
