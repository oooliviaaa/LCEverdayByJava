package LLLLLLLLL;

import java.util.Arrays;

public class MultiDimensionArraySum {

	
	public int arraySum(MultiDimArray m, int[] dimensions) {
	    int dimension = dimensions.length;
	    int index = dimension - 1;
	    int res = 0;
	    
	    int[] position = new int[dimension];
	    Arrays.fill(position, 0);
	    
	    boolean needStartAgain = false;
	    
	    while (true) {
	    	
	    	if (position[index] == dimensions[index]) {
	    		position[index] = 0;
	    		
	    		index--;
		    	if (index < 0) break;
	    		position[index]++;
	    		needStartAgain = true;
	    	} else {
	    		res += m.get(position);
	    		position[index]++;
	    		
	    		if (needStartAgain) {
	    			index = dimension - 1;
	    			needStartAgain = false;
	    		}
	    	}
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		MultiDimArray m = new MultiDimArray();
		MultiDimensionArraySum md = new MultiDimensionArraySum();
		int[] dimensions = {3,3,3};
		int res = md.arraySum(m, dimensions);
		System.out.println(res);
	}
}

class MultiDimArray {
    int get(int[] position) {
    	return 1;
    }
}