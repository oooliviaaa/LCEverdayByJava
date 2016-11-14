package LLLLLLLLL;

public class ShortestThreeWordDistance {

	public int solution(String[] words, String word1, String word2, String word3) {
		int minDis = Integer.MAX_VALUE;
        int pos1 = -1;
        int pos2 = -1;
        int pos3 = -1;
        
        for (int i = 0; i < words.length; i++) {
        	String word = words[i];
        	if (word.equals(word1)) {
        		pos1 = i;
        	}
        	if (word.equals(word2)) {
        		pos2 = i;
        	}
        	if (word.equals(word3)) {
        		pos3 = i;
        	}
        	if (pos1 != -1 && pos2 != -1 && pos3 != -1) {
        		int diff = getMinDist(pos1, pos2, pos3);
        		minDis = minDis > diff ? diff : minDis;
        	}
        }
        return minDis;
	}
	
	private int getMinDist(int a, int b, int c) {
		int max = Math.max(a, Math.max(b, c));
		int min = Math.min(a, Math.min(b, c));
		return max - min;
	}
}
