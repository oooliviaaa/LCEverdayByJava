package FirstAttempt;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public String largestNumber(int[] nums) {
        String[] note = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
        	note[i] = "" + nums[i];
        }
        
        Arrays.sort(note, new Comparator<String>() {
			public int compare(String a, String b) {
				return (b+a).compareTo(a+b); ///// String combination由大到小排序 !!!!!
			}
        });
        
        StringBuffer sb = new StringBuffer();
        for (String s : note) {
        	sb.append(s);
        }
        
        while (sb.charAt(0) == '0' && sb.length() > 1) {  ////// 移除最前面的0们 !!!!!
        	sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
