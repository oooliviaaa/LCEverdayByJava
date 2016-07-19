package InterestingQuestions;

public class FindNumMoreThanOneFourthTimes {

	
	public int findNum(int[] input) {
		int len = input.length;
		return findHelper(input, len/4, 0, len-1);
	}
	
	private int findHelper(int[] input, int thresh, int i, int j) {
		int m = (i + j) / 2;
		int num = input[m];
		int[] range = getNumRange(input, num);
		if (range[1] - range[0] + 1 >= thresh) {
			return num;
		}
		if (range[0] - i + 1 >= thresh) {
			return findHelper(input, thresh, i, range[0]-1);
		}
		if (j - range[1] + 1 >= thresh) {
			return findHelper(input, thresh, range[1]+1, j);
		}
		return -1;
	}
	
	private int[] getNumRange(int[] A, int target) {
		if (A.length == 0) {
            return new int[]{-1, -1};
        }
        
        int start, end, mid;
        int[] bound = new int[2]; 
        
        // search for left bound
        start = 0; 
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] == target) {
            bound[0] = start;
        } else if (A[end] == target) {
            bound[0] = end;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }
        
        // search for right bound
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            bound[1] = end;
        } else if (A[start] == target) {
            bound[1] = start;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }
        
        return bound;
	}
	
	public static void main(String[] args) {
		FindNumMoreThanOneFourthTimes fm = new FindNumMoreThanOneFourthTimes();
		int[] input = new int[]{1,2,2,2,3,3,3,3,3,3,4,5,6,7,8,8,9,9};
		
		int res = fm.findNum(input);
		System.out.println(res);
	}
}
