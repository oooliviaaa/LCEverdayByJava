package FirstAttempt;

public class UglyNumber {

	// https://segmentfault.com/a/1190000003480992
	/**
	 * 根据丑陋数的定义，我们将给定数除以2、3、5，直到无法整除，也就是除以2、3、5的余数不再为0时停止。
	 * 这时如果得到1，说明是所有因子都是2或3或5，如果不是1，则不是丑陋数。
	 * */
	public boolean isUgly(int num) {
        if (num == 0) return false;
        
        int rem2 = num % 2;
        int rem3 = num % 3;
        int rem5 = num % 5;
        while(rem2 == 0 || rem3 == 0 || rem5 == 0){
            if(rem2 == 0){
                num = num / 2;
            } else if(rem3 == 0){
                num = num / 3;
            } else {
                num = num / 5;
            }
            rem2 = num % 2;
            rem3 = num % 3;
            rem5 = num % 5;
        }
        return num == 1;
    }
}
