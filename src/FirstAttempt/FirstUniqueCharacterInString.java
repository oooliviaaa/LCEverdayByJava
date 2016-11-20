package FirstAttempt;

public class FirstUniqueCharacterInString {

	// https://discuss.leetcode.com/topic/55148/java-7-lines-solution-29ms
	public int firstUniqChar(String s) {
        int[] count = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	count[c - 'a']++;
        }
        
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (count[c - 'a'] == 1) return i;
        }
        
        return -1;
    }
}
