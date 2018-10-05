package edu.orangecoastcollege.cs272.p02;

import java.util.Scanner;

/**
 * Class for Player character which inherits from Character
 * @author Brett Tomita
 *
 */
public class Player extends Character 
{
	/**
	 * Constructor for player
	 * @param mRow Row player is on
	 * @param mCol Column Player is on
	 */
	protected Player(int mRow, int mCol) {
		super(mRow, mCol);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Moves player in specified direction on board if movement in that direction is allowed
	 * If movement is not allowed in that direction, player does not move and loses their turn
	 * @param board
	 */
	public void move(Board board)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("What action would you like the player to take? \nU: Move up"
				+ "\nD: Move Down\nL: Move Left\nR: Move Right\nP: Pellet\n");
		char choice = input.next().toLowerCase().charAt(0);
		if(choice == 'u')
		{
			if(this.mRow == 0) 
			{
				System.err.println("Player cannot currently move up and loses a turn.");
			}
			else
			{
				this.setRow(this.getRow() - 1);
			}
		}
		else if(choice == 'd')
		{
			if(board.mRowSize-1 == this.mRow) 
			{
				System.err.println("Player cannot currently move down and loses a turn.");
			}
			else
			{
				this.setRow(this.getRow() + 1);
			}
		}
		else if(choice == 'l')
		{
			if(this.mCol == 0) 
			{
				System.err.println("Player cannot currently move left and loses a turn.");
			}
			else
			{
				this.setCol(this.getCol() - 1);
			}
		}
		else if(choice == 'r')
		{
			if(this.mCol == board.mColSize-1) 
			{
				System.err.println("Player cannot currently move right and loses a turn.");
			}
			else
			{
				this.setCol(this.getCol() + 1);
			}
		}
		else if(choice == 'p')
		{
			Pellet pellet = new Pellet(this.mRow, this.mCol);
			pellet.setRow(this.getRow());
			pellet.setCol(this.getCol());
			board.mPelletsList.add(pellet);
		}
		else
			System.err.println("Unrecognized action, please enter U, D, L, R, or P.  Player loses turn");
	}
	
	/**
	 * Prints player icon as a String
	 */
	@Override
	public String toString()
	{
		return "P";
	}
}
