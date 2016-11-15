package LLLLLLLLL;

public class SortStringLexicographically {

	
	public static String solution(String input) {
		StringBuffer sb = new StringBuffer();
		int[] count = new int[26];
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			count[c-'a'] += 1;
		}
		
		for (int i = 0; i < 26; i++) {
			int num = count[i];
			char c = (char)('a' + i);
			for (int j = 0; j < num; j++) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String input = "ddfebazap";
		String res = solution(input);
		System.out.println(res);
	}
}
