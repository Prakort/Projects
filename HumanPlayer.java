/**
 * @author leanprakort
 * @date 25/11/2018
 * @ID 104932087
 * @assignemnt 3 TicTacToe
 * HumanPlayer is class extends from player that input will be scanned from user
 * Human player has a name, game board and state ( 1 = X or 2=O) 
 */
import java.util.*;
public class HumanPlayer extends player implements global{

	/**
	 * overloading constructor
	 * @param game
	 * @param number
	 * @param name
	 */
	public HumanPlayer(board game, int number, String name) {
		super(game, number, name);	// call overloading constructor in player 
		
	}
	
	Scanner sc = new Scanner(System.in);

	@Override
	public void play(board game) {
		
		gameBoard = game;
		boolean done = false;
		while (!done)		// player must enter until it is a valid move
		{
			game.displayByPlayer();	// display the board for player
			
			if(!game.makeMove(sc.nextInt(),playerSymbol))
				System.out.println("Invalid Move!!! select available block :\n");
			else 
				done = true;	// exit the loop
		}
		
	}

	/**
	 * toString: return a string for display when needed
	 */
	public String toString() {
	
		return "I have made my move!! Yours Turn !!";
	}

}
