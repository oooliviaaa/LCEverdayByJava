package FirstAttempt;

public class DivideTwoIntegers {
	// << means *2
	public int divide(int dividend, int divisor) {
        if(divisor == 0) {
        	return dividend >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        if(dividend == 0) return 0;
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {  ////// because Integer.MIN_VALUE=-2147483648, Math.abs(Integer.MIN_VALUE) will overflow !!! 
            return Integer.MAX_VALUE;
        }
        
        boolean neg = (dividend < 0 && divisor > 0) || 
                (dividend > 0 && divisor < 0);
        
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        
        int res = 0;
        while(a >= b) {
        	int shift = 0;
        	while(a >= (b << shift)) {
        		shift++;
        	}
        	a -= b << (shift-1);
        	res += 1 << (shift-1);  // how many b
        }
        return neg? -res : res;
    }
	
	public static void main(String[] args) {
		DivideTwoIntegers di = new DivideTwoIntegers();
		int res = di.divide(34, 3);
		System.out.print(res);
	}
}
