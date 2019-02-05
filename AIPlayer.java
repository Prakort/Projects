/**
 * @author leanprakort
 * @date 25/11/2018
 * @ID 104932087
 * @assignemnt 3 TicTacToe
 * Class AI player : AI will only make a random move from available block 
 */
import java.util.Random;

public class AIPlayer extends player implements global {

	/**
	 * overloading constructor
	 * @param game
	 * @param number
	 * @param name
	 */
	public AIPlayer(board game, int number, String name) {
		super(game, number, name);
		
	}
	
	@Override
	public void play(board game) {
		
		int[] ValidIndex= new int[9]; 
		int counter =0;
		Random rand = new Random();
	
		for ( int i : index)
		{
			for ( int j : index)
			{
				if ( gameBoard.blocks[i][j].getState()==EMPTY)
				{
					ValidIndex[counter++]=(3*i+1+j);	// store available block into an array
					
				}
			}
		}
		
		int i = ValidIndex[rand.nextInt(counter)]; // get a random block and make a move
		gameBoard.displayByPlayer();
		gameBoard.makeMove(i, playerSymbol);		// since index is always valid, so will makeMove
		System.out.println("Just a random move !!!\n");
	
	}
	/**
	 * toString: return a string 
	 */
	public String toString() {
		return " AI is your opponent ";
	}

}
