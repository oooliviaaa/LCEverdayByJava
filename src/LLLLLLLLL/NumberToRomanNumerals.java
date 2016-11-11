package LLLLLLLLL;

public class NumberToRomanNumerals {

	int[] nums;
	String[] symbols;
	
	public NumberToRomanNumerals() {
		nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};						 /////// pay attention to this array!!!
	    symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	}
	
	public String intToRoman(int num) {
		StringBuffer sb = new StringBuffer();
		int index = 0;
		while (num > 0) {
			int factor = nums[index];
			int time = num / factor;
			num -= factor * time;
			for (int i = 0; i < time; i++) {
				sb.append(symbols[index]);
			}
			index++;
		}
		return sb.toString();
	}
}
