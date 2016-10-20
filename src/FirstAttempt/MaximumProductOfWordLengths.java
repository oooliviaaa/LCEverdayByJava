package FirstAttempt;

public class MaximumProductOfWordLengths {

	/**
	 * Understand the problem:
	 * The problem is a little bit ambiguous. 
	 * The two words used to calculate the product of length must not share any common characters. 
	 * e.g. word1 = abc, word2 = bcd, the product is 0 not 1, because they share common chars. 
	 * 
	 * The most straight-forward way to solve this problem is to pick up any two words, 
	 * and check if they have common characters. If not, then calculate the maximum product of the length. 
	 * Suppose the number of words is n, and average word length is m. So the time complexity for the  brute-force solution is O(n^2 * m). 
	 * 
	 * A better approach using bit manipulation:
	 * Now let's think can we reduce the time complexity when we check the intersection of two words? 
	 * Since each word contains 26 characters in lower case only. We can use a bit map to encode the string. 
	 * Since we only need 26 bits for a word, it is enough to use an integer to encode a string. 
	 * */
	public int maxProduct(String[] words) {
        if (words == null || words.length <= 1) return 0;
        int[] encode = new int[words.length];  // 存储每个word的bit map
        
        for (int i = 0; i < words.length; i++) {
        	String word = words[i];
        	for (int j = 0; j < word.length(); j++) {
        		char c = word.charAt(j);
        		encode[i] |= (1 << c - 'a');   // 第几位为1表示第几个字母在这个word中存在
        	}
        }
        
        int maxLen = 0;
        for (int i = 0; i < words.length; i++) {
        	for (int j = i+1; j < words.length; j++) {
        		if ((encode[i] & encode[j]) == 0) {    // 位的与运算
        			maxLen = Math.max(maxLen, words[i].length() * words[j].length());
        		}
        	}
        }
        return maxLen;
    }
}
