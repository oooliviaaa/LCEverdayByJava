package FirstAttempt;

public class PowerOfTwo {

	// http://www.programcreek.com/2014/07/leetcode-power-of-two-java/
	// If a number is power of 2, it's binary form should be 10...0. 
	// So if we right shift a bit of the number and then left shift a bit, 
	// the value should be the same when the number >= 10(i.e.,2).

	public boolean isPowerOfTwo(int n) {
	    if(n <= 0) 
	        return false;
	 
	    while(n>2){
	        int t = n>>1;
	        int c = t<<1;
	 
	        if(n-c != 0)
	            return false;
	        n = n>>1;
	    }
	    return true;
	}


//////////////
	// If a number is power of 2, then its highly bit is 1 and there is only one 1. Therefore, n & (n-1) is 0.

	public boolean isPowerOfTwo2(int n) {
	    return n>0 && (n&n-1)==0;
	}
}
