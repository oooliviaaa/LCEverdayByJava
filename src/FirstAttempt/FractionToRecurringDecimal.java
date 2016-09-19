package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

	// http://blog.csdn.net/ljiabin/article/details/42025037
	/**
	 * 难点：如何识别循环体？
	 * 解决方法：用一个HashMap记录每一个余数，当出现重复的余数时，那么将会进入循环，两个重复余数之间的部分就是循环体。
	 * */
	public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        if (denominator == 0) return "";
        
        String res = "";
        
        //如果结果为负数
        if ((numerator < 0) ^ (denominator < 0)) {  
            res += "-";  
        } 
        
        //下面要把两个数都转为正数，为避免溢出，int转为long  
        long num = numerator, den = denominator;  
        num = Math.abs(num);  
        den = Math.abs(den);
        
        //结果的整数部分  
        long inte = num / den;  
        res += inte;
        
        long rem = (num % den) * 10; ///// 别忘记乘上10 !!!!! 要把余数转化成比den大的数才能进一步对整数做除法
        if (rem == 0) return res;
        
        res += ".";
        
        Map<Long, Integer> hm = new HashMap<Long, Integer>();  ///// 用来记录出现的余数和他出现的位置
        while (rem != 0) {
        	// 如果前面已经出现过该余数，那么将会开始循环  
        	if (hm.containsKey(rem)) {
        		int pre = hm.get(rem);
        		
        		String part1 = res.substring(0, pre);
        		String part2 = res.substring(pre);
        		res = part1 + "(" + part2 + ")";
        		return res;
        	} else {
        		hm.put(rem, res.length());
        		inte = rem / den;
        		rem = (rem % den) * 10;  ///// 别忘记乘上10 !!!!!
        		res += inte;
        	}
        }
        
        return res;
    }
}
