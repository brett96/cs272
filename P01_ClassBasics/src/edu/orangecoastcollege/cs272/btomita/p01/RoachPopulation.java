package edu.orangecoastcollege.cs272.btomita.p01;

/**
 * Creates an object of type "RoachPopulation"
 * @author Brett Tomita
 *
 */
public class RoachPopulation 
{
	/**
	 * Variable that holds the value of the population
	 */
	private int mPopulation;
	
	/**
	 * Default constructor for RoachPopulation
	 * @param mPopulation
	 */
	public RoachPopulation(int mPopulation)
	{
		this.mPopulation = mPopulation;
	}
	
	/**
	 * Gets the roach population
	 * @return roach population
	 */
	public int getPopulation() 
	{
		return mPopulation;
	}
	
	/**
	 * Sets the roach population
	 * @param mPopulation roach population
	 */
	public void setPopulation(int mPopulation) 
	{
		this.mPopulation = mPopulation;
	}
	
	/**
	 * Doubles the roach population
	 */
	public void breed()
	{
		setPopulation(getPopulation()*2);
	}
	
	/**
	 * Decreases the roach population by 10%
	 */
	public void spray()
	{
		setPopulation((int)(getPopulation() - getPopulation()*.1));
	}
	
	/**
	 * Generates unique hash code
	 */
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + mPopulation;
		return result;
	}

	/**
	 * Determines if two RoachPopulations are equal
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
		RoachPopulation other = (RoachPopulation) obj;
		if (mPopulation != other.mPopulation)
			return false;
		return true;
	}

	/**
	 * Represents the roach population as a string
	 */
	@Override
	public String toString() 
	{
		return "Roach Population = " + mPopulation;
	}
}
