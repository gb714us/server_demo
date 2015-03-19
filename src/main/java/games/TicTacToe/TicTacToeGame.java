package games.TicTacToe;

import games.AbstractClasses.*;

public class TicTacToeGame extends Game{
	
	TicTacToeLogic logic;
	State state;
	
	public TicTacToeGame()
	{
		state = new State();
		logic = new TicTacToeLogic(state);
	}
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