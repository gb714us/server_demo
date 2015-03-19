package games.TicTacToe;

import games.AbstractClasses.*;

public class TicTacToeGame extends Game{
	
	TicTacToeLogic logic;
	public void initializeGame(){
		state = new State();
		state.initializeBoard(3,3);
		
	    logic = new TicTacToeLogic(state);
		
		logic.start();
	}
	
	public void start(){
		
	}
	
	public TicTacToeLogic getLogic()
	{
		return logic;
	}
	
}