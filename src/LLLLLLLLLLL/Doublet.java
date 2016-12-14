package LLLLLLLLLLL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Doublet {
	
	public List<String> solution(String start, String end, Set<String> dict) {
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		dict.add(end);

		Queue<List<String>> ladder = new LinkedList<List<String>>();
		ladder.offer(new ArrayList<String>());

        Set<String> used = new HashSet<String>();
        used.add(start);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
                List<String> lad = ladder.poll();
                if (cur.equals(end)) {
                    lad.add(cur);
                    return lad;
                }
                
                Set<String> nextWords = getNextWords(cur);
                for (String n : nextWords) {
                    if (!used.contains(n) && dict.contains(n)) {
                        queue.offer(n);
                        used.add(n);

                        List<String> newLad = new ArrayList<String>(lad);
                        newLad.add(cur);
                        ladder.offer(newLad);
                    }
                }
 			}
		}
        return null;
	}

    private Set<String> getNextWords(String word) {
        Set<String> res = new HashSet<String>();
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
        Doublet d = new Doublet();
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("cot");
        dict.add("lot");
        dict.add("dog");
        System.out.println(d.solution("hit", "cog", dict));    //expected path: "hit" -> "hot" -> "cot" -> "cog"
    }
}
