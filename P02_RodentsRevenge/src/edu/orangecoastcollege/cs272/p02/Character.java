package edu.orangecoastcollege.cs272.p02;

/**
 * Abstract class for game characters
 * @author Brett Tomita
 *
 */
public abstract class Character 
{
	/**
	 * Row character is on
	 */
	protected int mRow;
	/**
	 * Column character is on
	 */
	protected int mCol;
	
	/**
	 * Returns row character is on
	 * @return row
	 */
	public int getRow() 
	{
		return mRow;
	}
	
	/**
	 * Sets character on specified row
	 * @param row
	 */
	public void setRow(int row) 
	{
		mRow = row;
	}
	
	/**
	 * Returns column character is on
	 * @return column
	 */
	public int getCol() 
	{
		return mCol;
	}
	
	/**
	 * Sets character on specified column
	 * @param col column
	 */
	public void setCol(int col) 
	{
		mCol = col;
	}
	
	protected Character(int mRow, int mCol)
	{
		super();
		this.mRow = mRow;
		this.mCol = mCol;
	}
	
	/**
	 * Generates hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mCol;
		result = prime * result + mRow;
		return result;
	}
	
	/**
	 * Checks if two characters are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		if (mCol != other.mCol)
			return false;
		if (mRow != other.mRow)
			return false;
		return true;
	}
}
