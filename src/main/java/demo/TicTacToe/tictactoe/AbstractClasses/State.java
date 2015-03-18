package demo.TicTacToe.tictactoe.AbstractClasses;

public class State {
	public Board board;
	public  Player winner = null;
	public boolean gameEnd = false;
	public Player turn;
	public Player player1;
	public Player player2;
	
//	public void checkState(){
//		endGame = true;
//	}
	
	public void initializeBoard(int rows, int cols){
		board = new Board(rows,cols);
	}
}
