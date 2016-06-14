package SoringAlgorithms.SoringExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalExercise {

	private int nodeNum;
	private LinkedList[] adj;
	
	public TopologicalExercise(int num) {
		nodeNum = num;
		adj = new LinkedList[num];
		for (int i = 0; i < num; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int n) {
		adj[v].add(n);
	}
	
	public ArrayList<Integer> sort() {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		boolean[] visited = new boolean[nodeNum];
		Arrays.fill(visited, false);
		
		for (int i = 0; i < nodeNum; i++) {
			if (!visited[i]) {
				sortUtil(i, s, visited);
			}
		}
		
		while (!s.isEmpty()) {
			res.add(s.pop());
		}
		
		return res;
	}
	
	private void sortUtil(int i, Stack<Integer> s, boolean[] visited) {
		visited[i] = true;
		Iterator<Integer> it = adj[i].iterator();
		
		while (it.hasNext()) {
			int n = it.next();
			if (!visited[n]) {
				sortUtil(n, s, visited);
			}
			
		}
		s.push(i);
	}
	
	public static void main(String[] args) {
		TopologicalExercise te = new TopologicalExercise(5);
		te.addEdge(0, 1);
		te.addEdge(1, 3);
		te.addEdge(1, 4);
		te.addEdge(0, 2);
		
		ArrayList<Integer> res = te.sort();
		for (int r : res) System.out.println(r);
	}
	
}
