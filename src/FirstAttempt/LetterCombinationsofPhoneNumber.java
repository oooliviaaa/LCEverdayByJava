package FirstAttempt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofPhoneNumber {

	private Map<Character, char[]> dict;
	
	public LetterCombinationsofPhoneNumber() {
		dict = new HashMap<Character, char[]>();
		dict.put('2', new char[]{'a', 'b', 'c'});
		dict.put('3', new char[]{'d', 'e', 'f'});
		
		
	}
	
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		helper(digits, 0, res, new StringBuffer());
		return res;
    }
	
	private void helper(String digits, int index, List<String> res, StringBuffer tmp) {
		if (index >= digits.length()) {
			res.add(tmp.toString());
			return;
		}
		
		char d = digits.charAt(index);
		char[] chars = dict.get(d);
		
		for (char c : chars) {
			tmp.append(c);
			helper(digits, index+1, res, tmp);
			tmp.deleteCharAt(tmp.length()-1);
		}
		
	}
	
	public static void main(String[] args) {
		String digits = "232";
		LetterCombinationsofPhoneNumber lc = new LetterCombinationsofPhoneNumber();
		List<String> res = lc.letterCombinations(digits);
		for (String r : res) {
			System.out.println(r);
		}
	}
}
