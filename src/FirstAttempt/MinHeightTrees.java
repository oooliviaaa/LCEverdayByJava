package FirstAttempt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinHeightTrees {

	// http://blog.csdn.net/sbitswc/article/details/50416714
	/** 
	 * build graph first, then find leaf and remove them among their neighbors, 
	 * level by level. Until left less 2 nodes
	 * */
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> leaf = new ArrayList<Integer>();
		
		if (n <= 1) {
			leaf.add(0);
			return leaf;
		}
		
		// build a graph
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < n; i++) {
			graph.put(i, new ArrayList<Integer>());
		}
		for (int[] edge : edges) {
			int n1 = edge[0]; int n2 = edge[1];
			graph.get(n1).add(n2);
			graph.get(n2).add(n1);
		}
		
		// remove leafs level by level
		for (int node : graph.keySet()) {
			List<Integer> nei = graph.get(node);
			if (nei.size() == 1) {
				leaf.add(node);
			}
		}
		
		while (n > 2) {
			List<Integer> newLeaf = new ArrayList<Integer>();  
			for (int l : leaf) {
				n--;
				List<Integer> nNei = graph.get(l);
				for (int ne : nNei) {
					graph.get(ne).remove(l);
					if (graph.get(ne).size() == 1) {
						newLeaf.add(ne);
					}
				}
			}
			leaf = newLeaf;
		}
		return leaf;
	}
}
