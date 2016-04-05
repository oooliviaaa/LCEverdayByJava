package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public List<ArrayList<String>> solveNQueens(int n) {
		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		
		int[] record = new int[n];
		DFSHelper(0, n, record, res);
		
		return res;
    }
	
	private void DFSHelper(int row, int n, int[] record, List<ArrayList<String>> res) {
		
	}
}
