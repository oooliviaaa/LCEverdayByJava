package LLLLLLLLLLL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TopologicalSortOnDAG {

	public List<Integer> sort(int[] startVertices, int[][] dag) {
		List<Integer> res = new ArrayList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		
		for (int i = 0; i < startVertices.length; i++) {
			if (!visited.contains(startVertices[i])) {
				sort(startVertices[i], visited, dag, res);
			}
		}
		return res;
	}
	
	private void sort(int node, Set<Integer> visited, int[][] dag, List<Integer> res) {
		visited.add(node);
		for (int[] edge : dag) {
			if (edge[0] == node && !visited.contains(edge[1])) {
				sort(edge[1], visited, dag, res);
			}
		}
		
		res.add(0, node);
	}
	
	public static void main(String[] args) {
		TopologicalSortOnDAG ts = new TopologicalSortOnDAG();
		int[] startVertices = {7,8,9,10};
		int[][] dag = {{7,1}, {1,5}, {7,2}, {2,5}, {5,3}, {5,4}, {8,1}};
		List<Integer> res = ts.sort(startVertices, dag);
		for (int r : res) System.out.println(r);
	}
}
