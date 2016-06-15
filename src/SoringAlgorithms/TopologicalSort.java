package SoringAlgorithms;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;


/**
 * A topological ordering is possible if and only if the graph has no directed cycles, 
 * that is, if it is a directed acyclic graph (DAG). 
 * Any DAG has at least one topological ordering, 
 * and algorithms are known for constructing a topological ordering of any DAG in linear time.*/
public class TopologicalSort {

	private int nodeNum;
	private LinkedList<Integer>[] adj;
	
	public TopologicalSort(int num) {
		nodeNum = num;
		adj = new LinkedList[num];   // an array of LinkedLists
		for (int i = 0; i < num; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		System.out.println(adj[0]);
		System.out.println(adj[1]);
		System.out.println(adj[2]);
	}
	
	// edge: v --- n
	public void addEdge(int v, int n) {
		adj[v].add(n);
	}
	
	public void sort() {
		Stack<Integer> s = new Stack<Integer>();       //////////////// !!!
		
		Boolean[] visited = new Boolean[nodeNum];      //////////////// !!!
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
		s.push(i);        ////////////////////////// !!!
	}
	
	
	public static void main(String[] args) {
		TopologicalSort ts = new TopologicalSort(7);
		
		ts.addEdge(6, 1);
		ts.addEdge(1, 3);
		ts.addEdge(1, 4);
		ts.addEdge(6, 2);
		ts.addEdge(5, 6);
		ts.sort();
		
	}
}
