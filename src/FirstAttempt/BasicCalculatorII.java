package FirstAttempt;

public class BasicCalculatorII {

	// http://www.programcreek.com/2014/05/leetcode-basic-calculator-ii-java/
	// 不用stack
	public int calculate(String s) {
        int md = -1;  // * or / (用来记录是乘法还是除法)
		int sign = 1;
		int pre = 0;
		int res = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int num = c - '0';
				int j = i+1;
				while (j < s.length() && Character.isDigit(s.charAt(j))) {
					if (Character.isDigit(s.charAt(j))) {
						num = num * 10 + (s.charAt(j) - '0');
						j++;
					}
				}
				i = j - 1;
				if (md == 0) {
					pre *= num;
					md = -1;
				} else if (md == 1) {
					pre /= num;
					md = -1;
				} else {
					pre = num;
				}
			} else if (c == '*') {  // 乘法和除法是遇到后一个数再处理
				md = 0;
			} else if (c == '/') {
				md = 1;
			} else if (c == '+') {  // 加法和减法是遇到一个处理前一个，并且记录下当前数的符号
				res += sign * pre;
				sign = 1;
			} else if (c == '-') {
				res += sign * pre;
				sign = -1;
			}
		}
		
		res += sign * pre;
		return res;
    }
}
