package FirstAttempt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { 
			label = x; 
			neighbors = new ArrayList<UndirectedGraphNode>(); 
		}
	};
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        Map<UndirectedGraphNode, UndirectedGraphNode> note = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        
        note.put(node, head);
        dfs(node, note);
        return head;
    }
	
	private void dfs(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> note) {
		if (node == null) return;
		
		List<UndirectedGraphNode> neighbors = node.neighbors;
		for (UndirectedGraphNode n : neighbors) {
			if (!note.containsKey(n)) {
				UndirectedGraphNode newN = new UndirectedGraphNode(n.label);
				note.put(n, newN);
				dfs(n, note);
			}
			UndirectedGraphNode newNode = note.get(node);
			UndirectedGraphNode newN = note.get(n);
			newNode.neighbors.add(newN);   //////////// get connected !!!!!
		}
	}
	
}
