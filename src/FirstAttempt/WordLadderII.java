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
		
		Set<String> unvisited = new HashSet<String>(wordList);
		Set<String> visited = new HashSet<String>();
		visited.add(beginWord);
		
		int level = 0;
		boolean isFound = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				List<String> nexts = getNextStrings(cur, wordList);
			}
		}
		
    }
	
	private List<String> getNextStrings(String word, Set<String> wordList) {
		List<String> res = new ArrayList<String>();
		  for (int i = 0; i < word.length(); i++) {
              StringBuilder builder = new StringBuilder(word);
              for (char ch = 'a'; ch <= 'z'; ch++) {
                  builder.setCharAt(i, ch);
                  String new_word = builder.toString();
              }
          }
	}
}
