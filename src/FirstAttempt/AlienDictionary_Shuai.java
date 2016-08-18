package FirstAttempt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlienDictionary_Shuai {

	import java.util.HashMap;
	import java.util.HashSet;
	import java.util.Map;
	import java.util.Set;
	import java.util.Stack;

    enum Status {
        VISITING,
        VISITED,
        NOT_VISITED
    }

    public static void main(String[] args) {
    	AlienDictionary_Shuai alienDict = new AlienDictionary_Shuai();
        String[] strs = new String[]{"za", "zb", "ca", "cb"};
        Map<Character, Set<Character>> map = alienDict.buildMap(strs);
        for (Map.Entry<Character, Set<Character>> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "--> \t");
            System.out.println(entry.getValue());
        }

        System.out.println(alienDict.alienOrder(strs));
    }

    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, Set<Character>> map = buildMap(words);
        Map<Character, Status> status = new HashMap<>();
        for (Character c : map.keySet()) {
            status.put(c, Status.NOT_VISITED);
        }
        Stack<Character> stack = new Stack<Character>();
        for (Character c : map.keySet()) {
            if (Status.VISITED != status.get(c)) {
                topologicalSort(map, status, c, stack);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private void topologicalSort(Map<Character, Set<Character>> map, Map<Character, Status> status, char c,
                                 Stack<Character> stack) {
        if (Status.VISITING == status.get(c)) {
            throw new RuntimeException("order cannot be determined");
        }
        status.put(c, Status.VISITING);
        Set<Character> nextChars = map.get(c);
        for (Character nextChar : nextChars) {
            if (Status.VISITED != status.get(nextChar)) {
                topologicalSort(map, status, nextChar, stack);
            }
        }
        stack.push(c);
        status.put(c, Status.VISITED);
    }


    public Map<Character, Set<Character>> buildMap(String[] words) {
        HashMap<Character, Set<Character>> map = new HashMap<>();
        if (words == null || words.length == 0) {
            return map;
        }
        //init last line
        int last = words.length - 1;
        for (int n = 0; n < words[last].length(); n++) {
            map.put(words[last].charAt(n), new HashSet<Character>());
        }
        for (int current = last - 1; current >= 0; current--) {
            int index = 0;
            //common part
            String currentWord = words[current];
            String nextWord = words[current + 1];
            while (index < currentWord.length() && index < nextWord.length()) {
                char currentLetter = currentWord.charAt(index);
                char nextLetter = nextWord.charAt(index);
                if (currentLetter != nextLetter) {
                    Set<Character> set = map.get(currentLetter);
                    if (set == null) {
                        set = new HashSet<>();
                    }
                    set.add(nextLetter);
                    map.put(currentLetter, set);
                    break;
                }
                ++index;
            }
            //current extra part if any
            while (index < words[current].length()) {
                char c = words[current].charAt(index);
                if (!map.containsKey(c)) {
                    map.put(c, new HashSet<Character>());
                }
                ++index;
            }
        }
        return map;
    }
}
