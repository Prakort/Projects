/**
 * @author leanprakort
 * @date 25/11/2018
 * @ID 104932087
 * @assignemnt 3 TicTacToe
 * Class game implement global: this class contains method start() to star the game
 */

import java.util.*;
public class game implements global{
	
	private int turn ;				
	private boolean done = true;
	private boolean start = true;
	private String name1; 	// temp string to store name ( no setter/getter)
	private String name2;	// temp string to store name ( no setter/getter)
	board gameBoard;
	player playerO;
	player playerX;
	
	Scanner sc = new Scanner(System.in);
	
	/**
	 * default constructor 
	 */
	public game() {
		
		gameBoard = new board();
		
		while (done)
		{
			System.out.println("Enter : [1] Player vs Player [2] Player vs AI");
			int i  = sc.nextInt();
			sc.nextLine();
			
			if ( i == 1 )
			{
				System.out.println("[X]-player name : ");
				name1 = sc.next();
				System.out.println("[O]-player name : ");
				name2 = sc.next();
				
				playerX = new HumanPlayer(gameBoard, X, name1);
				playerO = new HumanPlayer(gameBoard, O, name2);	
				
				done = false;
			}
			else if (i == 2)
			{
				System.out.println("[X]-player name : ");
				name1 = sc.next();
				System.out.println("[O]-AI name : ");
				name2 = sc.next();
				
				playerX = new HumanPlayer(gameBoard, X, name1);
				playerO = new AIPlayer(gameBoard, O, name2);
				
				done = false;
			}
				
			System.out.println("Invalid selction");
		}
		
		
	}
	/**
	 * start method to start the game 
	 */
	public void start()
	{
		int rand = Rand();			// generate a random turn for players
		
		System.out.println(".......The Dice is rolling.......\n.\n.\n.");
		if ( rand % 2==0)
		{	
			turn =X;
	
			System.out.println("[X] Player start first !!!");
		}	
		else 
		{
			turn = O;
			System.out.println("[O] Player start first !!!");
		}
		
		
		System.out.println("\n::::: GAME START :::::\n");
		
		while (start)
		{
			if (turn == X && gameBoard.getState()==EMPTY)
			{
				System.out.println("[X] Player :: "+playerX.playerName +" :: Please make your move\n");
				playerX.play(gameBoard); // player x make a move
				turn = O;				// next it  is player o turn 
			}
			else if ( turn == O && gameBoard.getState()==EMPTY)
			{
				System.out.println("[O] Player :: "+playerO.playerName +" :: Please make your move\n");
				playerO.play(gameBoard);
				turn = X;
			}
			if ( gameBoard.getState()!=EMPTY)
			{
				start = false;		// state is not 0 that mean someone wins stop the game!
				break;
			}
			
		}
		
		gameBoard.displayBoard(); // display the whole board 
		
		if (gameBoard.getState()==X)
			System.out.println(playerX.playerName +" [X] Win !! Congrats!!");
		else if (gameBoard.getState()==O)
			System.out.println(playerO.playerName +" [O] Win !! Congrats!!");
		else
			System.out.println(playerX.playerName+" vs "+playerO.playerName+" is a DRAW !!");
		
		System.out.println("\n::::: GAME END :::::");
	}
	/**
	 * Rand method : generate a random number 
	 * @return integer 
	 */
	public static int Rand()
	{
		Random num = new Random();
		return num.nextInt(100);
	}
}
