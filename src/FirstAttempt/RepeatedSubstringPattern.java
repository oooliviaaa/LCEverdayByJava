package FirstAttempt;

public class RepeatedSubstringPattern {

	/** https://discuss.leetcode.com/topic/67992/java-simple-solution-with-explanation
	 * The length of the repeating substring must be a divisor of the length of the input string
	 * Search for all possible divisor of str.length, starting for length/2
	 * If i is a divisor of length, repeat the substring from 0 to i the number of times i is contained in s.length
	 * If the repeated substring is equals to the input str return true
	 * */
	public boolean repeatedSubstringPattern(String str) {
        int len = str.length();
        
        for (int i = len / 2; i > 0; i--) {
        	if (len % i != 0) continue;
        	int j = len / i;
        	String pattern = str.substring(0, i);
        	StringBuffer sb = new StringBuffer();
        	for (int k = 0; k < j; k++) {
        		sb.append(pattern);
        	}
        	
        	if (sb.toString().equals(str)) return true;
        }
        return false;
    }
}
