package FirstAttempt;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Flatten2DVector implements Iterator<Integer> {
	// use array for help
	// method 1 in https://segmentfault.com/a/1190000003791233
	
	
	// only use iterator
	// http://buttercola.blogspot.com/2015/08/leetcode-flatten-2d-vector.html
	
	Iterator<List<Integer>> outer;
    Iterator<Integer> inner;
    
    public Flatten2DVector(List<List<Integer>> vec2d) {
    	outer = vec2d.iterator();
        inner = Collections.emptyIterator(); //inner = outer.iterator(); wrong: if outer is null, then exception !!!!!
    }
    
    public boolean hasNext() {
        if (inner.hasNext()) return true;
        if (!outer.hasNext()) return false; // inner doesn't have next, also outer doesn't either, so return false
        
        while (!inner.hasNext() && outer.hasNext()) {
        	inner = outer.next().iterator();  // find the next not-null List<Integer>, until there's not more list
        }
        return inner.hasNext();
    }

    public Integer next() {
        return inner.next();    // hasNext() will make sure there's a next exists
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */