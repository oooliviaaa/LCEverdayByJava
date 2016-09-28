package FirstAttempt;

public class ShortestPalindrome {

	// http://www.programcreek.com/2014/06/leetcode-shortest-palindrome-java/
	// http://www.jiuzhang.com/solutions/shortest-palindrome/
	public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int i = 0;
        int j = s.length()-1;
        
        for (; j >= 0; j--) {    //找到第一个使他不回文的位置
        	if (s.charAt(i) == s.charAt(j)) {
        		i++;
        	}
        }
        
        if (i == s.length()) return s;  // s is a Palindrome
        
        String surfix = s.substring(i);
        String prefix = new StringBuffer(surfix).reverse().toString();
        String mid = shortestPalindrome(s.substring(0, i));
        return prefix + mid + surfix;
        
    }
	
	public static void main(String[] args) {
		ShortestPalindrome sp = new ShortestPalindrome();
		String res = sp.shortestPalindrome("aacbecaaa");
		System.out.println(res);
	}
}
