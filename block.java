/**
 * @author leanprakort
 * @date 25/11/2018
 * @ID 104932087
 * @assignemnt 3 TicTacToe
 * Class block: represents a block that user will put X or O 
 * it has state O is empty , 1 is X , 2 is O
 */
public class block implements global {
	
	private int state;
	
	/**
	 * default constructor 
	 */
	public block()
	{
		this.state = EMPTY;
	}
	
	/**
	 * set state method to set each block 
	 * @param input
	 * @return boolean
	 */
	public boolean putState(int input)
	{
		if ( input == X || input ==O)
		{
			this.state = input;
			return true;
		}
		else 
			return false;
	}
	/**
	 * access method to get state
	 * @return state
	 */
	public int getState()
	{
		return this.state;
	}
	/**
	 * toString method
	 * return String 
	 */
	public String toString()
	{
		if (this.state ==O)
			return "O";
		else if ( this.state ==X)
			return "X";
		else 
			return " ";
	}

	
}
