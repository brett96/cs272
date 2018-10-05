package edu.orangecoastcollege.cs272.ic05;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Creates a dictionary of words and generates sentences
 * @author Brett Tomita
 *
 */
public class DictionaryDemo 
{
	/**
	 * Starts process of adding words to the dictionary
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		// Simple sentence = noun + verb + noun
		// Intermediate Sentence = noun + verb + noun + preposition + noun
		
		/*
		 * Ex. = "Baby attacks grandma"
		 * 	Baby = base
		 * 	attacks = plural
		 * 	grandma = base or plural
		 */	
		
		List<Word> dictionary = new ArrayList<>();
		
		dictionary.add(new Word("baby", "babies", Category.NOUN));
		dictionary.add(new Word("computer", "computer", Category.NOUN));
		dictionary.add(new Word("computer", "computer", Category.NOUN));
		dictionary.add(new Word("grandmother", "grandmothers", Category.NOUN));
		dictionary.add(new Word("monkey", "monkeys", Category.NOUN));
		dictionary.add(new Word("planet", "planets", Category.NOUN));
		dictionary.add(new Word("programmer", "programmers", Category.NOUN));
		dictionary.add(new Word("puppy", "puppies", Category.NOUN));
		
		
		dictionary.add(new Word("attack", "attacks", Category.VERB));
		dictionary.add(new Word("calculate", "calculates", Category.VERB));		
		dictionary.add(new Word("compute", "computes", Category.VERB));
		dictionary.add(new Word("deceive", "decieves", Category.VERB));
		dictionary.add(new Word("heal", "heals", Category.VERB));
		dictionary.add(new Word("save", "saves", Category.VERB));
		
