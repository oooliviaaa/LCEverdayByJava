package FirstAttempt;

public class CountandSay {

	public String countAndSay(int n) {
        String s = "1";
        while(--n > 0) {  // 1~n, total n times transfer
        	StringBuilder sb = new StringBuilder();
        	char[] sChar = s.toCharArray();
        	for(int i = 0; i < sChar.length; i++) {
        		int count = 1;
        		while(i+1 < sChar.length && sChar[i] == sChar[i+1]) {
        			count++;
        			i++;
        		}
        		sb.append(String.valueOf(count)+String.valueOf(sChar[i]));
        	}
        	s = sb.toString();
        }
        return s;
    }
}
