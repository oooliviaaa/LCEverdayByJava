package FirstAttempt;


public class Roman2Integer {

	// http://blog.csdn.net/wzy_1988/article/details/17057929
	public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        int pre = s.charAt(0);
        int tmp = pre;
        
        for(int i = 1; i < s.length(); i++) {
        	char c = s.charAt(i);
        	int cur = getIntegerValue(c);
        	
        	if(cur == pre) {
        		tmp += cur;
        	}
        	else if(cur > pre) {
        		tmp = cur - tmp;
        	}
        	else {
        		res += tmp;
        		tmp = cur;
        	}
        	pre = cur;
        }
        res += tmp;        /////// don't forget!!!
        return res;
    }
	
	private int getIntegerValue(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;  
            case 'X': return 10;  
            case 'L': return 50;  
            case 'C': return 100;  
            case 'D': return 500;  
            case 'M': return 1000;  
            default: return 0; 
        }
    }
}