		dictionary.add(new Word("in", "in", Category.PREPOSITION));
		dictionary.add(new Word("behind", "behind", Category.PREPOSITION));
		
		
		System.out.println(getSimpleSentences(dictionary));
		System.out.println(getIntermediateSentences(dictionary));
		
	}
	
	/**
	 * Filters a list based on a predicate condition and returns the filtered list.
	 * 
	 * @param dictionary The original list (has all the words)
	 * @param predicate The condition by which to filter
	 * @return A new List containing the filtered results
	 */
	public static List<Word> filter(List<Word> dictionary, Predicate<Word> predicate)
	{
		// dictionary = List of all Words
		// .stream() makes a copy for searching
		// .filter(predicate) filters the results based on predicate condition
		// Collectors determines how results will be collected (toList())
		return dictionary.stream().filter(predicate).collect(Collectors.<Word> toList());
	}
	
	/**
	 * Lambda expression to return all words in a given category
	 * @param c
	 * @return
	 */
	public static Predicate<Word> category(Category c)
	{
		// Predicate a condition to be met
		// Lambda expressions have "ghost variables"
		// give me all the words where category matches Category c
		// w = ghost variable (Word) because of predicate
		// Matching all words that have same category as parameter c
		return w -> w.getCategory() == c;
	}
	
	/**
	 * Finds all words that start with a given prefix
	 * @param prefix  Prefix to search for
	 * @return filtered list of words
	 */
	public static Predicate<Word> startsWith(String prefix)
	{
		return w -> w.getBase().startsWith(prefix) || w.getPlural().startsWith(prefix);
	}
	
	/**
	 * Capitalizes the first character in a sentence
	 * @param word  Word to be capitalized
	 * @return
	 */
	public static String capitalize(String word)
	{
		StringBuilder capitalWord = new StringBuilder();
		return capitalWord.append(word.substring(0,1).toUpperCase() + word.substring(1)).toString();
	}
	
	/**
	 * Generates simple sentences
	 * @param dictionary Dictionary of words to generate sentences from
	 * @return
	 */
	public static String getSimpleSentences(List<Word> dictionary)
	{
		// get a list of all the nouns
		List<Word> nouns = filter(dictionary, category(Category.NOUN));
		List<Word> verbs = filter(dictionary, category(Category.VERB));
		
		List<Word> wordsBeginningWithC = filter(dictionary, startsWith("c"));
		
		StringBuilder sentences = new StringBuilder();
		for(Word noun1 : nouns)
		{
			for(Word verb : verbs)
			{
				for(Word noun2 : nouns)
				{
					sentences.append(capitalize(noun1.getBase()))
					.append(" ")
					.append(verb.getPlural())
					.append(" ")
					.append(noun2.getBase())
					.append(".\n");
					
					sentences.append(capitalize(noun1.getBase()))
					.append(" ")
					.append(verb.getPlural())
					.append(" ")
					.append(noun2.getPlural())
					.append(".\n");
					
					sentences.append(noun1.getPlural())
					.append(" ")
					.append(verb.getBase())
					.append(" ")
					.append(noun2.getBase())
					.append(".\n");
					
					sentences.append(noun1.getPlural())
					.append(" ")
					.append(verb.getBase())
					.append(" ")
					.append(noun2.getPlural())
					.append(".\n");
				}
			}
		}
		return sentences.toString();
	}

	/**
	 * Generates intermediate sentences
	 * @param dictionary Dictionary of words to generate sentences from
	 * @return  List of all intermediate sentences using all words from dictionary
	 */
	public static String getIntermediateSentences(List<Word> dictionary)
	{
		// get a list of all the nouns
		List<Word> nouns = filter(dictionary, category(Category.NOUN));
		List<Word> verbs = filter(dictionary, category(Category.VERB));
		List<Word> prepositions = filter(dictionary, category(Category.PREPOSITION));
		
		StringBuilder sentences = new StringBuilder();
		for(Word noun1 : nouns)
		{
			for(Word verb : verbs)
			{
				for(Word noun2 : nouns)
				{
					for(Word prepositon : prepositions)
					{
						for(Word noun3 : nouns)
						{
							sentences.append(noun1.getBase())
							.append(" ")
							.append(verb.getPlural())
							.append(" ")
							.append(noun2.getBase())
							.append(" ")
							.append(prepositon.getBase())
							.append(" ")
							.append(noun3.getBase())
							.append(".\n");
							
							sentences.append(noun1.getBase())
							.append(" ")
							.append(verb.getPlural())
							.append(" ")
							.append(noun2.getBase())
							.append(" ")
							.append(prepositon.getBase())
							.append(" ")
							.append(noun3.getPlural())
							.append(".\n");
							
							sentences.append(noun1.getBase())
							.append(" ")
							.append(verb.getPlural())
							.append(" ")
							.append(noun2.getPlural())
							.append(" ")
							.append(prepositon.getBase())
							.append(" ")
							.append(noun3.getBase())
							.append(".\n");
							
							sentences.append(noun1.getBase())
							.append(" ")
							.append(verb.getPlural())
							.append(" ")
							.append(noun2.getPlural())
							.append(" ")
							.append(prepositon.getBase())
							.append(" ")
							.append(noun3.getPlural())
							.append(".\n");
							
							sentences.append(noun1.getPlural())
							.append(" ")
							.append(verb.getBase())
							.append(" ")
							.append(noun2.getBase())
							.append(" ")
							.append(prepositon.getBase())
							.append(" ")
							.append(noun3.getBase())
							.append(".\n");
							
							sentences.append(noun1.getPlural())
							.append(" ")
							.append(verb.getBase())
							.append(" ")
							.append(noun2.getBase())
							.append(" ")
							.append(prepositon.getBase())
							.append(" ")
							.append(noun3.getPlural())
							.append(".\n");
							
							sentences.append(noun1.getPlural())
							.append(" ")
							.append(verb.getBase())
							.append(" ")
							.append(noun2.getPlural())
							.append(" ")
							.append(prepositon.getBase())
							.append(" ")
							.append(noun3.getPlural())
							.append(".\n");
							
							sentences.append(noun1.getPlural())
							.append(" ")
							.append(verb.getBase())
							.append(" ")
							.append(noun2.getPlural())
							.append(" ")
							.append(prepositon.getBase())
							.append(" ")
							.append(noun3.getBase())
							.append(".\n");
						}
					}
				}
			}
		}
		return sentences.toString();
	}
}
