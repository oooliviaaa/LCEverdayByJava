package Taxi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphTraversal {

	public static void main(String[] args) {
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		GraphNode n6 = new GraphNode(6);
		GraphNode n7 = new GraphNode(7);
		
		n1.addNeighbor(n2);
		n2.addNeighbor(n3); n2.addNeighbor(n4); n2.addNeighbor(n5);
		n4.addNeighbor(n6);
		n5.addNeighbor(n6);
		n6.addNeighbor(n7);
		
		GraphTraversal gt = new GraphTraversal();
		List<GraphNode> res = gt.DFSTraversal(n1);
		for (GraphNode n : res) {
			System.out.println(n.val);
		}
		
		System.out.println("============");
		
		GraphNode m1 = new GraphNode(1);
		GraphNode m2 = new GraphNode(2);
		m1.addNeighbor(m2); 
		m2.addNeighbor(m1);
		List<GraphNode> res2 = gt.BFSTraversal(m1);
		for (GraphNode n : res2) {
			System.out.println(n.val);
		}
	}
	
	public List<GraphNode> DFSTraversal(GraphNode node) {
		List<GraphNode> res = new ArrayList<GraphNode>();
		if (node == null) {
			return res;
		}
		
		DFSHelper(node, res);
		return res;
	}
	
	private void DFSHelper(GraphNode node, List<GraphNode> res) {
		if (res.contains(node)) {
			return;
		}
		res.add(node);
		List<GraphNode> neighbors = node.neighbors;
		if (neighbors != null || !neighbors.isEmpty()) {
			for (GraphNode n : neighbors) {
				DFSHelper(n, res);
			}
		}
		
	}
	
	public List<GraphNode> BFSTraversal(GraphNode node) {
		List<GraphNode> res = new ArrayList<GraphNode>();  
		
		Queue<GraphNode> q = new LinkedList<GraphNode>();
		q.add(node);
		
		while (!q.isEmpty()) {
			GraphNode cur = q.poll();
			if (res.contains(cur)) {
				break;
			}
			res.add(cur);
			List<GraphNode> neighbors = cur.neighbors;
			for (GraphNode n : neighbors) {
				q.add(n);
			}
		}
		
		return res;
	}
}
