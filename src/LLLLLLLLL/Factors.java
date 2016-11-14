package LLLLLLLLL;

import java.util.ArrayList;
import java.util.List;

public class Factors {

	public List<String> getFactors(int n) {
        List<String> res = new ArrayList<String>();
		
		dfs(2, n, 1, new ArrayList<Integer>(), res);
		return res;
    }
	
	private void dfs(int start, int n, int product, List<Integer> tmp, List<String> res) {
		if (product > n || start > n) return;
		
		if (product == n) {
			String output = "";
            for (Integer f : tmp) {
                output += " * " + f;
            }
			res.add(output);
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
}
