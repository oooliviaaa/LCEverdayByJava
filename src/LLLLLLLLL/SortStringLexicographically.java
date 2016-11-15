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
	
	
	//////////////////
	String sortString(String input) {
	    if (input==null || input.length() <= 1) return input;
	    int[] count = new int[26];
	    for (int i=0; i<input.length(); i++) {
	        count[input.charAt(i)-'a']++;
	    }
		StringBuilder sb = new StringBuilder();
		for (char c='a'; c <='z'; c++) {
		    for (int j = 0; j<count[c-'a']; j++)
	            sb.append(c);
	    }
	    return sb.toString();
	}
	
	
	
	public static void main(String[] args) {
		String input = "ddfebazap";
		String res = solution(input);
		System.out.println(res);
	}
}
