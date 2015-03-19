package server;

public class Move {

	private String[][] gameState;
	private String currentStatus;
	private String currentTurn;
	public Move(String[][] gameState, String currentStatus, String currentTurn)
	{
		this.gameState = gameState;
		this.currentStatus = currentStatus;
		this.currentTurn = currentTurn;
	}
	public String[][] getGameState() {
		return gameState;
	}
	public void setGameState(String[][] gameState) {
		this.gameState = gameState;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getCurrentTurn() {
		return currentTurn;
	}
	public void setCurrentTurn(String currentTurn) {
		this.currentTurn = currentTurn;
	}

    
	
}
