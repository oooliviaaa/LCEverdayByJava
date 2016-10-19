package FirstAttempt;

public class FlipGameII {

	
	// http://www.programcreek.com/2014/05/leetcode-flip-game-ii-java/
	public boolean canWin(String s) {
        if (s == null || s.length() <= 1) return false;
        
        return helper(s.toCharArray());
    }
	
	private boolean helper(char[] s) {
		for (int i = 0; i < s.length-1; i++) {
			if (s[i] == s[i+1] && s[i] == '+') {
				s[i] = s[i+1] = '-';
				boolean isWin = helper(s);
				
				s[i] = s[i+1] = '+';  ///// 一定要先改回来在判断是否isWin，否则提前返回的话，上层循环s的内容会不对
				
				if (!isWin) {
					return true;
				}
				
			}
		}
		return false;
	}
	
	///////////////////
	// http://www.cnblogs.com/anne-vista/p/4886786.html
	// 更简洁的写法
	public boolean canWin2(String s) {
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == '+' && s.charAt(i+1) == '+' && !canWin2(s.substring(0,i)+"--" + s.substring(i+2))){
                return true;
            }
        }
        return false;
    }
}
