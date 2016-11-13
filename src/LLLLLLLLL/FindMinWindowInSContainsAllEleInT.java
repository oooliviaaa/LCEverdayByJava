package LLLLLLLLL;

import java.util.HashMap;
import java.util.Map;

public class FindMinWindowInSContainsAllEleInT {
	public String minWindow(String s, String t) {
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!dict.containsKey(c))
                dict.put(c, 1);
            else
                dict.put(c, dict.get(c) + 1);
        }
        Map<Character, Integer> found = new HashMap<Character, Integer>();
        int foundCounter = 0;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        String minWindow = "";
        while (end < s.length()) {
            char c = s.charAt(end);
            if (dict.containsKey(c)) {
                if (found.containsKey(c)) {
                    if (found.get(c) < dict.get(c))
                        foundCounter++;
                    found.put(c, found.get(c) + 1);
                } else {
                    found.put(c, 1);
                    foundCounter++;
                }
            }
            if (foundCounter == t.length()) {
                //When foundCounter equals to t.length(), in other words, found all characters.
                char sc = s.charAt(start);
                while (!found.containsKey(sc) || found.get(sc) > dict.get(sc)) {
                    if (found.containsKey(sc) && found.get(sc) > dict.get(sc))
                        found.put(sc, found.get(sc) - 1);
                    start++;
                    sc = s.charAt(start);
                }
                if (end - start + 1 < min) {
                    minWindow = s.substring(start, end + 1);
                    min = end - start + 1;
                }
            }
            end++;
        }
        return minWindow;
    }
}
