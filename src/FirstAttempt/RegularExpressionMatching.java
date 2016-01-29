package FirstAttempt;
/*
 *   ‘.’ Matches any single character.
 *   ‘*’ Matches zero or more of the preceding element.
 */
public class RegularExpressionMatching {
	
	// http://simpleandstupid.com/2014/10/14/regular-expression-matching-leetcode-%E8%A7%A3%E9%A2%98%E7%AC%94%E8%AE%B0/
	// s --> string; p --> pattern, consume p to match s
	public boolean isMatch(String s, String p) {
        // recursion's base case
		if(p.length() == 0) return s.length() == 0;
		
		// p.length()==1 is a special case
		if(p.length() == 1){
			if(s.length() < 1) return false;
			else if(s.charAt(0) != p.charAt(0) && p.charAt(0) != '.') return false;
			else return isMatch(s.substring(1), p.substring(1));  // consume one char, continue matching
		}
		
		
		// if p is longer than 1
		// case1: when the second char of p is not '*', easy case.
		if(p.charAt(1) != '*') {
			if(s.length() < 1) return false;  ////not < 2//// eg. s="a", p="ab*", still match
			if((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) return false;
            else return isMatch(s.substring(1), p.substring(1));   // consume one char, continue matching
		}
		//case 2: when the second char of p is '*', complex case.
		else {
			//when the '*' stands for 0 preceding element
            if(isMatch(s, p.substring(2))){
                return true;
            }
            /*when the '*' stands for 1 or more preceding element,
            use while loop to try every possible number, if any of them is true --> return true */
            int i = 0;
            while(i < s.length()  &&  (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
            	if(isMatch(s.substring(i+1), p.substring(2))) return true;
            	i++;
            }
            
		}
		return false;
    }
}
