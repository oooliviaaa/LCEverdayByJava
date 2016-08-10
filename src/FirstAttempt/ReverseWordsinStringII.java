package FirstAttempt;

public class ReverseWordsinStringII {
	
	public void reverseWords(char[] s) {
		if (s == null || s.length == 0) return;
		
		int i = 0;
		for (int j = 0; j < s.length; j++) {
			if (s[j] == ' ') {
				reverse(s, i, j-1);   ///////////// j-1 !!!
				i = j+1;        /////////////  !!!
			}
		}
		
		reverse(s, i, s.length-1);     /////////////  remember to reverse the last word!!!
		reverse(s, 0, s.length-1);
	}
	
	private void reverse(char[] s, int i, int j) {
		while (i < j) {
			char tmp = s[i];
			s[i] = s[j];
			s[j] = tmp;
			i++;
			j--;
		}
	}
}
