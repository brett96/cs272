package edu.orangecoastcollege.cs272.p02;
import java.util.Random;

/**
 * Class for rodent character which inherits from Character
 * @author Brett Tomita
 *
 */
public class Rodent extends Character 
{
	/**
	 * Constructor for Rodent character
	 * @param mRow Row rodent is on
	 * @param mCol Column rodent is on
	 */
	protected Rodent(int mRow, int mCol) {
		super(mRow, mCol);
		// TODO Auto-generated constructor stub
	}

	Random random = new Random();
	/**
	 * Moves Rodent in random direction
	 * If direction were to go out of the bounds of the board, the rodent will travel through the walls 
	 * in the generated direction, and will arrive at the opposite side of the room
	 * @param board
	 */
	public void move(Board board)
	{
		// Move rodent randomly: generate random row: randomly generate row/col
		/*
		 * 1 = up
		 * 2 = down
		 * 3 = left
		 * 4 = right
		 * 5 = diagonal up left
		 * 6 = diagonal up right
		 * 7 = diagonal down left
		 * 8 = diagonal down right
		 */
		
		int direction = random.nextInt(8) + 1;
		switch(direction)
		{
		case 1:
			if(this.getRow() <= 0) this.setRow(board.getRowSize() - 1);
			else this.setRow(this.getRow() - 1);
			break;
			
		case 2:
			if(this.getRow() + 1 >= (board.getRowSize())) this.setRow(0);
			else this.setRow(this.getRow() + 1);
			break;
			
		case 3:
			if(this.getCol() <= 0) this.setCol(board.getColSize() - 1);
			else this.setCol(this.getCol() - 1);
			break;
			
		case 4:
			if(this.getCol() + 1 >= (board.getColSize())) this.setCol(0);
			else this.setCol(this.getCol() + 1);
			break;
			
		case 5:
			if(this.getRow() <= 0) this.setRow(board.getRowSize() - 1);
			else this.setRow(this.getRow() - 1);
			if(this.getCol() <= 0) this.setCol(board.getColSize() - 1);
			else this.setCol(this.getCol() - 1);
			break;
			
		case 6:
			if(this.getRow() <= 0) this.setRow(board.getRowSize() - 1);
			else this.setRow(this.getRow() - 1);
			if(this.getCol() + 1 >= (board.getColSize())) this.setCol(0);
			else this.setCol(this.getCol() + 1);
			break;
			
		case 7:
			if(this.getRow() + 1 >= (board.getRowSize())) this.setRow(0);
			else this.setRow(this.getRow() + 1);
			if(this.getCol() <= 0) this.setCol(board.getColSize() - 1);
			else this.setCol(this.getCol() - 1);
			break;
			
		case 8:
			if(this.getRow() + 1 >= (board.getRowSize())) this.setRow(0);
			else this.setRow(this.getRow() + 1);
			if(this.getCol() + 1 >= (board.getColSize())) this.setCol(0);
			else this.setCol(this.getCol() + 1);
			break;
		}
	}
	
	/**
	 * Prints the rodent icon as a String
	 */
	@Override
	public String toString()
	{
		return"R";
	}
	
}
