package demo;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoveController {

    private final AtomicLong counter = new AtomicLong();

//    @RequestMapping("/move")
//    public Move move(@RequestParam String x, @RequestParam String y) {
//    	String xPos = x;
//    	String yPos = y;
//    	
//    	
//        return new Move(1,
//                            "xPos: " + xPos + " yPos: " + yPos);
//    }
    
    
}
