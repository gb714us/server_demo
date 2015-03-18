package demo.TicTacToe.tictactoe.ConcreteClasses;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import demo.TicTacToe.tictactoe.AbstractClasses.*;

public class TicTacToeGame extends Game{
	private Socket socket;
    private ServerSocket serverSocket;
    public TicTacToeLogic logic;

    public TicTacToeGame() throws IOException
    {
    	
    }
	public void initializeGame(){
		state = new State();
		state.initializeBoard(3,3);
		
		logic = new TicTacToeLogic(state);
		
//		logic.start();
	}
	
	public void start(){
		
	}
	
}
