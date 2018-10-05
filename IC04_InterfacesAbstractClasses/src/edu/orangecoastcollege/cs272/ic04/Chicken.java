package edu.orangecoastcollege.cs272.ic04;

/**
 * Class for Chicken object which inherits from AnimalTraits
 * @author Brett Tomita
 *
 */
public class Chicken implements Edible, AnimalTraits 
{
	/**
	 * Variable which stores breed of chicken
	 */
	private String mBreed;

	/**
	 * Default constructor for chicken object
	 * @param breed
	 */
	public Chicken(String breed) 
	{
		super();
		mBreed = breed;
	}

	/**
	 * Returns breed of chicken
	 * @return breed
	 */
	public String getBreed() {
		return mBreed;
	}

	/**
	 * Sets breed of chicken
	 * @param breed
	 */
	public void setBreed(String breed) {
		mBreed = breed;
	}

	/**
	 * Generates hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mBreed == null) ? 0 : mBreed.hashCode());
		return result;
	}

	/**
	 * Checks if two chickens are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chicken other = (Chicken) obj;
		if (mBreed == null) {
			if (other.mBreed != null)
				return false;
		} else if (!mBreed.equals(other.mBreed))
			return false;
		return true;
	}
	
	/**
	 * Explains how to eat chicken
	 */
	public String howToEat()
	{
		return "Marinate and grill";
	}
	
	/**
	 * Returns the sound a chicken makes
	 */
	public String makeSound()
	{
		return "Cock-a-doodle-doo!";
	}
	
	/**
	 * Represents chicken object as a string
	 */
	@Override
	public String toString()
	{
		return("Chicken [Breed = " + getBreed() + ", Sound: " + makeSound() + ", How To Eat: "
				+ howToEat() + "]");
	}
}