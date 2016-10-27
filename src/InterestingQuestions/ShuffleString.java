package InterestingQuestions;

import java.util.Random;

public class ShuffleString {

	// 水塘抽样
	public String solution(String s) {
		char[] c = s.toCharArray();
		Random r = new Random();
		
		for (int i = 0; i < c.length; i++) {
			int nextIndex = r.nextInt(c.length-i);
			char tmp = c[i];
			c[i] = c[i+nextIndex];
			c[i+nextIndex] = tmp;
		}
		return new String(c); // 或者 String.valueOf(charArrays);
	}
	
	
	public static void main(String[] args) {
		String s = "abcdefg";
		ShuffleString ss = new ShuffleString();
		String res = ss.solution(s);
		
		System.out.println(res);
	}
}
