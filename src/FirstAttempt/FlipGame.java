package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {

	public List<String> generatePossibleNextMoves(String s) {
		List<String> res = new ArrayList<String>();
		if (s == null) return res;
		
		for (int i = 0; i < s.length()-1; i++) {
			if (s.charAt(i) == s.charAt(i+1) && s.charAt(i) == '+') {
				String newS = s.substring(0, i) + "--" + s.substring(i+2);
				res.add(newS);		
			}
		}
		return res;
    }
}
