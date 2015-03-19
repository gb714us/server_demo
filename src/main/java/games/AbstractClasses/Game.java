package games.AbstractClasses;

import games.TicTacToe.TicTacToeLogic;

public abstract class Game {
	public int gameID;
	public State state;
	public Logic logic;
	
	public abstract void initializeGame();

	public abstract Logic getLogic();
}