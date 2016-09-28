package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		dfs(k, 1, new ArrayList<Integer>(), n, res);
		return res;
    }
	
	private void dfs(int k, int index, List<Integer> tmp, int n, List<List<Integer>> res) {
		if (tmp.size() == k && n == 0) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		
		if (n < 0 || tmp.size() > k) return;
		
		for (int i = index; i <= 9; i++) {
			if (!tmp.contains(i)) {
				tmp.add(i);
				dfs(k, i+1, tmp, n-i, res);
				tmp.remove(tmp.size()-1);
			}
		}
	}
}
