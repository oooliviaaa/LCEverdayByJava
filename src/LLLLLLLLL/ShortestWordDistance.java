package LLLLLLLLL;

public class ShortestWordDistance {

	public int shortestDistance(String[] words, String word1, String word2) {
        int minDis = Integer.MAX_VALUE;
        int pos1 = -1;
        int pos2 = -1;
        
        for (int i = 0; i < words.length; i++) {
        	String word = words[i];
        	if (word.equals(word1)) {
        		pos1 = i;
        	}
        	if (word.equals(word2)) {
        		pos2 = i;
        	}
        	if (pos1 != -1 && pos2 != -1) {
        		int diff = Math.abs(pos1 - pos2);
        		minDis = minDis > diff ? diff : minDis;   // minDis = Math.min(minDis, diff);
        	}
        }
        return minDis;
    }
}
