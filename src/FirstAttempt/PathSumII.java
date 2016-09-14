package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	
	// http://www.programcreek.com/2014/05/leetcode-path-sum-ii-java/
	public List<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    if(root == null) 
	        return result;
	 
	    ArrayList<Integer> l = new ArrayList<Integer>();
	    l.add(root.val);
	    dfs(root, sum-root.val, result, l);
	    return result;
	}
	 
	public void dfs(TreeNode t, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> l){
	    if(t.left==null && t.right==null && sum==0){
	        ArrayList<Integer> temp = new ArrayList<Integer>();
	        temp.addAll(l);
	        result.add(temp);
	    }
	 
	    //search path of left node
	    if(t.left != null){
	        l.add(t.left.val);
	        dfs(t.left, sum-t.left.val, result, l);
	        l.remove(l.size()-1);
	    }
	 
	    //search path of right node
	    if(t.right!=null){
	        l.add(t.right.val);
	        dfs(t.right, sum-t.right.val, result, l);
	        l.remove(l.size()-1);
	    }
	}
	
	
	
	
	
	
	/////////////////////////
	// my solution
	public List<List<Integer>> pathSum_My(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}
		
		dfs(root, sum, new ArrayList<Integer>(), res);
		return res;
    }
	
	private void dfs(TreeNode root, int sum, List<Integer> tmp, List<List<Integer>> res) {
		if (root == null) return;
		if (root.val == sum && root.left == null && root.right == null) {
			List<Integer> t = new ArrayList<Integer>(tmp);
			t.add(root.val);  /////////// !!!!!
			res.add(t);
		}
		
		tmp.add(root.val);
		dfs(root.left, sum - root.val, tmp, res);
		dfs(root.right, sum - root.val, tmp, res);
		tmp.remove(tmp.size()-1);
	}
}
