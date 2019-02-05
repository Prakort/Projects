/**
 * @author leanprakort
 * @date 25/11/2018
 * @ID 104932087
 * @assignemnt 3 TicTacToe
 * Player is an abstract class that has gameBoard, playerName, playerSymbol(1 or 2)
 * and has an abstract method play();
 */
public abstract class player {

	protected board gameBoard;
	protected String playerName;
	protected int playerSymbol;
	
	/**
	 * overloading constructor
	 * @param game
	 * @param number
	 * @param name
	 */
	
	public player(board game , int number,String name)
	{
		gameBoard = game;
		setPlayerSymbol(number);
		setPlayerName(name);
		
	}
	// abstract method
	public abstract void play(board game);
	/**
	 * access method: getGameBoard
	 * @return gameBoard
	 */
	public board getGameBoard() {
		return gameBoard;
	}

	/**
	 * set method to set gameBoard
	 * @param gameBoard
	 */
	public void setGameBoard(board gameBoard) {
		this.gameBoard = gameBoard;
	}
	/**
	 * access method to get player name
	 * @return playerName
	 */
	public String getPlayerName() {
		return playerName;
	}
	/**
	 *  set method to set player name
	 * @param playerName
	 */
	public void setPlayerName(String playerName) {
		if ( playerName.length()>0)
			this.playerName = playerName;
	
	}

	/**
	 * access method to set player symbol 
	 * @return player symbol
	 */
	public int getPlayerSymbol() {
		return playerSymbol;
	}

	/**
	 * set method to set player sybmbol
	 * @param playerSymbol
	 */
	public void setPlayerSymbol(int playerSymbol) {
		if (playerSymbol ==1 || playerSymbol==2)
		this.playerSymbol = playerSymbol;
	}
	
}
