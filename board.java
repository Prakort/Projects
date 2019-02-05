/**
 * @author leanprakort
 * @date 25/11/2018
 * @ID 104932087
 * @assignemnt 3 TicTacToe
 * Class board : A  game board that has 9 blocks as standard tictactoe game 
 * It has state of X wins 1, O wins 2, Draw 3, Empty 0
 * It contains methods to check each row, column, diagonal and draw to find who has won the game
 */
public class board implements global {
	
	public  block[][] blocks;
	private int state = EMPTY;
	private int row=3;
	private int col=3;
	
	/**
	 * default constructor 
	 * instantiate each block on board to be an object of block class
	 */
	public board()
	{
		blocks = new block[row][col];
		
		for ( int i:index)
			for (int j:index)
				blocks[i][j]= new block();
			
	}
	/**
	 * makeMove : method to put X or O in a block has to be valid
	 * @param a which block
	 * @param b  ( 1 or 2 ) X or O
	 * @return boolean
	 */
	public boolean makeMove(int a , int b)

	{
		int row =0;		// temp index for row
		int col = 0;	// temp index for column
			
		
		switch (a)		// from input 1 to 9 , get that index in 2D array
		{
		case 1: row =0;col=0;break;		
		case 2: row =0;col=1;break;
		case 3: row =0;col=2;break;
		case 4: row =1;col=0;break;
		case 5: row =1;col=1;break;
		case 6: row =1;col=2;break;
		case 7: row =2;col=0;break;
		case 8: row =2;col=1;break;
		case 9: row =2;col=2;break;
		}
		
		if ( a > 9 || a < 1)
			return false;	// if not in the range, return false
		if ( blocks[row][col].getState()==EMPTY)// if the block is empty , put that state ( 1 or 2)
		{
			blocks[row][col].putState(b);
			return true;
		}
		else 
			return false;
		
		
}	
	/**
	 * access method to get the state of the board to find the Winner
	 * @return 0 or 1 or 2 or 3
	 */
	public int getState()
	{
		
		if ( checkDiagonals() != EMPTY)		// if the Diagonals is not zero , X or O wins 
			return checkDiagonals();	// return Winner
		
		for ( int i: index)				
		{
			if ( checkRow(i)!=EMPTY)		// check each row to find winner
				return checkRow(i);
			if ( checkCol(i)!=EMPTY)		// check each column to find winner
				return checkCol(i);
		}
		if ( checkDraw() != EMPTY)			// if the draw is not zero 
		{
			return checkDraw();			// return 3 means DRAW
		}	
			
		return 0;
		
	}
	/**
	 * checkDraw : if the game is draw
	 * @return
	 */
	public int checkDraw()
	{
		for ( int i : index)
		{
			for ( int j: index)
			{
				if (blocks[i][j].getState()==EMPTY) // if it is empty return 0;
					return 0;
			}
		}
		return 3; // return draw only if there is no empty block , X and O filled the board
				
	}
	/**
	 * checkRow : check from the first block of the row 
	 * @param row 
	 * @return state of the row
	 */
	public int checkRow(int row)
	{
		int x = blocks[row][0].getState();
		if ( x !=0)
		{
			if(compareBlock(row,0,row,1)&&compareBlock(row,1,row,2)) // compare each block  in that row
				return x;
		}
		return 0;
	}
	/**
	 * checkCol : check from the first block of that column
	 * @param col
	 * @return 0 or 1 or 2
	 */
	public int checkCol(int col)
	{
		int x= blocks[0][col].getState();
		if ( x !=0)
		{
			if(compareBlock(0,col,1,col)&&compareBlock(1,col,2,col)) // compare each block in tht column
				return x;
		}
		return 0;
	}
	/**
	 * checkDiagonals  : check if  X or O wins
	 * @return 0 or 1 or 2
	 */
	public int checkDiagonals()
	{
		int x = blocks[0][0].getState();// first diagonal 
		int y = blocks[2][0].getState();// second diagonal
		
		if ( x!=0) // have to check only if first block of the first diagonal is not empty
		{
			if ( compareBlock(0,0,1,1)&&compareBlock(1,1,2,2))
				return x;
		}
		if ( y!=0) // have to check only if first block of the second diagonal is not empty
		{
			if ( compareBlock(0,2,1,1)&&compareBlock(1,1,2,0))
				return y;
		}
			
		return 0;
		
	}
	/**
	 * compareBloack : compare the state of the each block
	 * @param row1
	 * @param col1
	 * @param row2
	 * @param col2
	 * @return boolean
	 */
	public boolean compareBlock(int row1, int col1, int row2, int col2)
	{
		return (blocks[row1][col1].getState()==blocks[row2][col2].getState()); // compare the state of 2 blocks
	}
	/**
	 * displayBoard : display the whole board
	 */
	public void displayBoard()
	{
		for ( int i: index)
		{
			for ( int j: index)
			{
				System.out.print(blocks[i][j].toString());  // display only X and O
				if (j!=2)
					System.out.print("|");
			}
			System.out.println("\n");
		}
	}
	/**
	 * display the board for the player turn
	 */
	public void displayByPlayer()
	{
		int counter =1;
		for ( int i: index)
		{
			for ( int j: index)
			{
				if (blocks[i][j].getState()==EMPTY)
					System.out.print(counter);		// display 1 to 9 where it is empty
				else 
					System.out.print(blocks[i][j].toString());	// display X and O
				if (j!=2)
					System.out.print("|");
				counter++;
			}
			System.out.println("\n");
		}
	}
	
	
}
