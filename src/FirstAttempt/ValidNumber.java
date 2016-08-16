package FirstAttempt;

public class ValidNumber {

	public boolean isNumber(String s) {
        if (s == null) return false;
        s = s.trim();
        int len = s.length();
        if (len == 0) return false;
        
        int i = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
        	i++;
        }
        
        boolean num = false;
        boolean exp = false;
        boolean dot = false;
        
        for (; i < len; i++) {
        	char c = s.charAt(i);
        	if (Character.isDigit(c)) {
        		num = true;
        	} else if (c == '.') {
        		if (dot || exp) return false;
        		dot = true;
        	} else if (c == 'e') {
        		if (exp || (!num)) return false;   //////// !!!!!
        		exp = true;
        		num = false;   //////// !!!!!
        	} else if (c == '+' || c == '-') {
        		if (s.charAt(i-1) != 'e') return false;
        	} else {
        		return false;
        	}
        }
        
        return num;  ////////////  !!!!!!!
    }
}
