package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		dfs(s, 0, new ArrayList<String>(), res);
		return res;
    }
	
	private void dfs(String s, int index, List<String> tmp, List<List<String>> res) {
		if (index >= s.length()) {
			List<String> t = new ArrayList<String>(tmp);
			res.add(t);
			return;
		}
		
		for (int i = index+1; i <= s.length(); i++) {
			String sub = s.substring(index, i);
			if (isPalindrome(sub)) {
				tmp.add(sub);
				dfs(s, i, tmp, res);
				tmp.remove(tmp.size()-1);
			}
		}
	}
	
	private boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length()-1;
		
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
