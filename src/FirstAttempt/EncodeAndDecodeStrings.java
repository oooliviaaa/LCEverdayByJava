package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
	
	// https://segmentfault.com/a/1190000003791865
	/**
	 * 本题难点在于如何在合并后的字符串中，区分出原来的每一个子串。
	 * 这里我采取的编码方式，是将每个子串的长度先赋在前面，然后用一个#隔开长度和子串本身。这样我们先读出长度，就知道该读取多少个字符作为子串了。
	 * 长度#string本人
	 * */
	// Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for (String s : strs) {
        	if (s == null) {
        		sb.append("0#");
        	} else {
        		sb.append(s.length() + "#" + s);
        	}
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
    	List<String> res = new ArrayList<String>();
    	
    	int i = 0;
    	while (i < s.length()) {
    		int j = i;
    		while (j < s.length() && Character.isDigit(s.charAt(j))) {
    			j++;
    		}
    		int len = Integer.parseInt(s.substring(i, j));
    		j++;
    		if (len == 0) {
    			res.add("");
    		} else {
    			res.add(s.substring(j, j+len));
    		}
    		i = j+len;
    	}
    	return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));