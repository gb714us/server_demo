package server;

public class Matchmaking {
    private String gameID;
    private String opponentID;
    private String[][] gameState;

    public Matchmaking(String gameID, String opponentID, String[][] gameState) 
    {
        this.gameID = gameID;
        this.opponentID = opponentID;
        this.gameState = gameState;
    }

    public String getGameID() {
        return gameID;
    }

	public String[][] getGameState() {
		return gameState;
	}
	 
	public String getOpponentID() 
	{
			return opponentID;
		}

		

}
