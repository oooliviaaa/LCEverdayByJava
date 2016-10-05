package FirstAttempt;

public class FindTheCelebrity {

	boolean knows(int a, int b) {
		if (b == -1) return true; 
		else return false;
	}
	
	// http://buttercola.blogspot.com/2015/09/leetcode-find-celebrity.html
	// solution 2
	/**
	 * A O(n) time O(1) Space Solution:
	 * 
	 * Use two pointers, left starts from 0, and right starts from n - 1.
	 * Check if knows(left, right). If yes, left++. Else, right--.
	 * After the first step, we could find out the potential candidate. 
	 * 
	 * In the second step, we validate the candidate by iterating through all the person again. 
	 * Each one must know the candidate while the candidate must not know anyone else. 
	 * */
	public int findCelebrity(int n) {
		if (n <= 1) {
            return -1;
        }
		
		int left = 0;
        int right = n-1;
        
        while (left < right) {
        	if (knows(left, right)) {
        		left++;
        	} else {
        		right--;
        	}
        }
        
        int candidate = right;
        for (int i = 0; i < n; i++) {
        	if (candidate != i && (!knows(i, candidate) || knows(candidate, i))) {
        		return -1;
        	}
        }
        return candidate;
    }
	
	
}
