package server;

public class Matchmaking {
    private final String gameID;
    private final String[][] gameState;

    public Matchmaking(String gameID, String[][] gameState) 
    {
        this.gameID = gameID;
        this.gameState = gameState;
    }

    public String getGameId() {
        return gameID;
    }

	public String[][] getGameState() {
		return gameState;
	}
}
