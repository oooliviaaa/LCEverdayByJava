package FirstAttempt;

public class SuperUglyNumber {

	// http://www.programcreek.com/2014/05/leetcode-super-ugly-number-java/
	/**
	 * Similar with ugly number ii, use an array times[] as i2 in ugly number ii
	 * Keep adding minimum values to res[] and updating the time value for the chosen prime number in each loop.
	 * */
	public int nthSuperUglyNumber(int n, int[] primes) {
        int[] times = new int[primes.length];
        int[] res = new int[n];
        res[0] = 1;
        
        for (int i = 1; i < n; i++) {
        	int min = Integer.MAX_VALUE;
        	
        	for (int j = 0; j < primes.length; j++) {
        		int p = primes[j];
        		int step = times[j];
        		
        		min = Math.min(min, res[step] * p);
        	}
        	
        	for (int j = 0; j < primes.length; j++) {
        		int p = primes[j];
        		int step = times[j];
        		if (res[step] * p == min) {
        			times[j] += 1;
        		}
        	}
        }
        return res[n-1];
        
    }
}
