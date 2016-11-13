package LLLLLLLLL;

public class BubbleSort {

	void bubbleSort(int[] array) {
	  int count;
	 
	  do {
		  count = 0;
	 
	    for (int i = 1; i < array.length; i++) {
	      if (array[i-1] > array[i]) {
	    	  // swap
	    	  int tmp = array[i-1];
	    	  array[i-1] = array[i];
	    	  array[i] = tmp;
	    	  
	    	  count++;
	      }
	    }
	  } while (count > 0);
	}
}
