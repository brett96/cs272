package edu.orangecoastcollege.cs272.ic05;

public final class Word 
{
	/*
	 * To make a class immutable, add "final" keyword to class definition (ex. public final class Word)
	 * Make all member variables final as well
	 * No mutators (no setters AT ALL)
	 * Make defensive copies of all collections = return new item made from old item
	 */

	/**
	 * Base of word
	 */
	private final String mBase;
	/**
	 * Plural form of word
	 */
	private final String mPlural;
	/**
	 * Category of word
	 */
	private final Category mCategory;
	
	/**
	 * Returns the word's base
	 * @return word base
	 */
	public String getBase() 
	{
		return mBase;
	}
	
	/**
	 * Returns plural form of word
	 * @return plural word
	 */
	public String getPlural() 
	{
		return mPlural;
	}
	
	/**
	 * Returns category of word
	 * @return word category
	 */
	public Category getCategory() 
	{
		return mCategory;
	}
	
	/**
	 * Default constructor for word
	 * @param mBase
	 * @param mPlural
	 * @param noun
	 */
	public Word(String mBase, String mPlural, Category noun) 
	{
		this.mBase = mBase;
		this.mPlural = mPlural;
		this.mCategory = noun;
	}
	
	/**
	 * Generates hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mBase == null) ? 0 : mBase.hashCode());
		result = prime * result + ((mCategory == null) ? 0 : mCategory.hashCode());
		result = prime * result + ((mPlural == null) ? 0 : mPlural.hashCode());
		return result;
	}
	
	/**
	 * Checks if two words are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (mBase == null) {
			if (other.mBase != null)
				return false;
		} else if (!mBase.equals(other.mBase))
			return false;
		if (mCategory == null) {
			if (other.mCategory != null)
				return false;
		} else if (!mCategory.equals(other.mCategory))
			return false;
		if (mPlural == null) {
			if (other.mPlural != null)
				return false;
		} else if (!mPlural.equals(other.mPlural))
			return false;
		return true;
	}

	/**
	 * Returns word info in string format
	 */
	@Override
	public String toString() {
		return "Word [Base=" + mBase + ", Plural=" + mPlural + ", Category=" + mCategory + "]";
	}
	
	
	
	
}
