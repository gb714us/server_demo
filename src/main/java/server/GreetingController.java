package server;

import games.AbstractClasses.Game;
import games.TicTacToe.TicTacToeGame;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private HashMap<String, Game> gameList = new HashMap<String, Game>();
	private int gameCounter = 0;
    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	
//    	game = new TicTacToeGame();
//		game.initializeGame();
        return new Greeting(1,
                            String.format(template, name));
    }
    
    @RequestMapping("/move")
    public Move move(@RequestParam String x, @RequestParam String y, @RequestParam(value="id") String gameId) {
    	Game game = gameList.get(gameId);
 
//    	Game game = gameInstance;
    	
    	String result = game.getLogic().placePiece(Integer.parseInt(x), Integer.parseInt(y));
    	String[][] gameState = game.getLogic().getBoard();
    	
    	System.out.println(result);
    	
    	for (int i = 0; i < gameState.length; i++)
    	{
    		for (int j = 0; j < gameState[i].length; j++)
    		{
    			System.out.println(gameState[i][j]);
    		}
    	}
    	return new Move(gameState, result, "1");
    }
    
    @RequestMapping("/findgame")
	public Matchmaking findgame(@RequestParam(value="game", defaultValue="") String game, 
			@RequestParam(value="user", defaultValue="") String user) {
		int userid = 123;
		String opponentID = "";
		String gameID = "";
		String[][] gameState = null;
		
		SqlCommand.createGameRequest(game, user);
		List<String> listOfGames = SqlCommand.retrieveListOfGameRequests(game, user);
		while (listOfGames.size() == 0) { // if no games available, check every 1 second
//			Time.sleep(1000);
			listOfGames = SqlCommand.retrieveListOfGameRequests(game, user);
		}
		System.out.println("Match found! Initiating game state");
		opponentID = listOfGames.get(0);
		if (gameCounter % 2 == 0) {
			gameCounter++;
		}
		gameID = String.valueOf(gameCounter);
		System.out.println(gameCounter + " " + gameID);
		
		if (game.equals("TicTacToe")) {
			Game gameInstance = new TicTacToeGame();
			gameInstance.initializeGame();
			gameList.put(gameID, gameInstance);
			gameState = gameInstance.getLogic().getBoard();
			for (int row = 0; row < 3; row++) {
				for (int col = 0; col < 3; col++)
					System.out.print(gameState[row][col] + "  ");
				System.out.println();
			}
			
			// put user into matchmaking for tictactoe
		} else if (game.equals("Battleship")) {
//			Game gameInstance = new TicTacToeGame();
//			gameInstance.initializeGame();
//			gameList.put(gameID, gameInstance);
//			gameState = gameInstance.getLogic().getBoard();
//			for (int row = 0; row < 3; row++) {
//				for (int col = 0; col < 3; col++)
//					System.out.print(gameState[row][col] + "  ");
//				System.out.println();
			
			// put user into matchmaking for battleship
		} else if (game.equals("Othello")) {
//			Game gameInstance = new TicTacToeGame();
//			gameInstance.initializeGame();
//			gameList.put(gameID, gameInstance);
//			gameState = gameInstance.getLogic().getBoard();
//			for (int row = 0; row < 3; row++) {
//				for (int col = 0; col < 3; col++)
//					System.out.print(gameState[row][col] + "  ");
//				System.out.println();
		}
			// put user into matchmaking for othello
		
		SqlCommand.removeFromUserTable(user);
		SqlCommand.removeGameRequest(game, user);


		return new Matchmaking(gameID, opponentID, gameState);
	}

}
