package FirstAttempt;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;

public class DesignSnakeGame {

	// https://discuss.leetcode.com/topic/48626/java-deque-and-hashset-design-with-detailed-comments
	Deque<Integer> body;
	int[][] food;
    int foodIndex;
    int width;
    int height;
    int score;
	
	/** Initialize your data structure here.
    @param width - screen width
    @param height - screen height 
    @param food - A list of food positions
    E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
	public DesignSnakeGame(int width, int height, int[][] food) {
	    this.width = width;
	    this.height = height;
	    this.food = food;
	    body = new LinkedList<Integer>();
	    body.offerLast(0);  // 起点
	    foodIndex = 0;
	    score = 0;
	}
	
	/** Moves the snake.
	    @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
	    @return The game's score after the move. Return -1 if game over. 
	    Game over when snake crosses the screen boundary or bites its body. */
	public int move(String direction) {
		if (score == -1) return -1;   // game is over
		
	    int headx = body.peekFirst() / width;
	    int heady = body.peekFirst() * width;
	    
	    switch (direction) {
	        case "U" : headx--;
	                   break;
	        case "D" : headx++;
	                   break;
	        case "L" : heady--;
	                   break;
	        default :  heady++;
	    }
	    int newHead = headx * width + heady;
	    int tail = body.pollLast();
	    
	    // case 1: out of boundary or eating body
	    if (headx < 0 || heady < 0 || headx >= height || heady >= width || body.contains(newHead)) {
	    	score = -1;
	    	return -1;
	    }
	    
	    body.offerFirst(newHead);
	    
	    if (foodIndex < food.length && headx == food[foodIndex][0] && heady == food[foodIndex][1]) {
	    	foodIndex++;
	    	score++;
	    	body.offerLast(tail); // old tail does not change, so add it back to body
	    } 

	    return score;
	}
}
