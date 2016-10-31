package FirstAttempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberofIslandsII {

	// https://discuss.leetcode.com/topic/29613/easiest-java-solution-with-explanations/2
	// union find
	/**
	 * To represent a list of islands, we use trees. i.e., a list of roots. 
	 * This helps us find the identifier of an island faster. 
	 * If roots[c] = p means the parent of node c is p, we can climb up the parent chain to find out the identifier of an island, 
	 * i.e., which island this point belongs to: Do root[root[roots[c]]]... until root[c] == c;
	 * 
	 * To transform the two dimension problem into the classic UF, perform a linear mapping: int id = n * x + y;
	 * 
	 * Initially assume every cell are in non-island set {-1}. When point A is added, we create a new root, i.e., a new island. 
	 * Then, check if any of its 4 neighbors belong to the same island. If not, union the neighbor by setting the root to be the same. 
	 * Remember to skip non-island cells.
	 * 
	 * UNION operation is only changing the root parent so the running time is O(1).
	 * FIND operation is proportional to the depth of the tree. If N is the number of points added, the average running time is O(logN), and a sequence of 4N operations take O(NlogN). If there is no balancing, the worse case could be O(N^2).
	 * 
	 * Remember that one island could have different roots[node] value for each node. 
	 * Because roots[node] is the parent of the node (may not be the highest nor the lowest parent), not the highest root of the island. 
	 * To find the actually root, we have to climb up the tree by calling findIsland function.
	 * */
	
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
		List<Integer> res = new ArrayList<Integer>();
		
		if(m <= 0 || n <= 0) return res;
		
		int[] roots = new int[m * n];
		Arrays.fill(roots, -1);
		
		int islandCount = 0;
		for (int p = 0; p < positions.length; p++) {  // for each step
			int[] step = positions[p];
			islandCount++;   // 对于每一步，先假定island变多了一个，如果之后发现其实成为了以前island的一部分的话，再减去
			
			int index = step[0] * n + step[1];   // 作为root[] 的index
			roots[index] = index;  //set root to be itself for each new node
			
			for (int[] dir : directions) {
				int x = dir[0] + step[0];
				int y = dir[1] + step[1];
				if (x >= 0 && y >= 0 && x < m && y < n && roots[x*n+y] != -1) {
					int newRoot = getRoot(roots, x*n+y);
					if (index != newRoot) {
						roots[index] = newRoot;// union two islands !!!!!
						index = newRoot;       // current tree root = joined tree root!!!!!
						islandCount--;
					}
				}
			}
			
			res.add(islandCount);
		}
		return res;
    }
	
	private int getRoot(int[] roots, int index) {
		while (index != roots[index]) {
			// 此处加不加 roots[index] = roots[roots[index]];都无所谓
			index = roots[index];
		}
		return index;
	}
}
