package LLLLLLLLL;

public class ShortestWordDistanceIII {

	// http://buttercola.blogspot.com/2015/08/leetcode-shortest-word-distance-iii.html
	/**
	 * The key is we cannot update the two pointers simultaneously, 
	 * if they are the same. We could update one, compare the distance, and then update the other. 
	 * */
	public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || words.length < 2) return -1;
        
        int pos1 = -1;
        int pos2 = -1;
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
        	String cur = words[i];
        	
        	if (cur.equals(word1)) {
        		pos1 = i;
        	} else if (cur.equals(word2)) {   ///// else if!!!!! 俩word相同时，只更新pos1
        		pos2 = i;
        	}
        	
        	if (pos1 != -1 && pos2 != -1 && pos1 != pos2) {
        		res = Math.min(res, Math.abs(pos1-pos2));
        	}
        	
        	if (word1.equals(word2)) {
        		pos2 = pos1;   // 如果俩word相同，就用pos2记录下上一次出现的地方，一个一个向前推进查找
        	}
        }
        return res;
    }
}
