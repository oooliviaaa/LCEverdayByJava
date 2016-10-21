package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {

	
	// http://buttercola.blogspot.com/2016/01/leetcode-generalized-abbreviation.html
	// dfs + backtracking
	public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        dfs(word, 0, res);
        return res;
    }
	
	private void dfs(String word, int index, List<String> res) {
		if (index >= word.length()) {
			return;
		}
		for (int i = index; i < word.length(); i++) {  // 数字开始的地方
			for (int j = 1; j+i <= word.length(); j++) {  // j表示数字的大小
				String num = Integer.toString(j);
				String abbr = word.substring(0, i) + num + word.substring(i+j);
				res.add(abbr);
				dfs(abbr, i+num.length()+1, res); // skip 1b, 俩数字不能连着
			}
		}
	}
}
