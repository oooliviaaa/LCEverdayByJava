package FirstAttempt;

public class CountingBits {
	
	// https://www.hrwhisper.me/leetcode-counting-bits/
	public int[] countBits(int num) {
		int[] res = new int[num+1];
		res[0] = 0;
		int pow2 = 1;
		int before = 1;
		
		for (int i = 1; i <= num; i++) {
			if (i == pow2) {  // i is 2^n
				res[i] = 1;   // i must be 100...0
				before = 1;   // next i = i + 1, i + 2, i + 3......
				pow2 <<= 1;
			} else {
				res[i] = 1 + res[before];
				before++;
			}
		}
		return res;
	}
	
	// solution 2
	
	public int[] countBits2(int num) {
        int[] res = new int[num+1];
        for(int i=1;i<=num;i++){
            res[i] = res[i >> 1] + (i & 1);
         // eg. 15 = 7 * 2 + 1; 14 = 7 * 2 + 0
        }
        return res;
    }
}
