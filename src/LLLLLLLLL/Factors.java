package LLLLLLLLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Factors {

	public Set<String> getFactors(int n) {
        Set<String> res = new TreeSet<String>();
		
		dfs(2, n, 1, new ArrayList<Integer>(), res);
		return res;
    }
	
	private void dfs(int start, int n, int product, List<Integer> tmp, Set<String> res) {
		if (product > n || start > n) return;
		
		if (product == n) {
			if (tmp.size() == 1) {
				res.add(tmp.get(0) + " * 1");
			}
			else {
				Collections.sort(tmp, Collections.reverseOrder());
				String s = "";
	            for (Integer f : tmp) {
	                s += " * " + f;
	            }
				res.add(s.substring(3));
			}
			return;
		}
		
		for (int i = start; i <= n; i++) {
			if (i * product > n) {
				break;
			}
			
			if (n % i == 0) {
				tmp.add(i);
				dfs(i, n, product*i, tmp, res);   ///// 可以重复，所以start还是从i开始
				tmp.remove(tmp.size()-1);
			}
		}
    }
	
	public static void main(String[] args) {
		Factors f = new Factors();
		Set<String> res = f.getFactors(24);
		System.out.println(res);
	}
}
