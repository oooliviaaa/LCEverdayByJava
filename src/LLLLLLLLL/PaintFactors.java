package LLLLLLLLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PaintFactors {

	public void factors(int n) {
        Set<String> res = new TreeSet<String>();
        helper(n, new ArrayList<Integer>(), res);
 
        for (String r : res) {
            System.out.println(r);
        }
    }
 
    public void helper(int n, List<Integer> tmp, Set<String> res) {
        if (n == 1) {
        	if (tmp.size() == 1) {
				res.add(tmp.get(0) + " * 1");
			} else {
				Collections.sort(tmp, Collections.reverseOrder());
	            StringBuffer sb = new StringBuffer();
	            for (int t : tmp) {
	                sb.append(" * ");
	                sb.append(t);
	            }
	            res.add(sb.toString().substring(3));
	            return;
			}
        }
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                tmp.add(i);
                helper(n / i, tmp, res);
                tmp.remove(Integer.valueOf(i));
            }
        }
        
    }
    
    public static void main(String[] args) {
    	PaintFactors f = new PaintFactors();
		f.factors(24);
	}
}
