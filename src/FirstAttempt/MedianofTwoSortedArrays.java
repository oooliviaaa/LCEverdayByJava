package FirstAttempt;

public class MedianofTwoSortedArrays {

	//http://fisherlei.blogspot.com/2012/12/leetcode-median-of-two-sorted-arrays.html   --> the image is inspiring
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;

        //////////Remember
        if(len % 2 == 0) {  // even num
        	return (findKth(nums1, nums2, 0, 0, len/2) + findKth(nums1, nums2, 0, 0, len/2+1)) / 2.0;
        } 
        else {  // odd num
        	return findKth(nums1, nums2, 0, 0, len/2+1);
        }
    }
	
	public double findKth(int[] num1, int[] num2, int a, int b, int k) {
		if(a >= num1.length) return num2[b+k-1];
		if(b >= num2.length) return num1[a+k-1];
		
		if(k == 1) return Math.min(num1[a], num2[b]);
		
		// get the No.k/2 number in each array
		int key1 = a + k/2 - 1 < num1.length ? num1[a + k/2 - 1] : Integer.MAX_VALUE; 
		int key2 = b + k/2 - 1 < num2.length ? num2[b + k/2 - 1] : Integer.MAX_VALUE;
		
		if(key1 > key2) { // the kth biggest number won't happen in num2[0 ~ k/2 -1], so abandon num2[0 ~ k/2 -1], num2 index starts from b + k/2
			return findKth(num1, num2, a, b + k/2, k - k/2);
		}
		else {   // the kth biggest number won't happen in num1[0 ~ k/2 -1], so abandon num1[0 ~ k/2 -1]
			return findKth(num1, num2, a + k/2, b, k - k/2);
		}
	}

}
