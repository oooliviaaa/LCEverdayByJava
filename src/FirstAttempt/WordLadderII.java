package FirstAttempt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {

	// http://www.programcreek.com/2014/06/leetcode-word-ladder-ii-java/
	// https://discuss.leetcode.com/topic/2857/share-two-similar-java-solution-that-accpted-by-oj
	/**
	 * 1 Use BFS to construct a graph. 
	 * 2. Use DFS to construct the paths from end to start
	 * */
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (wordList == null || wordList.size() == 0) return res;
		wordList.add(endWord);   ///// !!!!!
		
		Queue<String> queue = new LinkedList<String>();
		queue.offer(beginWord);
		Queue<LinkedList<String>> ladder = new LinkedList<LinkedList<String>>();
        ladder.add(new LinkedList<String>());
		
		Set<String> visited = new HashSet<String>();
		visited.add(beginWord);
		
		boolean isFound = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				LinkedList<String> currentLadder = ladder.remove();
				List<String> nexts = getNextStrings(cur, wordList);
				for (String next : nexts) {
					if (visited.contains(next)) continue;
					if (next.equals(endWord)) {
						currentLadder.addLast(cur);
						currentLadder.addLast(endWord);
						res.add(currentLadder);
						isFound = true;
					} else {
						queue.offer(next);
						LinkedList<String> nextLadder = new LinkedList<String>(currentLadder);
						nextLadder.addLast(cur);
                        ladder.add(nextLadder);
					}
				}
			}
			if (isFound) break;
		}
		return res;
    }
	
	private List<String> getNextStrings(String word, Set<String> dict) {
		List<String> res = new ArrayList<String>();
		  for (int i = 0; i < word.length(); i++) {
              StringBuilder builder = new StringBuilder(word);
              for (char ch = 'a'; ch <= 'z'; ch++) {
                  builder.setCharAt(i, ch);
                  String new_word = builder.toString();
                  if (dict.contains(new_word)) {
                	  res.add(new_word);
                  }
              }
          }
		  return res;
	}
	
	public static void main(String[] args) {
		WordLadderII wd2 = new WordLadderII();
		
		Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dit");
        dict.add("cog");
        dict.add("lot");
        dict.add("dog");
        
        List<List<String>> res = wd2.findLadders("hit", "cog", dict);
        for (List<String> re : res) {
        	for (String r : re) {
        		System.out.print(r + " ");
        	}
        	System.out.println();
        }
	}
}
