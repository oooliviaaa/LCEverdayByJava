package FirstAttempt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		String beginWord = "cat";
		String endWord = "dog"; 
		Set<String> wordList = new HashSet<String>();
		wordList.add("cot"); wordList.add("cog"); wordList.add("dog"); wordList.add("hah");
		wordList.add("a"); wordList.add("b"); wordList.add("c");
		
		WordLadder wl = new WordLadder();
		int res = wl.ladderLength("a", "c", wordList);
		System.out.println("result: " + res);
	}
	
	
	
	// 求shortest path --> BFS
	// http://www.jiuzhang.com/solutions/word-ladder/
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		if (wordList == null) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }
		
		Set<String> visited = new HashSet<String>();
		visited.add(beginWord);
		
		Queue<String> queue = new LinkedList<String>();
		queue.offer(beginWord);
		int count = 0;
		while (!queue.isEmpty()) {
			count++;
			int size = queue.size();   ////////// !!!!! good way to calculate level in queue
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				visited.add(cur);
				
				List<String> words = getNextWords(cur, wordList);
				for (String word : words) {
					if (visited.contains(word)) continue;  /////// prevent infinite loop !!!!!
					if (word.equals(endWord)) return count;
					queue.add(word);
				}
			}
		}
		return 0; ////// did not find !!!!!!
		
	}
	
	private List<String> getNextWords(String word, Set<String> dict) {
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			for (char j = 'a'; j <= 'z'; j++) {
				if (c == j) {
					continue;   //////// !!!!!
				}
				String newWord = word.substring(0, i) + j + word.substring(i+1);
				if (dict.contains(newWord)) {
					res.add(newWord);
				}
			}
		}
		return res;
	}
	
}
