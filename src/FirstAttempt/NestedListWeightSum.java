package FirstAttempt;

import java.util.Iterator;
import java.util.List;

public class NestedListWeightSum {
	interface NestedInteger {

	     // @return true if this NestedInteger holds a single integer, rather than a nested list.
	     public boolean isInteger();

	     // @return the single integer that this NestedInteger holds, if it holds a single integer
	     // Return null if this NestedInteger holds a nested list
	     public Integer getInteger();

	     // @return the nested list that this NestedInteger holds, if it holds a nested list
	     // Return null if this NestedInteger holds a single integer
	     public List<NestedInteger> getList();
	 }
	
	
	
	/** http://buttercola.blogspot.com/2016/06/leetcode-339-nested-list-weight-sum.html
	 * Because the input is nested, it is natural to think about the problem in a recursive way. 
	 * We go through the list of nested integers one by one, keeping track of the current depth d. 
	 * If a nested integer is an integer n, we calculate its sum as n * d. 
	 * If the nested integer is a list, we calculate the sum of this list recursively using the same process but with depth d+1.
	 * */
	public int depthSum(List<NestedInteger> nestedList) {
		if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
         
        return helper(nestedList.iterator(), 1);
    }
	 
	private int helper(Iterator<NestedInteger> iterator, int depth) {
		int sum = 0;
		
		while (iterator.hasNext()) {
			NestedInteger cur = iterator.next();
			if (cur.isInteger()) {
				sum += depth * cur.getInteger();
			} else {
				sum += helper(cur.getList().iterator(), depth+1);
			}
		}
		return sum;
	}
	
	
	
	
	/////////solution 2///////////
	// Another solution without passing an iterator:
	
	public int depthSum2(List<NestedInteger> nestedList) {
	    return depthSum(nestedList, 1);
	}
	 
	public int depthSum(List<NestedInteger> list, int depth) {
	    int sum = 0;
	    for (NestedInteger n : list) {
	        if (n.isInteger()) {
	            sum += n.getInteger() * depth;
	        } else {
	            sum += depthSum(n.getList(), depth + 1);
	        }
	    }
	    return sum;
	}
}




