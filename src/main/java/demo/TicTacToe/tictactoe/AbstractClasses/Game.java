package demo.TicTacToe.tictactoe.AbstractClasses;

public abstract class Game {
	public int gameID;
	public State state;
	public Logic logic;
	
	public abstract void initializeGame();
	
}
