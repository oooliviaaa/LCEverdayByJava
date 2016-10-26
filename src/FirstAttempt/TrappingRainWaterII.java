package FirstAttempt;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWaterII {

	// https://discuss.leetcode.com/topic/60418/java-solution-using-priorityqueue/2
	
	int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	
	public int trapRainWater(int[][] heightMap) {
        int res = 0;
		if (heightMap == null || heightMap.length <= 1 || heightMap[0].length <= 1) {
        	return res;
        }
        
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>(new Comparator<Cell>() {

			public int compare(Cell o1, Cell o2) {
				return o1.height - o2.height;
			}
        	
        });
        
        int row = heightMap.length;
        int col = heightMap[0].length;
        boolean[][] visited = new boolean[row][col];
        
        // Initially, add all the Cells which are on borders to the queue.
        for (int i = 0; i < row; i++) {
            visited[i][0] = true;
            visited[i][col - 1] = true;
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            queue.offer(new Cell(i, col - 1, heightMap[i][col - 1]));
        }

        for (int i = 0; i < col; i++) {
            visited[0][i] = true;
            visited[row - 1][i] = true;
            queue.offer(new Cell(0, i, heightMap[0][i]));
            queue.offer(new Cell(row - 1, i, heightMap[row - 1][i]));
        }
        
       // from the borders, pick the shortest cell visited and check its neighbors:
       // if the neighbor is shorter, collect the water it can trap and update its height as its height plus the water trapped
       // add all its neighbors to the queue.
        while (!queue.isEmpty()) {
        	Cell cur = queue.poll();
        	
        	for (int[] dir : directions) {
        		int x = dir[0] + cur.row;
        		int y = dir[1] + cur.col;
        		if (x >= 0 && y >= 0 && x < row && y < col && !visited[x][y]) {
        			visited[x][y] = true;
        			res += Math.max(0, cur.height - heightMap[x][y]);
        			queue.offer(new Cell(x, y, Math.max(cur.height, heightMap[x][y])));
        		}
        	}
        }

        return res;
    }
}

class Cell {
    int row;
    int col;
    int height;
    public Cell(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
}
