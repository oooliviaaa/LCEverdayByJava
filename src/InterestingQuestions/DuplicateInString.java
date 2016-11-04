package InterestingQuestions;

import java.util.HashSet;
import java.util.Set;

public class DuplicateInString {

	public boolean findDup(String s) {
		if (s == null || s.length() <= 1) {
			return false;
		}
		
		Set<Character> hs = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (hs.contains(c)) {
				return true;
			} else {
				hs.add(c);
			}
		}
		return false;
	}
	
	//////////asc ii code//////////////////
	public boolean findDup2(String s) {
		if (s == null || s.length() <= 1) {
			return false;
		}
		boolean[] note = new boolean[256];
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (note[c]) {
				return true;
			} else {
				note[c] = true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
//		for (int c=32; c<128; c++) {
//		    System.out.println(c + ": " + (char)c);
//		}
		
		DuplicateInString ds = new DuplicateInString();
		boolean res = ds.findDup2("  *$#^@");
		
		System.out.println(res);
	}
}
