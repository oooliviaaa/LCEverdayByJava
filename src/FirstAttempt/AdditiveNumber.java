package FirstAttempt;

import java.math.BigInteger;

public class AdditiveNumber {

	// https://segmentfault.com/a/1190000006080854
	// 不越界长度的Recursive:
	public boolean isAdditiveNumber(String num) {
        for (int i = 1; i <= num.length() / 2; i++) {
        	if (num.charAt(0) == '0' && i > 1) {
        		return false;  ///// 以0开头的，例如“023”这种数字是不被允许的
        	}
        	Long x1 = Long.parseLong(num.substring(0, i));
        	for (int len = 1; Math.max(i, len) <= num.length() - i - len; len++) {   // len为第二个数的长度
        		if (num.charAt(i) == '0' && len > 1) {
        			break;  ///// 以0开头的，例如“023”这种数字是不被允许的. 这里是break!!!!!
        		}
        		Long x2 = Long.parseLong(num.substring(i, i+len));
        		if (isAdditive(num, x1, x2, i+len)) {   ///// i+len是下一段的开始位置
        			return true;
        		}
        	}
        }
        return false;
    }
	
	private boolean isAdditive(String num, Long x1, Long x2, int nextPos) {
		if (nextPos == num.length()) return true;  //当可以走到后面没有和了的时候，说明这个string满足条件
		
		Long x3 = x1 + x2;
		String next = x3.toString();
		
		return num.startsWith(next, nextPos) && isAdditive(num, x2, x3, nextPos+next.length());
	}
	
	
	////////follow up/////////
	// Follow up:How would you handle overflow for very large input integers? --> BigInteger
	// 越界长的度iterator: (tail recursion is easy to transfer)
	public boolean isAdditiveNumber_followup(String num) {
	    int len = num.length();
	    for (int i = 1; i <= len / 2; i++) {
	        for (int j = 1; Math.max(i, j) <= len - i - j; j++) {
	            if (isValid(i, j, num)) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
	
	public boolean isValid(int i, int j, String num) {
	    if (num.charAt(0) == '0' && i > 1) return false;
	    if (num.charAt(i) == '0' && j > 1) return false;
	    BigInteger x1 = new BigInteger(num.substring(0, i));
	    BigInteger x2 = new BigInteger(num.substring(i, i + j));
	    String sum;
	    for (int start = i + j; start < num.length(); start += sum.length()) {
	        x2 = x2.add(x1);
	        x1 = x2.subtract(x1);
	        sum = x2.toString();
	        if (!num.startsWith(sum, start)) return false;
	    }
	    return true;
	}
}
