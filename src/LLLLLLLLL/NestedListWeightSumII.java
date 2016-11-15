package LLLLLLLLL;

import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSumII {

	// https://discuss.leetcode.com/topic/49041/no-depth-variable-no-multiplication
	//  Instead of multiplying by depth, add integers multiple times 
	// (by going level by level and adding the unweighted sum to the weighted sum after each level).
	public int depthSumInverse(List<NestedInteger> nestedList) {
        int preSum = 0;
        int curSum = 0;
        while (!nestedList.isEmpty()) {
        	List<NestedInteger> newList = new ArrayList<NestedInteger>();
        	for (NestedInteger element : nestedList) {
        		if (element.isInteger()) {
        			curSum += element.getInteger();
        		} else {
        			List<NestedInteger> tmp = element.getList();
        			newList.addAll(tmp);
        		}
        	}
        	preSum += curSum;
        	nestedList = newList;
        }
        return preSum;
    }
}
