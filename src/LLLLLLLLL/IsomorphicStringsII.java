package LLLLLLLLL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsomorphicStringsII {

	// follow up问了一下如果input是很多string呢。
	// 将aabca map成 11231 (数字是当前note map的size)，将每个string都map成一个数字字符串
	// 以这个数字字符串为key，收集所有string，看看最后intStrToStrings的size是不是为1，说明只有一种pattern
	public boolean isIsomorphic(String[] input) {
        
		
		Map<String, List<String>> intStrToStrings = new HashMap<String, List<String>>();
		for (String i : input) {
			String code = mapToInt(i);
			if (!intStrToStrings.containsKey(code)) {
				intStrToStrings.put(code, new ArrayList<String>());
			}
			intStrToStrings.get(code).add(i);
		}
		return intStrToStrings.size() == 1;
    }
	
	private String mapToInt(String s) {
		StringBuffer res = new StringBuffer();
		Map<Character, Integer> note = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!note.containsKey(c)) {
				note.put(c, note.size());
			}
			res.append(note.get(c));
		}
		return res.toString();
	}
	
	public static void main(String[] args) {
		IsomorphicStringsII is = new IsomorphicStringsII();
		
		String[] input = {"aabca", "eedwe", "lldel", "kksvk", "aabcb"};
		boolean res = is.isIsomorphic(input);
		System.out.println(res);
	}
}
