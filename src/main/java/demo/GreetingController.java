package demo;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.TicTacToe.tictactoe.AbstractClasses.Game;
import demo.TicTacToe.tictactoe.AbstractClasses.Logic;
import demo.TicTacToe.tictactoe.ConcreteClasses.TicTacToeGame;
import demo.TicTacToe.tictactoe.ConcreteClasses.TicTacToeLogic;

@RestController
public class GreetingController {

	private TicTacToeGame game;
    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	
    	try {
			game = new TicTacToeGame();
			game.initializeGame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new Greeting(1,
                            String.format(template, name));
    }
    
    @RequestMapping("/move")
    public Move move(@RequestParam String x, @RequestParam String y) {
    	String xPos = x;
    	String yPos = y;
    	
    	game.logic.fillBoard();
    	String result = game.logic.placePiece(Integer.parseInt(x), Integer.parseInt(y));
        return new Move(1, result);
    }
}
