package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

	// mine way: 2个lists来回倒，直到倒到第k个
	public List<Integer> getPascalRow(int rowIndex) {
        List<Integer> pre;
        List<Integer> cur = new ArrayList<Integer>();
        cur.add(1);
        if (rowIndex == 0) return cur;
        for (int i = 0; i <= rowIndex; i++) { // iterate rowIndex times
        	pre = new ArrayList<Integer>(cur);
        	cur.clear();
        	cur.add(1);
        	for (int j = 1; j < i; j++) {
        		cur.add(pre.get(j-1) + pre.get(j));
        	}
        	cur.add(1);
        }
        return cur;
    }
	
	
	///////////////////////////
	// better way: 只用一个list，从后往前加新的
	public List<Integer> getRow(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>();
	 
		if (rowIndex < 0)
			return result;
	 
		result.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = result.size() - 2; j >= 0; j--) {
				result.set(j + 1, result.get(j) + result.get(j + 1));   // set at position j+1
			}
			result.add(1);
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		PascalTriangleII pt2 = new PascalTriangleII();
		List<Integer> res = pt2.getPascalRow(1);
		for (int i : res) {
			System.out.println("result --> " + i);
		}
	}
}
