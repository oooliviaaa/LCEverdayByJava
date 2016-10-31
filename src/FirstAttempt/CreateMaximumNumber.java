package FirstAttempt;

public class CreateMaximumNumber {

	// https://discuss.leetcode.com/topic/32272/share-my-greedy-solution
	// https://discuss.leetcode.com/topic/56501/java-solution-with-comments-inspired-by-dietpepsi
	// greedy
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int [] res = new int[k];
        
        for (int size1 = 0; size1 <= k; size1++) {  // i表示num1的size
        	int size2 = k - size1;
        	if (size1 <= nums1.length && size2 <= nums2.length) {
        		int[] merged = maxMerge(findMaxArray(nums1, size1), findMaxArray(nums2, size2));
        		if (isGreater(merged, 0, res, 0)) {
        			res = merged;
        		}
        	}
        }
        return res;
    }
	
	private int[] findMaxArray(int[] array, int size) {
		int[] res = new int[size];
		int toFillIndex = 0;  // toFillIndex是指针，指向res下一个该填入的位置
		for (int i = 0; i < array.length; i++) {
			int cur = array[i];
			int j = toFillIndex;  // 如果cur比较大，j从toFillIndex-1向前找，找到可以替换掉的位置，但是要保证之后剩余的数字个数还足以形成长度为size的array作为result返回
			while (j > 0 && res[j-1] < cur && array.length-i >= size-(j-1)) {
				j--;
			}
			
			if (j < size) {
				res[j] = cur;
				toFillIndex = j+1;
			}
		}
		return res;
	}
	
	// merge two number arrays to create a maximum number array
    // want to use digits from the array with the higher lexicographical order
	private int[] maxMerge(int[] a1, int[] a2) {
		int[] res = new int[a1.length + a2.length];
		int i = 0, j = 0, k = 0;
		while (k < res.length) {
			res[k++] = isGreater(a1, i, a2, j) ? a1[i++] : a2[j++];
		}
		return res;
	}
	
    // compare which array contains a larger number, returns < 0 if arr1 < arr2, == 0 if equal, > 0 if arr1 > arr2
	private boolean isGreater(int[] arr1, int i, int[] arr2, int j) {
		while (i < arr1.length && j < arr2.length && arr1[i] == arr2[j]) {
            i++;
            j++;
        }
        // arr1 is lexicographically greater if it has a longer length, or  has a digit greater than the digit as same place in arr2
        return i < arr1.length && j == arr2.length || (i < arr1.length && j < arr2.length && arr1[i] > arr2[j]);
	}
}
