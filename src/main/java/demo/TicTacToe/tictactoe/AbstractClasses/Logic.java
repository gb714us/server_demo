package demo.TicTacToe.tictactoe.AbstractClasses;

import java.util.ArrayList;

public abstract class Logic {
	State state;
	
	public ArrayList<Location> getLegalMoves(Player p){
		return new ArrayList<Location>();
	}
	
	public void placePiece(GameObject obj, Location l, State s){
		
	}
	
	public void updateState(State s){
		
	}
	
	
}
