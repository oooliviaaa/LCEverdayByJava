package InterestingQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Node {
	int val;
	Set<Node> adjs;
	
	public Node(int val) {
		this.val = val;
		adjs = new HashSet<Node>();
	}
	
	public void addAdj(Node node) {
		if (adjs == null) adjs = new HashSet<Node>();
		adjs.add(node);
	}
}

public class FindMinStartingNodeToTraverseGraph {

	// Jilong's solution
	// Directed Cycle Graph
	// airbnb, union find
	public List<Node> solution(List<Node> graph) {
		Set<Node> res = new HashSet<Node>();
		
		Map<Node, Node> visited = new HashMap<Node, Node>();   ///// !!!! 记录当前遍历的起始node
		
		for (Node node : graph) {
			if (visited.get(node) != null) {
				continue;
			}
			visited.put(node, node);
			unionFind(node, visited, node);
		}
		
		for (Node node : visited.values()) {   ///// 看visited里有多少个不同的value值
			res.add(node);
		}
		return new ArrayList<Node>(res);
	}
	
	private void unionFind(Node node, Map<Node, Node> visited, Node root) {
		Set<Node> adjs = node.adjs;
		for (Node adj : adjs) {
			if (visited.get(adj) == root) {   ///// 如果跟root不一样，就要更新为当前root
				continue;
			}
			visited.put(adj, root);
			unionFind(adj, visited, root);
		}
	}
	
	
	public static void main(String[] args) {
		FindMinStartingNodeToTraverseGraph fs = new FindMinStartingNodeToTraverseGraph();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		n1.addAdj(n2);
		n1.addAdj(n1);
		n2.addAdj(n3); n2.addAdj(n4);
		n3.addAdj(n2);
		n4.addAdj(n3); n4.addAdj(n5);
		n5.addAdj(n3);
		n8.addAdj(n2);
		n6.addAdj(n7);
		
		List<Node> list = new ArrayList<Node>();
		list.add(n1); list.add(n2); list.add(n3); list.add(n4); list.add(n5);
		list.add(n6); list.add(n7); list.add(n8); 
		List<Node> res = fs.solution(list);
		for (Node n : res) System.out.println(n.val);
	}
}
