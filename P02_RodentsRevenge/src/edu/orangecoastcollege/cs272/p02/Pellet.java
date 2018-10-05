package edu.orangecoastcollege.cs272.p02;

/**
 * Class for Pellet character which inherits from character
 * @author Brett Tomita
 *
 */
public class Pellet extends Character 
{
	
	protected Pellet(int mRow, int mCol) {
		super(mRow, mCol);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Blank method to move pellet.  Does nothing because a pellet cannot move
	 * @param board
	 */
	public void move(Board board)
	{
		
	}

	/**
	 * Prints Pellet icon as a string
	 */
	@Override
	public String toString() 
	{
		return "*";
	}
	
	
}
