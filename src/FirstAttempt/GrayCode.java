package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<Integer>();
		
		int max = 1 << n;
		for (int i = 0; i < max; i++) {
			res.add(i ^ (i>>n));
		}
		return res;
	}
}
