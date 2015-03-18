package demo.TicTacToe.tictactoe.AbstractClasses;

public class Board {
	GameObject[][] board;
			
	Board(int cols, int rows){
		board = new GameObject[cols][rows];
	}
	
}
