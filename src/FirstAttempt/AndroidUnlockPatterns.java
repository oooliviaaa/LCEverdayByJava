package FirstAttempt;

import java.util.Arrays;

public class AndroidUnlockPatterns {

	// https://discuss.leetcode.com/topic/46260/java-dfs-solution-with-clear-explanations-and-optimization-beats-97-61-12ms
	public int numberOfPatterns(int m, int n) {
        if (m > 10 || n < 0) return 0;
        
        boolean[] visited = new boolean[10];
        Arrays.fill(visited, false);
        
        int[][] jumps = new int[10][10];
        jumps[1][3] = jumps[3][1] = 2;
        jumps[4][6] = jumps[6][4] = 5;
        jumps[7][9] = jumps[9][7] = 8;
        jumps[1][7] = jumps[7][1] = 4;
        jumps[2][8] = jumps[8][2] = 5;
        jumps[3][9] = jumps[9][3] = 6;
        jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = 5;
        
        int res = 0;
        for (int i = m; i <= n; i++) {   // initial len = 1, max pattern length = i
        	res += dfs(1, i-1, visited, jumps) * 4 
        			+ dfs(2, i-1, visited, jumps) * 4 
        			+ dfs(5, i-1, visited, jumps);
        }
 
        return res;
    }
	
	private int dfs(int num, int remain, boolean[] visited, int[][] jumps) {
		if (remain == 0) {
			return 1;
		} else if (remain < 0) {
		    return 0;
		}
		
		visited[num] = true;
		int count = 0;
		for (int i = 1; i < 10; i++) {
			if (!visited[i] && (jumps[num][i] == 0 || visited[jumps[num][i]])) {
				count += dfs(i, remain-1, visited, jumps);
			}
		}
		visited[num] = false;
		return count;
	}
}
