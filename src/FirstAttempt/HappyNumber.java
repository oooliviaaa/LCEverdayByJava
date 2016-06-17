package FirstAttempt;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public boolean isHappy(int n) {
		
        Set<Integer> set = new HashSet<Integer>();
        while (n != 1) {
        	if (set.contains(n)) {
        		return false;
        	}
        	set.add(n);
        	n = getNextNum(n);
        }
        return true;
    }
	
	public int getNextNum(int n) {
		int sum = 0;
		while (n != 0) {
			sum += Math.pow(n % 10, 2);
			n = n / 10;
		}
		return sum;
	}
}
