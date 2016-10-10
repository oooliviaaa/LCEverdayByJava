package FirstAttempt;

public class NumberOfOneBit {
	// you need to treat n as an unsigned value
	
	// http://www.programcreek.com/2014/03/leetcode-number-of-1-bits-java/
    public int hammingWeight(int n) {
        int count = 0;
        
        for (int i = 0; i < 32; i++) {  // integer最长32位，所以1至多左移31次
        	if (isOneBit(n, i)) {
        		count++;
        	}
        }
        return count;
    }
    
    private boolean isOneBit(int num, int i) {
    	return (num & (1 << i)) != 0;
    }
    
    /////////////////////////
    // https://segmentfault.com/a/1190000003436448
    // solution 2, 减一相与法
    /**
     * 该方法又叫Brian Kernighan方法。
     * 当原数不为0时，将原数与上原数减一相&的值赋给原数。
     * 因为每次减一再相与实际上是将最左边的1给消去了，所以消去几次就有几个1。
     * 比如110，减去1得101，相与得100，消去了最左边的1。
     * */
    // you need to treat n as an unsigned value
    public int hammingWeight2(int n) {
        int count = 0;
        while(n != 0b0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }
    
}
