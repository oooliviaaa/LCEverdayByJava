package FirstAttempt;

public class FactorialTrailingZeroes {

	// https://segmentfault.com/a/1190000003803118
	// logarithmic time complexity
	/**
	 * 2 * 5 = 10, 其实只要数5的个数就好了，因为2实在是比5要多的多.
	 * 还有一件事情要考虑。诸如25，125之类的数字有不止一个5。
	 * 例如，如果我们考虑28!，我们得到一个额外的5，并且0的总数变成了6。
	 * 处理这个问题也很简单，首先对n÷5，移除所有的单个5，然后÷25，移除额外的5，以此类推
	 * */
	public int trailingZeroes(int n) {
		if (n < 0) return -1;
        
		int res = 0;
        while(n > 0){
            // 阶乘中有多少5，结果就有多少个0
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
