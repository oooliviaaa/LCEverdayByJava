package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {

	// http://www.programcreek.com/2014/05/leetcode-integer-to-english-words-java/
	Map<Integer, String> hm;
	
	public IntegerToEnglishWords() {
		hm = new HashMap<Integer, String>();
		hm.put(0, "Zero");
		hm.put(1, "One");
		hm.put(2, "Two");
		hm.put(3, "Three");
		hm.put(4, "Four");
        hm.put(5, "Five");
        hm.put(6, "Six");
        hm.put(7, "Seven");
        hm.put(8, "Eight");
        hm.put(9, "Nine");
        hm.put(10, "Ten");
        hm.put(11, "Eleven");
        hm.put(12, "Twelve");
        hm.put(13, "Thirteen");
        hm.put(14, "Fourteen");
        hm.put(15, "Fifteen");
        hm.put(16, "Sixteen");
        hm.put(17, "Seventeen");
        hm.put(18, "Eighteen");
        hm.put(19, "Nineteen");
        hm.put(20, "Twenty");
        hm.put(30, "Thirty");
        hm.put(40, "Forty");
        hm.put(50, "Fifty");
        hm.put(60, "Sixty");
        hm.put(70, "Seventy");
        hm.put(80, "Eighty");
        hm.put(90, "Ninety");
	}
	
	
	public String numberToWords(int num) {
		StringBuffer sb = new StringBuffer();
		
		if (num == 0) return hm.get(0);
		
		if (num >= 1000000000) {
			int count = num / 1000000000;
			sb.append(getDetailNumbers(count) + " Billion");   ///// 别忘了补空格
			num %= 1000000000;
		}
		
		if (num >= 1000000) {
			int count = num / 1000000;
			sb.append(getDetailNumbers(count) + " Million");
			num %= 1000000;
		}
		
		if (num >= 1000) {
			int count = num / 1000;
			sb.append(getDetailNumbers(count) + " Thousand");
			num %= 1000;
		}
		
		if (num > 0) {
			sb.append(getDetailNumbers(num));
		}
		return sb.toString().trim();
    }


	private String getDetailNumbers(int num) {
		StringBuffer sb = new StringBuffer();
		
		if (num >= 100) {
			int count = num / 100;
			sb.append(" " + hm.get(count) + " Hundred");
			num %= 100;
		}
		
		if (num > 20) {             //////// 注意此处的条件是20，因为hm里面20以上就只有几十几十的了。
			int count = num / 10;
			sb.append(" " + hm.get(count * 10));
			num %= 10;
		}
		
		if (num > 0) {   ///// 别忘了!!!!!
			sb.append(" " + hm.get(num));
		}
		
		return sb.toString();
	}
}
