package FirstAttempt;

import java.util.Stack;

public class DecodeString {

	// https://discuss.leetcode.com/topic/57159/simple-java-solution-using-stack
	public String decodeString(String s) {
		if (s == null || s.trim().length() == 0) return "";
        char[] array = s.trim().toCharArray();
        String res = new String();
        Stack<Integer> countStack = new Stack<Integer>();
        Stack<String> clipStack = new Stack<String>();
        
        int i = 0;
        while (i < s.length()) {
        	if (Character.isDigit(array[i])) {
        		int num = 0;
            	while (i < array.length && Character.isDigit(array[i])) {
            		num = num * 10 + (array[i] - '0');
            		i++;
            	}
            	countStack.push(num);
            } else if (s.charAt(i) == '[') {
            	clipStack.push(res);  ///// 开启一个新的clip
            	res = "";
            	i++;
            } else if (s.charAt(i) == ']') {
            	StringBuffer pre = new StringBuffer(clipStack.pop());
            	int count = countStack.pop();
            	for (int j = 0; j < count; j++) {
            		pre.append(res);
            	}
            	res = pre.toString();   ///// !!!!!
            	i++;
            } else {
            	res += s.charAt(i);
            	i++;
            }
        }
        return res;
	}
	
	
	
	
	//////////////////////
	// my WRONG solution....
	public String decodeString_Wrong(String s) {
        if (s == null || s.trim().length() == 0) return "";
        char[] array = s.trim().toCharArray();
        StringBuffer res = new StringBuffer();
        
        for (int i = 0; i < array.length; i++) {
        	if (Character.isDigit(array[i])) {
        		int num = 0;
            	while (i < array.length && Character.isDigit(array[i])) {
            		num = num * 10 + (array[i] - '0');
            		i++;
            	}
            	while (i < array.length && array[i] != '[') i++;
            	String clip = getStringClip(array, i+1);
            	i = i + clip.length() + 1;   // for loop with add 1 more
            	
            	for (int j = 0; j < num; j++) {
            		res.append(clip);
            	}
        	} else {
        		res.append(array[i]);
        	}
        }
        return res.toString();
    }
	
	private String getStringClip(char[] array, int i) {
		StringBuffer sb = new StringBuffer();
		while (i < array.length && array[i] != ']') {
			sb.append(array[i]);
			i++;
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	public static void main(String[] args) {
		DecodeString ds = new DecodeString();
		
		String s = "3[a]2[bc]";
		String res = ds.decodeString(s);
		System.out.println(res);
	}
}
