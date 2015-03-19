package server;

import java.io.IOException;

import games.AbstractClasses.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.tomcat.jni.Time;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import games.TicTacToe.*;

@RestController
public class GreetingController {
	private HashMap<String, Game> gameList;
	private TicTacToeGame gameInstance;
    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	
//    	game = new TicTacToeGame();
//		game.initializeGame();
        return new Greeting(1,
                            String.format(template, name));
    }
    
    @RequestMapping("/move")
    public Move move(@RequestParam String x, @RequestParam String y, @RequestParam String gameId) {
//    	Game game = gameList.get(gameId);
    	Game game = gameInstance;
    	
    	String result = game.getLogic().placePiece(Integer.parseInt(x), Integer.parseInt(y));
    	String[][] gameState = game.getLogic().getBoard();
    	return new Move();
    }
    
    @RequestMapping("/findgame")
	public Matchmaking findgame(@RequestParam(value="game", defaultValue="") String game, 
			@RequestParam(value="user", defaultValue="") String user) {
		// TODO: make this come as a parameter
		int userid = 123;
		String gameID = "";
		String[][] gameState = null;
		
		SqlCommand.createGameRequest(game, user);
		List<String> listOfGames = SqlCommand.retrieveListOfGameRequests(game, user);
		while (listOfGames.size() == 0) { // if no games available, check every 1 second
//			Time.sleep(1000);
			listOfGames = SqlCommand.retrieveListOfGameRequests(game, user);
		}
		System.out.println("Match found! Initiating game state");
		gameID = listOfGames.get(0);
		
		if (game.equals("TicTacToe")) {
			gameInstance = new TicTacToeGame();
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
			// put user into matchmaking for battleship
		} else if (game.equals("Othello")) {
			// put user into matchmaking for othello
		}


		return new Matchmaking(gameID, gameState);
	}
}
