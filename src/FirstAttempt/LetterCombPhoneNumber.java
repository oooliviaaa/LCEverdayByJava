package FirstAttempt;

import java.util.ArrayList;

public class LetterCombPhoneNumber {

	// DFS
	// http://www.jiuzhang.com/solutions/letter-combinations-of-a-phone-number/
	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> res = new ArrayList<String>();		
		if(digits == null || digits.length() == 0) return res;
		StringBuilder sb = new StringBuilder();
		helper(digits, 0, res, sb);
		return res;
    }
	
	private void helper(String digits, int index, ArrayList<String> res, StringBuilder tmp) {
		// stop case:
		if(digits.length() == tmp.length()) {
			res.add(tmp.toString());
			return;
		}
		char c = digits.charAt(index);
		String chars = getChars(c);
		for(int i = 0; i < chars.length(); i++) {
			tmp.append(chars.charAt(i));
			helper(digits, index+1, res, tmp);
			tmp.deleteCharAt(tmp.length()-1);
		}
	}
	
	private String getChars(char num) {
		switch(num){
			case '2': return "abc";
			case '3': return "def";
			case '4': return "ghi";
			case '5': return "jkl";
			case '6': return "mno";
			case '7': return "pqrs";
			case '8': return "tuv";
			case '9': return "wxyz";
			default: return "";
		}
	}
}
