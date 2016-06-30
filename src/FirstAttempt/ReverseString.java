package FirstAttempt;

public class ReverseString {

	// http://blog.csdn.net/crazy1235/article/details/51420522
	public String reverseString(String s) {
        return new StringBuffer(s).reverse().toString();
    }
	
	
	public static String reverseString2(String s) {
        StringBuffer result = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }
	
	// for loop n/2
	public static String reverseString4(String s) {
        char[] ch = s.toCharArray();
        int halfLength = s.length() / 2;
        char temp;
        for (int i = 0; i < halfLength; i++) {
            temp = ch[s.length() - 1 - i];
            ch[s.length() - 1 - i] = ch[i];
            ch[i] = temp;
        }
        return new String(ch);
    }
}
