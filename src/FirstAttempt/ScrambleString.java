package FirstAttempt;

import java.util.Arrays;

public class ScrambleString {

	// http://blog.csdn.net/ljiabin/article/details/44537523
	/**
	 * 【递归解法】
	 * 其实也是暴力遍历，把s1，s2分别分成两部分，判断s1的两部分和s2的两部分是否分别可以交换相等。
	 * */
	public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        Arrays.sort(c1);
        Arrays.sort(c2);
        
        if (!Arrays.equals(c1, c2)) return false;
        
        for (int i = 1; i < s1.length(); i++) {
        	if ( (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))  // 不交换
        		  ||
        		  isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))  
        		  // 交换的情况，这种情况比较难，仔细想清楚。s1: 0~i与s2:s2.length()-i~s2.length()-1要相等; s1:i~s1.length()-1与s2:0~s2.length()-i-1要相等。
        		  // 同一string的两部分相加长度要为string的长度
        	   ) {
        		return true;
        	}
        }
        return false;
    }
}
