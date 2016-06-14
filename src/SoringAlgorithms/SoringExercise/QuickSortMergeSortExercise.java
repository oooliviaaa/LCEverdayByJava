package SoringAlgorithms.SoringExercise;

import java.util.Arrays;

public class QuickSortMergeSortExercise {
	public static void main(String[] args) {
		int[] input = new int[]{2,5,3,7,1,0};
		quickSort(input);
		for(int i : input) System.out.println(i);
		
		System.out.println("~~~~~");
		
		int[] input2 = new int[]{2,5,3,7,1,0};
		mergeSort(input2);
		for(int i : input2) System.out.println(i);
	}
	
	/**
	 * Quick sort
	 * */
	
	public static void quickSort(int[] input) {
		sort(input, 0, input.length-1);
	}
	
	public static void sort(int[] input, int start, int end) {
		if (start >= end) {
			return;
		}
		
		int part = partition(input, start, end);
		sort(input, part+1, end);
		sort(input, start, part-1);
	}
	
	private static int partition(int[] input, int start, int end) {
		int pivot = input[start];
		
		int i = start;
		int j = start + 1;
		
		while (j <= end) {
			if (input[j] < pivot) {
				i++;
				swap(input, i, j);
			}
			j++;
		}
		swap(input, start, i);
		return i;
	}
	
	private static void swap(int[] input, int i, int j) {
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}
	
	/**
	 * Merge sort
	 * */
	
	public static void mergeSort(int[] input) {
		int[] tmp = new int[input.length];
		sort(input, tmp, 0, input.length-1);
	}
	
	public static void sort(int[] input, int[] tmp, int start, int end) {
		if (start >= end) {
			return;
		}
		
		int mid = (start + end) / 2;
		sort(input, tmp, start, mid);
		sort(input, tmp, mid+1, end);
		
		// start merging two sorted part
		
		// make deep copy
		tmp = Arrays.copyOf(input, input.length);
		
		int p = start;
		int q = mid+1;
		int i = p;
		
		while(p <= mid && q <= end) {
			if (tmp[p] < tmp[q]) {
				input[i++] = tmp[p++];
			} else {
				input[i++] = tmp[q++];
			}
		}
		
		while (p <= mid) {
			input[i++] = tmp[p++];
		}
		
		while (q <= end) {
			input[i++] = tmp[q++];
		}
	}
}
