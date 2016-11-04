package FirstAttempt;

public class NthDigit {

	// http://www.programcreek.com/2014/09/leetcode-nth-digit-java/
	public int findNthDigit(int n) {
        long m = n;  // convert int to long 
        
        long first = 1;
        long len = 1;
        long count = 9;
        
        while (m > count * len) {
        	m -= count * len;
        	len++;
        	
        	count *= 10;
        	first *= 10;
        }
        
        // identify the number, 找出到底到哪个数了
        long num = first + (m-1) / len;
        
        // identify 是该数的第几位
        int index = (int) ((m-1) % len);
        
        return String.valueOf(num).charAt(index) - '0';
    }
}
