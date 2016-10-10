package FirstAttempt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphValidTree {

	// http://www.programcreek.com/2014/05/graph-valid-tree-java/
	// 这道题相当于是用DFS或BFS来detect cycle in a graph
	/**
	 * This problem can be converted to finding a cycle in a graph. It can be solved by using DFS (Recursion) or BFS (Queue).
	 * 
	 * 这道题给了我们一个无向图，让我们来判断其是否为一棵树，
	 * 我们知道如果是树的话，所有的节点必须是连接的，也就是说必须是连通图，而且不能有环，所以我们的焦点就变成了验证是否是连通图和是否含有环。
	 * 
	 * 我们首先用DFS来做，根据pair来建立一个图的结构，用邻接链表来表示，还需要一个一位数组v来记录某个节点是否被访问过，然后我们用DFS来搜索节点0，
	 * 遍历的思想是，当DFS到某个节点，先看当前节点是否被访问过，如果已经被访问过，说明环存在，直接返回false，如果未被访问过，我们现在将其状态标记为已访问过，
	 * 然后我们到邻接链表里去找跟其相邻的节点继续递归遍历，注意我们还需要一个变量pre来记录上一个节点，以免回到上一个节点，
	 * 这样遍历结束后，我们就把和节点0相邻的节点都标记为true，然后我们在看v里面是否还有没被放过的节点，如果有，则说明图不是完全连通的，返回false，反之返回true
	 * */
	
	// solution 1: DFS
	public boolean validTree(int n, int[][] edges) {
        Map<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < n; i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            hm.put(i, list);
        }
        
        for (int[] edge : edges) {
        	hm.get(edge[0]).add(edge[1]);
        	hm.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        
        if (!dfs(0, -1, visited, hm)) return false;   ///// 一定要有个parent记录它之前的那个点！！！因为无向图本身直接判断的话就是一个环，我们要忽略这种情况
        
        for(boolean b: visited){
            if(!b) return false;
        }
     
        return true;
    }
	
	private boolean dfs(int cur, int parent, boolean[] visited, Map<Integer, ArrayList<Integer>> hm) {
		if (visited[cur]) return false;
		visited[cur] = true;
		
		ArrayList<Integer> neibors = hm.get(cur);
		for (int n : neibors) {
			if (n != parent) {  ///// 跳过是前一个点的情况
				if (!dfs(n, cur, visited, hm)) {
					return false;   ///// 捕捉出现环的情况
				}
			}
		}
		return true;	
	}
	
	////////////////////////////
	// solution 2: BFS
	public boolean validTree2(int n, int[][] edges) {
		Map<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
	    for(int i=0; i<n; i++){
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        hm.put(i, list);
	    }
	 
	    for(int[] edge: edges){
	    	hm.get(edge[0]).add(edge[1]);
	    	hm.get(edge[1]).add(edge[0]);
	    }
	 
	    boolean[] visited = new boolean[n];
	 
	    Queue<Integer> queue = new LinkedList<Integer>();
	    queue.offer(0);
	    while(!queue.isEmpty()) {
	    	int cur = queue.poll();
	    	if (visited[cur]) {   ///// 一定要看是否visit过
	    		return false;
	    	}
	    	visited[cur] = true;
	    	
	    	List<Integer> neibors = hm.get(cur);
	    	for (int nei : neibors) {
	    		if (!visited[nei]) { ///// 对于undirected graph，只有没有visit过的才放入queue，
	    							  // 如果不check此处直接放入queue，就连最基本的一条线都会被看做是cycle了。所以必须check这块。
	    			queue.offer(nei);
	    		}
	    	}
	    }
	    
	    for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
         
        return true;
    }
	
	public static void main(String[] args) {
		int[][] edges = {{0,1}, {1,2}, {2,0}};
		int n = 3;
		
		GraphValidTree gv = new GraphValidTree();
		boolean res = gv.validTree2(n, edges);
		System.out.println(res);
	}
}
