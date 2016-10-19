package InterestingQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {

	int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	
	
	// bfs，只是单纯找最短路径
	public int solution(int[][] graph, int i, int j, int x, int y) {
		int res = -1;
		int row = graph.length;
		int col = graph[0].length;
		boolean[][] visited = new boolean[row][col];
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[]{i, j});
		visited[i][j] = true;
		int level = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				int[] cur = queue.poll();
				if (cur[0] == x && cur[1] == y) {
					return level;
				}
				for (int[] dir : directions) {
					int ii = cur[0] + dir[0];
					int jj = cur[1] + dir[1];
					if (ii >= 0 && ii < row && jj >= 0 && jj < col && !visited[ii][jj] && graph[ii][jj] != 5) {
						queue.offer(new int[]{ii,jj});
						visited[ii][jj] = true;
					}
				}
			}
			level++;
		}
		return -1;
	}
	
	
	// dp,  graph有weight的时候
	public int solution_dp(int[][] graph, int i, int j, int x, int y) {
		
		
		
	}
	
	public static void main(String[] args) {
		int[][] graph = {{0,0,5,5,0},{0,0,0,0,0},{5,0,0,0,0},{0,0,0,0,5}};
		ShortestPath sp = new ShortestPath();
		int res = sp.solution(graph, 0, 0, 0, 4);
		System.out.println(res);
		
		
		int[][] graph2 = {{3,7,5,5,0},{4,1,0,4,0},{5,0,0,7,8},{1,2,2,0,5}};
	}
}
