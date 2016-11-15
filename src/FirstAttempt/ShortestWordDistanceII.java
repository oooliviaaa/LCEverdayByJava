package FirstAttempt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII {

	Map<String, List<Integer>> dict;
	
	public ShortestWordDistanceII(String[] words) {
        dict = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; i++) {
        	String word = words[i];
        	List<Integer> indexs = dict.get(word);
        	if (indexs == null) {
        		indexs = new ArrayList<Integer>();
        	}
        	indexs.add(i);
        	dict.put(word, indexs);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> indexs1 = dict.get(word1);
        List<Integer> indexs2 = dict.get(word2);
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < indexs1.size(); i++) {
        	for (int j = 0; j < indexs2.size(); j++) {
        		int diff = Math.abs(indexs1.get(i) - indexs2.get(j));
        		res = diff < res ? diff : res;
        	}
        }
        return res;
    }
    
    
    //////////////////
    // TLE

    public int shortest(String words[], String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int pos1 = -1;
        int pos2 = -1;
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            if (cur.equals(word1)) {
                pos1 = i;
            } else if (cur.equals(word2)) {
                pos2 = i;
            }
            
            if (pos1 != -1 && pos2 != -1) {
                res = Math.min(res, Math.abs(pos1 - pos2));
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
    	String[] words = new String[]{"a", "c", "a", "d", "b"};
    	ShortestWordDistanceII sw = new ShortestWordDistanceII(words);
    	int res = sw.shortest(words, "b", "c");
    	System.out.println(res);
    }
}

//Your WordDistance object will be instantiated and called as such:
//WordDistance wordDistance = new WordDistance(words);
//wordDistance.shortest("word1", "word2");
//wordDistance.shortest("anotherWord1", "anotherWord2");