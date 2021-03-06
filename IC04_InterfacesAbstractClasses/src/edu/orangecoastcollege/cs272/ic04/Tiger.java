package edu.orangecoastcollege.cs272.ic04;

/**
 * Class for Tiger object which inherits from AnimalTraits
 * @author Brett Tomita
 *
 */
public class Tiger implements AnimalTraits 
{
	/**
	 * Variable that stores name
	 */
	private String mName;
	/**
	 * Variable that stores species of tiger
	 */
	private String mSpecies;
	
	/**
	 * Default constructor for tiger
	 * @param name
	 * @param species
	 */
	public Tiger(String name, String species) 
	{
		super();
		mName = name;
		mSpecies = species;
	}
	
	/**
	 * Returns name of tiger
	 * @return name
	 */
	public String getName() 
	{
		return mName;
	}
	
	/**
	 * Sets name of tiger
	 * @param name
	 */
	public void setName(String name) 
	{
		mName = name;
	}
	
	/**
	 * Returns species of tiger
	 * @return species
	 */
	public String getSpecies() 
	{
		return mSpecies;
	}
	
	/**
	 * Sets species of tiger
	 * @param species
	 */
	public void setSpecies(String species) 
	{
		mSpecies = species;
	}
	
	/**
	 * Generates hash code
	 */
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		result = prime * result + ((mSpecies == null) ? 0 : mSpecies.hashCode());
		return result;
	}
	
	/**
	 * Checks if two tigers are equal
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
		Tiger other = (Tiger) obj;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
			return false;
		if (mSpecies == null) {
			if (other.mSpecies != null)
				return false;
		} else if (!mSpecies.equals(other.mSpecies))
			return false;
		return true;
	}
	
	/**
	 * Generates sound that a tiger makes
	 */
	public String makeSound()
	{
		return "RROOAARR!";
	}
	
	/**
	 * Represents tiger object as a string
	 */
	public String toString()
	{
		return("Tiger [Name = " + getName() +", Species = " + getSpecies() + ", Sound: "
				+ makeSound());
	}
}
