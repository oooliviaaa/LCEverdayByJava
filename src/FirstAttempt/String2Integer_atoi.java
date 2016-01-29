package FirstAttempt;

public class String2Integer_atoi {

	public int myAtoi(String str) {
		long res = 0;   //////// result was set to long at first
		if(str == null) return 0;
        str = str.trim();
        if(str.length() == 0) return 0;
        
        int sign = 1;
        int index = 0;
        
        if(str.charAt(index) == '+'){
        	index++;
        }
        else if(str.charAt(index) == '-'){
        	sign = -1;
        	index++;
        }
        
        for(; index < str.length(); index++) {
        	char c = str.charAt(index);
        	if(c < '0' || c > '9') break;
        	res = res * 10 + c - '0';   ///////////REMEMBER TO MINUS '0' !!!
        	if(res > Integer.MAX_VALUE) break;  ///////// REMEMBER to break if exceed max_integer
        }
        if (res * sign >= Integer.MAX_VALUE) {   /////////Remember to check if exceed max/min_integer
            return Integer.MAX_VALUE;
        }
        if (res * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)res * sign;   //// convert long back to int
    }
}
