package SortingAlgorithms;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args){
		int[] input = new int[]{4,5,2,6,1,9,8,3,7,0};
		mergesort(input);
		for(int i : input){
			System.out.print(i + " ");
		}
	}

	private static void mergesort(int[] input) {
		int len = input.length;
		int[] tmp = new int[len];
		sort(input, tmp, 0, len - 1);
		
	}

	private static void sort(int[] input, int[] tmp, int bg, int ed) {
		
		// Step 1. split till 2 element as a pair
		if(bg >= ed) return;  // when to stop
		
		int mid = (bg + ed) / 2;  // need to find the mid every time
		
		sort(input, tmp, bg, mid);
		sort(input, tmp, mid + 1, ed);
		
		// Step 2. merge
		// read in the whole part array, from bg to ed, deepcopy  // tmp = Arrays.copyOf(input, input.length);
		for(int i = bg; i <= ed; i++){
			tmp[i] = input[i];
		}
		
		//start to merge two sorted array to input. take tmp as reference
		int p = bg; // 1st array starts here
		int q = mid + 1; // 2nd array starts here
		int index = bg; // input array index
		while(p <= mid && q <= ed){
			if(tmp[p] < tmp[q]){
				input[index] = tmp[p];
				p++;
			}
			else{
				input[index] = tmp[q];
				q++;
			}
			index++;
		}
		
		if(p <= mid && q > ed){ // 1st part is not finished
			while(p <= mid){
				input[index++] = tmp[p++];
			}
			
		}
		
		if(p > mid && q <= ed){ // 2nd part is not finished
			while(q <= ed){
				input[index++] = tmp[q++];
			}
		}
	
	}
}
