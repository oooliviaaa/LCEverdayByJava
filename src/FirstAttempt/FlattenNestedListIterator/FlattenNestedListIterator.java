package FirstAttempt.FlattenNestedListIterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator implements Iterator<Integer> {

	// https://segmentfault.com/a/1190000005339301
	
	Stack<NestedInteger> st = new Stack<NestedInteger>();
	
	public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size()-1; i >= 0; i--) {
        	st.push(nestedList.get(i));      //////////////  reverse push in   !!!!!
        }
    }

    public Integer next() {
        return st.pop().getInteger();
    }

    public boolean hasNext() {
        while (!st.isEmpty()) {
        	NestedInteger cur = st.peek();
        	if (cur.isInteger()) {
        		return true;
        	} else {
        		cur = st.pop();
        		for (int i = cur.getList().size()-1; i >= 0; i--) {
        			st.push(cur.getList().get(i));    //////////////  reverse push in   !!!!!
        		}
        	}
        }
        return false;
    }
}



/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */