package SoringAlgorithms;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

	private int nodeNum;
	private LinkedList<Integer>[] adj;
	
	public TopologicalSort(int num) {
		nodeNum = num;
		adj = new LinkedList[num];
		for (LinkedList<Integer> ll : adj) {
			ll = new LinkedList<Integer>();
		}
	}
	
	// edge: v --- n
	public void addEdge(int v, int n) {
		adj[v].add(n);
	}
	
	public void sort() {
		Stack<Integer> s = new Stack<Integer>();
		
		Boolean[] visited = new Boolean[nodeNum];
		Arrays.fill(visited, false);
		
		for (int i = 0; i < nodeNum; i++) {
			if (!visited[i]) {
				sortUtil(i, visited, s);
			}
		}
		
		while (!s.isEmpty()) {
			System.out.println("node #" + s.pop());
		}
	}

	private void sortUtil(int i, Boolean[] visited, Stack<Integer> s) {
		// Mark the current node as visited.
		visited[i] = true;
		Iterator<Integer> it = adj[i].iterator();
		
		// Recur for all the vertices adjacent to this vertex
		while (it.hasNext()) {
			int v = it.next();
			if (!visited[v]) {
				sortUtil(v, visited, s);
			}
		}
		// Push current vertex to stack which stores result
		s.push(i);
	}
}
