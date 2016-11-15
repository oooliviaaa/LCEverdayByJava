package LLLLLLLLL;

import java.util.Iterator;
import java.util.List;

public class NestedListWeightSum {

	
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
}


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