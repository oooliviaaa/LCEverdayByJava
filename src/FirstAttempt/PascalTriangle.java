package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (numRows == 0) {
			return res;
		}
		
		for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<Integer>();
			row.add(1);
			for (int j = 1; j < i; j++) {  // skip the 1st and 2nd row, only 3rd+ rows will go into here !!!!!
				List<Integer> preRow = res.get(i-1);
				row.add(preRow.get(j-1) + preRow.get(j));
			}
			if (i != 0) {  // except 1st row, add a "1" to the end
				row.add(1);
			}
			res.add(row);
		}
		return res;
    }
}
