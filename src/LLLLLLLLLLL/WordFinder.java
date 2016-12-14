package LLLLLLLLLLL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordFinder {

	Set<String> dict;
	
	public WordFinder(Set<String> words) {
		dict = words;
	}
	
	public Set<String> find(List<Character> characters) {
		Set<String> res = new HashSet<String>();
		
		for (int i = 0; i < characters.size(); i++) {
			dfs(characters, i, dict, "", res);
		}
		
		return res;
	}
	
	private void dfs(List<Character> chars, int index, Set<String> dict, String tmp, Set<String> res) {
		if (chars.get(index) == '.') return;

        char c = chars.get(index);
        tmp += c;
        if (dict.contains(tmp)) {
        	res.add(tmp);
        }
        
        chars.set(index, '.');
        for (int i = 0; i < chars.size(); i++) {
        	if (index != i && chars.get(i) != '.') {
        		dfs(chars, i, dict, tmp, res);
        	}
        }
        chars.set(index, c);
	}
	
	public static void main(String[] args) {
    	Set<String> words = new HashSet<String>();
    	words.add("word"); words.add("words"); words.add("wood"); words.add("woo"); words.add("order");
    	char[] chars = {'o', 'r', 's', 'd', 'o', 'w', 'e'};
    	List<Character> characters = new ArrayList<Character>();
    	for (char c : chars) {
    		characters.add(c);
    	}
    	
    	
    	WordFinder wf = new WordFinder(words);
    	Set<String> res = wf.find(characters);
    	for (String r : res) System.out.println(r);
    }
}
 