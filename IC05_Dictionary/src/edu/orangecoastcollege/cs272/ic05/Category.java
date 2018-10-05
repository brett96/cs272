package edu.orangecoastcollege.cs272.ic05;

/**
 * Enum for categories of words
 * @author Brett Tomita
 *
 */
public enum Category 
{
	/*
	 * Category mCategory = enum
	 * enum = enumeration = set of related constants
	 * 
	 * public enum Category
	 * {
	 * 	NOUN,
	 * 	VERB,
	 * 	PREPOSITION,
	 * 	...  All comma separated
	 * }
	 * 
	 * mCategory can only accept one of nine categories
	 */
	
	NOUN,
	VERB,
	ADJECTIVE,
	ADVERB,
	PRONOUN,
	PREPOSITION,
	CONJUNCTION,
	INTERJECTION,
	DETERMINER,
	
	// enums can also have methods (i.e. toString())
	
//	@Override
//	public String toString()
//	{
//		return name().charAt(0) + name().toLowerCase().substring(1);
//	}
}


