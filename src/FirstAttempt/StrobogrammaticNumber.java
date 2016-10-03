package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {

	// https://segmentfault.com/a/1190000003787462
	/**
	 * 翻转后对称的数就那么几个，我们可以根据这个建立一个映射关系：8->8, 0->0, 1->1, 6->9, 9->6，
	 * 然后从两边向中间检查对应位置的两个字母是否有映射关系就行了。
	 * */
	Map<Character, Character> dict;
	
	public StrobogrammaticNumber() {
		dict = new HashMap<Character, Character>();
		dict.put('1','1');
		dict.put('0','0');
		dict.put('6','9');
		dict.put('9','6');
		dict.put('8','8');
	}
	
	public boolean isStrobogrammatic(String num) {
        int left = 0;
        int right = num.length()-1;
        
        while (left <= right) {
        	char l = num.charAt(left);
        	char r = num.charAt(right);
        	if (!dict.containsKey(r) || l != dict.get(r)) {
        		return false;
        	}
        	left++;
        	right--;
        }
        return true;
    }
}
