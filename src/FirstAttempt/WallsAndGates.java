package FirstAttempt;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WallsAndGates {

	int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
	
	// https://segmentfault.com/a/1190000003906674
	public void wallsAndGates(int[][] rooms) {
		if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        for (int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                // 如果遇到一个门，从门开始广度优先搜索，标记连通的节点到自己的距离
                if(rooms[i][j] == 0) bfs(rooms, i, j);
            }
        }
    }
	
	private void bfs(int[][] rooms, int i, int j) {
		int row = rooms.length;
		int col = rooms[0].length;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i*col + j);
		
		Set<Integer> visited = new HashSet<Integer>();
		visited.add(i*col + j);
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				int cur = queue.poll();
				int x = cur / col;
				int y = cur % col;
				
				// 选取之前标记的值和当前的距离的较小值
				rooms[x][y] = Math.min(level, rooms[x][y]);
				
				for (int[] dir : directions) {
					int xx = x + dir[0];
					int yy = y + dir[1];
					if (xx < 0 || yy < 0 || xx >= row || yy >= col) continue;   // 超过边界了，不考虑
					
					if (rooms[xx][yy] <= 0) continue;      // -1 or 0（是墙、门），不考虑
					
					int key = xx * col + yy;
					if (visited.contains(key)) continue;   // 已经访问过，不考虑
					queue.offer(key);
					visited.add(key);
				}		
			}
			level++;
		}
	}
}
