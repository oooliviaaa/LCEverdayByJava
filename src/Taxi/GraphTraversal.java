package Taxi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphTraversal {

	public static void main(String[] args) {
		GraphTraversal gt = new GraphTraversal();
		List<GraphNode> res0 = gt.DFSTraversal(null);
		for (GraphNode n : res0) {
			System.out.println(n.val);
		}
		
		System.out.println("============");
		
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
		
		List<GraphNode> res1 = gt.DFSTraversal(n1);
		for (GraphNode n : res1) {
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
		
		System.out.println("============");
		
		GraphNode v1 = new GraphNode(1);
		GraphNode v2 = new GraphNode(2);
		GraphNode v3 = new GraphNode(3);
		GraphNode v4 = new GraphNode(4);
		
		v1.addNeighbor(v2); v1.addNeighbor(v3);
		v2.addNeighbor(v1); v2.addNeighbor(v3);
		v3.addNeighbor(v1); v3.addNeighbor(v2);
		
		List<GraphNode> res3 = gt.DFSTraversal(v1);
		for (GraphNode n : res3) {
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
		if (node == null) {
			return res;
		}
		
		Queue<GraphNode> q = new LinkedList<GraphNode>();
		q.add(node);
		
		while (!q.isEmpty()) {
			GraphNode cur = q.poll();
			if (res.contains(cur)) {
				break;
			}
			res.add(cur);
			List<GraphNode> neighbors = cur.neighbors;
			if (neighbors != null && !neighbors.isEmpty()) {
				for (GraphNode n : neighbors) {
					q.add(n);
				}
			}
		}
		return res;
	}
}
