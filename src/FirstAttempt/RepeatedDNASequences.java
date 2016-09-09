package FirstAttempt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RepeatedDNASequences {

	// https://segmentfault.com/a/1190000003922976
	// solution 1: 单纯利用哈希存储，找出重复。时间 O(N) 空间 O(N)
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<String>();
		Map<String, Integer> hm = new HashMap<String, Integer>();
		
		for (int i = 0; i <= s.length() - 10; i++) {
			String sub = s.substring(i, i+10);
			if (hm.containsKey(sub)) {
				if (hm.get(sub) == 1) {
					res.add(sub);
					hm.put(sub, 2);
				}
			} else {
				hm.put(sub, 1);
			}
		}
		return res;
    }
	
	/////////////////////
	// solution 2: 实际上我们的哈希表可以不用存整个子串，因为我们知道子串只有10位，且每一位只可能有4种不同的字母，
	// 那我们可以用4^10个数字来表示每种不同的序列，因为4^10=2^20<2^32所以我们可以用一个Integer来表示。具体的编码方法是用每两位bit表示一个字符。
	public List<String> findRepeatedDnaSequences2(String s) {
		List<String> res = new ArrayList<String>();
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i <= s.length()-10; i++) {
			String sub = s.substring(i, i+10);
			int code = getEncode(sub);
			if (hm.containsKey(code)) {
				if (hm.get(code) == 1) {
					res.add(sub);
					hm.put(code, 2);
				}
			} else {
				hm.put(code, 1);
			}
		}
		return res;
	}
	
	private int getEncode(String s) {
		int code = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
            code <<= 2; ///// 每两位表示一个字符 !!!!!
			switch (c) {
			case 'A': code += 0; break;
			case 'C': code += 1; break;
			case 'T': code += 2; break;
			case 'G': code += 3; break;
			}
		}
		return code;
	}
	
}
