package FirstAttempt;

import java.util.HashSet;

public class JumpFrog {

	// A: array of time, N: length of A, X: length of the river, D: max length that frog can jump
	public int solution(int A[], int N, int X, int D) {  
		if(A == null || A.length == 0) return -1;
		if(X <= D) return 0;
		
		int tail = D;   // all the distance before D can be reached by the frog
		boolean[] canJump = new boolean[X];   // if frog can jump to the distance
		HashSet<Integer> leaves = new HashSet<Integer>();
		
		// initialize
		for(int i = 0; i <= D; i++) canJump[i] = true;
		
		for(int i = 0; i < N; i++) {
			if(!leaves.contains(A[i])) leaves.add(A[i]);
			
			int cur = A[i];  // new leave position
			
			while(canJump[cur] && cur + D > tail) { // can be reached, and never been reached before
				int len = cur + D;
				for(; tail <= len; tail++) {
					if(tail >= X) return i;
					canJump[tail] = true;
					if(leaves.contains(tail)) {
						cur = tail; // a previously missed leave was reached, update cur to be the new farthest leave
					}
				}
				tail = len;  // tail will be len+1 when exiting for-loop
			}
			
			
		}
	}
}
