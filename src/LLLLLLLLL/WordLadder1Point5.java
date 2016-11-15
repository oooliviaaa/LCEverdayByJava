package LLLLLLLLL;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder1Point5 {

	// from Shuai
	// only return one possible answer
	public static List<String> findLadders(String start, String end, Set<String> dict) {
        LinkedList<String> ladder = new LinkedList<String>();
        if (start.equals(end)) {
            return ladder;
        }
        if (dict == null || dict.size() == 0) {
            return null;
        }
        Queue<String> wordQueue = new LinkedList<String>();
        Queue<LinkedList<String>> ladderQueue = new LinkedList<LinkedList<String>>();
        wordQueue.add(start);
        ladderQueue.add(new LinkedList<String>());

        while (!wordQueue.isEmpty()) {
            String currentWord = wordQueue.remove();
            LinkedList<String> currentLadder = ladderQueue.remove();

            char[] ca = currentWord.toCharArray();
            for (int n = 0; n < ca.length; n++) {
                char originalChar = ca[n];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != originalChar) {
                        ca[n] = c;
                        String nextWord = new String(ca);

                        if (nextWord.equals(end)) {
                            currentLadder.addLast(currentWord);
                            currentLadder.addLast(end);
                            return currentLadder;
                        }

                        if (dict.contains(nextWord)) {
                            wordQueue.add(nextWord);
                            LinkedList<String> nextLadder = new LinkedList<String>(currentLadder);
                            nextLadder.addLast(currentWord);
                            ladderQueue.add(nextLadder);
                            dict.remove(nextWord);
                        }
                    }
                }
                ca[n] = originalChar;
            }
        }
        return ladder;
    }
	    
	    
    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("cot");
        dict.add("lot");
        dict.add("dog");
        System.out.println(findLadders("hit", "cog", dict));    //expected path: "hit" -> "hot" -> "dot" -> "dog" -> "cog"
    }

}
