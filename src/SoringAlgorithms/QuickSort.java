package SoringAlgorithms;

/* Each partitioning operation takes O(n) operations (one pass on the array). 
 * In average, each partitioning divides the array to two parts (which sums up to log n operations). 
 * In total we have O(n * log n) operations.
I.e. in average log n partitioning operations and each partitioning takes O(n) operations. */

public class QuickSort {
	
	public void sort(int[] input){
		quicksort(input, 0, input.length - 1);
	}
	
	private void quicksort(int[] input, int start, int end){
		
		if (start >= end) return;
		int original = partition(input, start, end); // select the first num as the reference
		quicksort(input, original + 1, end);  // the bound is getting smaller, till final remain only 1 num in each side, then the sorting finished.
		quicksort(input, start, original - 1);
		
	}
	
	private int partition(int[] input, int start, int end){
		
		int x = input[start];  // x is the pivot for each round of sorting.
		int slow = start;
		int fast = start+1;
		
		while(fast <= end){
			
			if (input[fast] < x){
				slow++;
				switchNum(input, fast, slow);
			}
			else{
				continue;
			}
			fast++;
			
		}
		switchNum(input, slow, start);  //when 1 round of sorting is finished, switch the position of pivot (x) - 'start' and the smaller index - 'slow'.
		return start;  // return slow??? --> pivot
	}
	
	private void switchNum(int[] input, int fast, int slow){
		
		int temp;
		temp = input[fast];
		input[fast] = input[slow];
		input[slow] = temp;
	}

}
