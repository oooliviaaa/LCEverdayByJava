package FirstAttempt;

public class OneEditDistance {

	// https://segmentfault.com/a/1190000003906621
	public boolean isOneEditDistance(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if (len1 == len2) return isOneModified(s, t);
        if (len1 - len2 == 1) return isOneDelete(s, t);
        if (len2 - len1 == 1) return isOneDelete(t, s);
        return false;
    }
	
	private boolean isOneModified(String s, String t) {
		boolean isDiff = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				if (isDiff) return false;
				else isDiff = true;
			}
		}
		return isDiff;       /////////////   !!!!!
	}
	
	private boolean isOneDelete(String s, String t) {
		for (int i = 0; i < t.length(); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				return s.substring(i+1).equals(t.substring(i));       ///////////// compare string!!!!!
			}
		}
		return true;        /////////////   !!!!!
	}
}

