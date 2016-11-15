package LLLLLLLLL;

public class ValidNumber {

	// with no e
	public boolean isValidNumber(String s) {
		if (s == null) return false;
        s = s.trim();
        int len = s.length();
        if (len == 0) return false;
        
        int i = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
        	i++;
        }
        
        boolean num = false;
        boolean dot = false;
        
        for (; i < len; i++) {
        	char c = s.charAt(i);
        	if (Character.isDigit(c)) {
        		num = true;
        	} else if (c == '.') {
        		if (dot) return false;
        		dot = true;
        	} else {
        		return false;
        	}
        }
        
        return num;
	}
	
	public static void main(String[] args) {
		String s = "-1432";
		ValidNumber vn = new ValidNumber();
		boolean res = vn.isValidNumber(s);
		System.out.println(res);
	}
	
}
