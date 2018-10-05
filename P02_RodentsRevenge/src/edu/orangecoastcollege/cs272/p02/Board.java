package edu.orangecoastcollege.cs272.p02;

import java.util.*;

/**
 * Class for Rodent's Revenge Game Board
 * @author Brett Tomita
 *
 */
public class Board 
{
	Player mPlayer;
	List<Rodent> mRodentsList = new ArrayList<Rodent>();
	List<Pellet> mPelletsList = new ArrayList<Pellet>();
	/**
	 * Stores number of rows on board
	 */
	protected int mRowSize;
	/**
	 * Stores number of columns on board
	 */
	protected int mColSize;
	
	/**
	 * Constructor for board at start of game
	 * @param rowSize how many rows on board
	 * @param colSize how many columns on board
	 * @param numRodents  Initial number of rodents
	 */
	public Board(int rowSize, int colSize, int numRodents)
	{
		super();
		this.mRowSize = rowSize;
		this.mColSize = colSize;
		
		Player player = new Player(mRowSize - 1, mColSize - 1);
		mPlayer = player;
		int rodentRow = 0;
		while(numRodents > 0)
		{
			for(int rodentCol = 0; rodentCol < this.mColSize; rodentCol++)
			{
				Rodent rodent = new Rodent(rodentRow, rodentCol);
				mRodentsList.add(rodent);
				numRodents--;
				if(numRodents == 0) break;
				if(!this.isInBounds(rodentRow, rodentCol))
				{
					if(rodentRow == this.mRowSize) rodentRow = 0;
					if(rodentCol == this.mColSize) rodentCol = 0;
				}
			}
			rodentRow++;


		}
	}
	
	/**
	 * Returns number of rows on board
	 * @return number of rows
	 */
	public int getRowSize()
	{
		return mRowSize;
	}
	
	/**
	 * Returns number of columns on board
	 * @return columns
	 */
	public int getColSize()
	{
		return mColSize;
	}
	
	/**
	 * Adds a pellet to the board at specified location
	 * @param row row pellet is on
	 * @param col column pellet is on
	 */
	public void addPellet(int row, int col)
	{
		Pellet pellet = new Pellet(row, col);
		mPelletsList.add(pellet);
	}
	
	/**
	 * Checks if a row and column is in bounds of game board
	 * @param row row to be checked
	 * @param col column to be checked
	 * @return true if in bounds; false if not
	 */
	public boolean isInBounds(int row, int col)
	{
		if((row >= 0 && col >= 0) && (row < mRowSize && col < mColSize))
			return true;
		return false;
	}
	
	/**
	 * Checks if player is alive
	 * @return true if player is alive; false if dead
	 */
	public boolean isPlayerAlive()
	{
		if(mPlayer == null) return false;
		return true;
	}
	
	/**
	 * Checks if game is over
	 * @return true if game is over; otherwise false
	 */
	public boolean isGameOver()
	{
		if(isPlayerAlive() == false) return true;
		if(mRodentsList.size() == 0) return true;
		return false;
	}
	
	/**
	 * Moves player and all rodents, kills rodents and removes pellets and/or kills player if applicable
	 */
	public void moveAllCharacters()
	{
		mPlayer.move(this);
		
		for(Iterator<Rodent> rodents = mRodentsList.iterator(); rodents.hasNext(); )
		{
			Rodent rodent = rodents.next();
			rodent.move(this);
			if(rodent.getCol() == mPlayer.getCol() && rodent.getRow() == mPlayer.getRow())
			{
				mPlayer = null;
				break;
			}
			
			for(Iterator<Pellet> pellets = mPelletsList.iterator(); pellets.hasNext();)
			{
				Pellet pellet = pellets.next();
				if(rodent.getCol() == pellet.getCol() && rodent.getRow() == pellet.getRow())
				{
					rodents.remove();
					pellets.remove();
					break;
				}
			}
		}
	}
	
	/**
	 * Counts how many rodents are at a specified row and column
	 * @param mRodentsList Searches through this list of rodents
	 * @param row row to search for rodents
	 * @param col column to search for rodents
	 * @return number of rodents at given location
	 */
	public int countRodents(List<Rodent> mRodentsList, int row, int col)
	{
		int count = 0;
		for(Rodent rodent : mRodentsList)
		{
			if(rodent.getRow() == row && rodent.getCol() == col) count++;
		}
		return count;
	}
	
	/**
	 * Checks if pellet is at a specified location
	 * @param pelletsList List of pellets searched through
	 * @param row row to search for pellets
	 * @param col column to search for pellets
	 * @return true if pellet is at given location; false if not
	 */
	public boolean isPellet(List<Pellet> pelletsList, int row, int col)
	{
		boolean result = false;
		
		for(Pellet pellet : pelletsList)
		{
			if(pellet.getRow() == row && pellet.getCol() == col)
			{
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * Prints out the game board with player, rodents, and pellets
	 */
	@Override
	public String toString()
	{
		String result = "";
		for(int row = 0; row < mRowSize; row++)
		{
			for(int col = 0; col < mColSize; col++)
			{
				if(mPlayer == null) continue;
				if(mPlayer.getRow() == row && mPlayer.getCol() == col) 
				{
					result += mPlayer;
					continue;
				}
				int rodents = this.countRodents(mRodentsList, row, col);
				if(rodents != 0)
				{
					result += (rodents == 1) ? "R" : rodents;
					continue;
				}
				if(this.isPellet(mPelletsList, row, col)) 
				{
					result += "*";
					continue;
				}
				result += ".";
			}
			result+="\n";
		}
		
		int rodentsLeft = mRodentsList.size();
		result += "\n" + rodentsLeft + " rodents left to evict.";
		
		return result;
	}
}
