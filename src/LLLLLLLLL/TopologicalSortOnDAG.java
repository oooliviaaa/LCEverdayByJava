package LLLLLLLLL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TopologicalSortOnDAG {
	public List<Integer> sort(int[] startVertices, int[][] dag) {
		Set<Integer> visited = new HashSet<Integer>();
		List<Integer> res = new ArrayList<Integer>();
		
		for (int v : startVertices) {
			if (!visited.contains(v)) {
				visited.add(v);
				topologicalSort(v, dag, visited, res);
			}
		}
		return res;
	}
	
	private void topologicalSort(int v, int[][] dag, Set<Integer> visited, List<Integer> res) {
		for (int[] d : dag) {
			if (d[0] == v && !visited.contains(d[1])) {
				visited.add(d[1]);
				topologicalSort(d[1], dag, visited, res);
			}
		}
		res.add(0, v);
	}
	
	public static void main(String[] args) {
		TopologicalSortOnDAG ts = new TopologicalSortOnDAG();
		int[] startVertices = {7,8,9};
		int[][] dag = {{7,1}, {1,5}, {7,2}, {2,5}, {5,3}, {5,4}, {8,1}};
		List<Integer> res = ts.sort(startVertices, dag);
		for (int r : res) System.out.println(r);
	}
}
