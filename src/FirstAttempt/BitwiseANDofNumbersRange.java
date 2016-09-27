package FirstAttempt;

public class BitwiseANDofNumbersRange {

	// http://blog.csdn.net/kangrydotnet/article/details/45099051
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
