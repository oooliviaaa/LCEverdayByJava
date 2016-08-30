package FirstAttempt;


public class DecodeWays {

	// http://www.cnblogs.com/springfor/p/3896162.html
	// 注意某个char是0的情况，如果是10，20就能decode，如果是30以上就不能decode了。
	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.charAt(0) == '0')
	        return 0;
	    if (s.length() == 1)
	        return 1;
		
		int[] dp = new int[s.length()+1];
        dp[0] = 1;
        
        if (isValid(s.substring(0,1))) dp[1] = 1;  
        else dp[1] = 0; 

        for (int i = 2; i < s.length(); i++) {
        	if (isValid(s.substring(i-1, i))) {
        		dp[i] += dp[i-1];
        	}
        	if (isValid(s.substring(i-2, i))) {
        		dp[i] += dp[i-2];
        	}
        }
        
        return dp[s.length()];
    }
	
	private boolean isValid(String s) {
		if (s.charAt(0) == '0') return false;
		int i = Integer.parseInt(s);
		return i >=1 && i <= 26;
	}
}
