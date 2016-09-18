package FirstAttempt;

public class SumOfTwoIntegers {

	/**
	 * http://www.programcreek.com/2015/07/leetcode-sum-of-two-integers-java/
	 * a&b returns the number formed by '1' bits on a and b. When it is left shifted by 1 bit, it is the carry.
	 * For example, given a=101 and b=111 (in binary), the a&b=101. a&b << 1 = 1010.
	 * a^b is the number formed by different bits of a and b. a^b=10.
	 * 
	 * 	https://www.hrwhisper.me/leetcode-sum-two-integers/
	 * 异或也被称为“模2和” 
	 * a ^ b 直接算出a + b 每位上%2的结果， 进位的话可以直接 (a & b)<<1得到（只有两个位均为1才会进位嘛，左移表示进到下一位啊）
	 * */
	public int getSum(int a, int b) {
		while (b != 0) {  // carry 不为0时
			int c = a & b; //carry
			a ^= b; //add 
			b = c << 1;
		}
		return a;
    }
}
