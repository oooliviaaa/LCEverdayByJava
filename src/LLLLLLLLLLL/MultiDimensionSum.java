package LLLLLLLLLLL;

public class MultiDimensionSum {

	public int arraySum (MultiDimArray m, int[] dimensions) {
	    int dim = dimensions.length - 1;  // 指向当前触及到的最高位
	    int[] cur = new int[dimensions.length];
	    int sum = 0;
	    
	    
	    while (dim >= 0) {
	    	int index = dimensions.length - 1; // 指向当前正在进行变动的位
	    	while (true) {
	    		if (cur[index] == dimensions[index]) {
		    		cur[index] = 0;
		    		index--;
		    		if (index < dim) {
		    			dim--;
		    			break;
		    		}
		    		cur[index]++;
		    	} else {
		    		sum += m.get(cur);
		    		cur[index]++;
		    	}
	    	}
	    }
	    return sum;
	}
	
	
	public static void main(String[] args) {
		MultiDimArray m = new MultiDimArray();
		MultiDimensionSum md = new MultiDimensionSum();
		int[] dimensions = {3,3,3};
		int res = md.arraySum(m, dimensions);
		System.out.println(res);
	}
}

class MultiDimArray {
    int get(int[] indices) {
    	return 1;
    }
}
