package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {

	// http://www.programcreek.com/2014/07/leetcode-factor-combinations-java/
	// dfs
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		dfs(2, n, 1, new ArrayList<Integer>(), res);
		return res;
    }
	
	private void dfs(int start, int n, int product, List<Integer> tmp, List<List<Integer>> res) {
		if (product > n || start > n) return;   ///// !!!!
		
		if (product == n) {
			List<Integer> t = new ArrayList<Integer>(tmp);
			res.add(t);
			return;
		}
		
		for (int i = start; i < n; i++) {
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
}
