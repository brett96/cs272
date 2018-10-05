package edu.orangecoastcollege.cs272.ic04;
/**
 * Class for orange object which inherits from fruit
 * @author Brett Tomita
 *
 */
public class Orange extends Fruit
{
	/**
	 * Default constructor for orange
	 * @param mVariety
	 * @param mCalories
	 */
	public Orange(String mVariety, int mCalories) 
	{
		super(mVariety, mCalories);
	}
	
	/**
	 * Describes how to ear orange
	 */
	public String howToEat()
	{
		return "Peel, slice, and enjoy!";
	}
	
	/**
	 * Represents orange object as a string
	 */
	@Override
	public String toString()
	{
		return ("Apple [Variety = " + getVariety() + ", Calories = " + getCalories() 
			+ ", How To Eat: " + howToEat() + "]");
	}
}
