package FirstAttempt;

public class PowerOfThree {

	// http://www.programcreek.com/2014/04/leetcode-power-of-three-java/
	// Iteration
	public boolean isPowerOfThree(int n) {
		if(n == 1) return true; ////// !!!!!
	    
		while (n > 0) {
        	int m = n % 3;
        	if (m != 0) {
        		return false;
        	}
        	n /= 3;
        	if (n == 1) {   //////// !!!!!
        		return true;
        	}
        }
        return false;     ////// !!!!! n==0的时候其实是false的情况，相当于最后一次除3除不尽了
    }
	
	////////recursion/////////
	public boolean isPowerOfThree_Recursion(int n) {
	    if(n==0) 
	        return false;
	 
	    if(n==1) 
	        return true;
	 
	    if(n>1) 
	        return n%3==0 && isPowerOfThree(n/3);
	    else
	        return false;
	}
}
