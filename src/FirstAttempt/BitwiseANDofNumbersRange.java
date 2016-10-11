package FirstAttempt;

public class BitwiseANDofNumbersRange {

	// http://blog.csdn.net/kangrydotnet/article/details/45099051
	/**
	 * 结果其实就是m和n公共头部。
	 * 例子中5的二进制为101,7的二进制位111，其公共头部为100。再如，若计算3到5的按位或，3的二进制位11，5的二进制位101，没有公共头部，返回0。
	 * */
	public int rangeBitwiseAnd(int m, int n) {
        if (m > n) return 0;
        
        int i = 0;
        while (m != n && m != 0) {
        	m >>= 1;
        	n >>= 1;
        	i++;
        }
        
        return m << i;
    }
}
