package FirstAttempt;

public class LengthofLastWord {

	// method 1
	public int lengthOfLastWord(String s) {
		s = s.trim();
		String[] words = s.split(" ");
		if (words.length == 0)
			return 0;
		return words[words.length - 1].length();
	}
	
	
	// method 2
	public int getLength(String s) {
		//s = s.trim();
		if (s.length() == 0) return 0;
		
		int count = 0;
		
		for (int i = s.length()-1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c != ' ') count++;
			else if (count != 0 && c == ' ') {
				return count;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		String s = "  dsw  ewqer  ";
		LengthofLastWord ll = new LengthofLastWord();
		int res = ll.getLength(s);
		System.out.println(res);
	}
}
