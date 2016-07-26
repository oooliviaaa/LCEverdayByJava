package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class Combination {

	public List<ArrayList<Integer>> combine(int n, int k) {
        List<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        helper(0, 1, n, k, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void helper(int count, int i, int n, int k, ArrayList<Integer> tmp, List<ArrayList<Integer>> res) {
        if (count == k) {
            ArrayList<Integer> newTmp = new ArrayList<Integer>(tmp.size());
            for (int t : tmp) newTmp.add(t);   // or using: res.add(new ArrayList<Integer>(tmp));
            res.add(newTmp);
            return;
        }
        
        for (int c = i; c <= n; c++) {
            tmp.add(c);
            helper(count+1, c+1, n, k, tmp, res);
            tmp.remove(tmp.size()-1);
        }
    }
	
    
    public static void main(String[] args) {
    	Combination c = new Combination();
    	List<ArrayList<Integer>> res = c.combine(5, 2);
    	
    	for (ArrayList<Integer> al : res) {
    		for (int i : al) {
    			System.out.print(i + " ");
    		}
    		System.out.println(" ");
    	}
    }
}
