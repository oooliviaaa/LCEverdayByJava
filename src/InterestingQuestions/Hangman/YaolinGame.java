package InterestingQuestions.Hangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class YaolinGame {

	int chances;
	int revealed;
	String word;
	Set<Character> used;
    private static final String WORDS_FILE_PATH = "/Users/yaolin/Documents/workspace/JavaExercise/src/InterestingQuestions/Hangman/words.txt";
    private static final int MAX_HP = 8;
    
	public YaolinGame() {
		try {
			word = loadWords();
			chances = MAX_HP;
			revealed = 0;
			used = new HashSet<Character>();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private String loadWords() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(WORDS_FILE_PATH));
        String line;
        List<String> words = new ArrayList<String>();
        while ((line = br.readLine()) != null) {
            words.add(line);
        }
        Random r = new Random(words.size());
        return words.get(r.nextInt());
	}
	
	public void startGame() {
		System.out.println("game start:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int attempt = 0;
		while (true) {
			try {
				System.out.println("Guess a letter:");
                String line = br.readLine().trim();
                if (line.length() > 1 || line.length() <= 0) {
                    System.out.println("Invalid input only 1 letter allowed");
                    continue;
                }
                char c = line.charAt(0);
                
    			guess(c);
    			
    			if (attempt >= chances) {
    				System.out.println("you fail!");
    				break;
    			}
    			if (revealed >= word.length()) {
    				System.out.println("you win!");
    				break;
    			}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	private void guess(char c) {
		c = Character.toLowerCase(c);
		if (used.contains(c)) {
			System.out.println("already guessed, try different word!");
			return;
		}
		used.add(c);
		if (word.indexOf(c) >= 0) {
			
		} else {
			
		}
	}
}
