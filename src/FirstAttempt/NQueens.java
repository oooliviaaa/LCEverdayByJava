package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public List<String[]> solveNQueens(int n) {
		List<String[]> res = new ArrayList<String[]>();
		
		int[] record = new int[n];
		DFSHelper(0, n, record, res);
		
		return res;
    }
	
	private void DFSHelper(int row, int n, int[] record, List<String[]> res) {
		if(row == n) {
			String[] unit = new String[n];
			for(int i = 0; i < n; i++) {
				int queen = record[i];
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < n; j++) {
					if(j == queen) sb.append("Q");
					else sb.append(".");
				}
				unit[i] = sb.toString();
			}
			res.add(unit);
		}
		else {
			for(int i = 0; i < n; i++) {
				record[row] = i;
				if(isValid(record, row)) {
					System.out.println("valid!" + row);
					DFSHelper(row+1, n, record, res);
				}
			}
		}
	}
	
	private boolean isValid(int[] record, int row) {
		int pos = record[row];

		for(int j = 0; j < row; j++) {
			if(record[j] == pos || Math.abs(record[j] - pos) == row - j) 
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		NQueens nq = new NQueens();
		List<String[]> res = nq.solveNQueens(3);
		for(String[] unit : res) {
			for(String s : unit) System.out.print(s + " ");
			System.out.println();
		}
	}
}
