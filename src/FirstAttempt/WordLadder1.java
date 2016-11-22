package FirstAttempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder1 {

	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        int level = 0;
        
        Set<String> visited = new HashSet<String>();
        visited.add(beginWord);
        
        wordList.add(endWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                
                if (cur.equals(endWord)) {
                    return level;
                }
                
                List<String> nexts = getNextWords(cur, wordList);
//                System.out.println(nexts);
                for (String next : nexts) {
                    if (wordList.contains(next) && !visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            level++;
        }
        return -1;
    }
    
    private List<String> getNextWords(String word, Set<String> wordList) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (char j = 'a'; j <= 'z'; j++) {
                if (c == j) continue;
                String newStr = word.substring(0, i) + j + word.substring(i+1);
                res.add(newStr);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
    	String begin = "hit";
    	String end = "cog";
    	Set<String> wordlist = new HashSet<String>();
    	wordlist.add("hot"); wordlist.add("dot"); wordlist.add("dog");
    	wordlist.add("lot"); wordlist.add("log"); 
    	
    	WordLadder1 wl = new WordLadder1();
    	int res = wl.ladderLength(begin, end, wordlist);
    	
    	System.out.println(res);
    }
}
