package LLLLLLLLL;

public class FindMedium {

	public int findMedium(int[] a, int[] b) {
		int len = a.length + b.length;

        if(len % 2 == 0) {  // even num
        	return (findKth(a, b, 0, 0, len/2) + findKth(a, b, 0, 0, len/2+1)) / 2;
        } 
        else {  // odd num
        	return findKth(a, b, 0, 0, len/2+1);
        }
    }
	
	public int findKth(int[] num1, int[] num2, int a, int b, int k) {
		if(a >= num1.length) return num2[b+k-1];
		if(b >= num2.length) return num1[a+k-1];
		
		if(k == 1) return Math.min(num1[a], num2[b]);
		
		int key1 = a + k/2 - 1 < num1.length ? num1[a + k/2 - 1] : Integer.MAX_VALUE; // get the No.k/2 number in each array
		int key2 = b + k/2 - 1 < num2.length ? num2[b + k/2 - 1] : Integer.MAX_VALUE;
		
		if(key1 > key2) { // the kth biggest number won't happen in num2[0 ~ k/2 -1], so abandon num2[0 ~ k/2 -1], num2 index starts from b + k/2
			return findKth(num1, num2, a, b + k/2, k - k/2);
		}
		else {   // the kth biggest number won't happen in num1[0 ~ k/2 -1], so abandon num1[0 ~ k/2 -1]
			return findKth(num1, num2, a + k/2, b, k - k/2);
		}
	}
}
