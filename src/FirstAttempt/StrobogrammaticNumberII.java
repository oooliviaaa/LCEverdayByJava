package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII {
	
	
	// https://segmentfault.com/a/1190000003787462
	/**
	 * 中间插入法, 时间 O(N) 空间 O(1)
	 * 找出所有的可能，必然是深度优先搜索。但是每轮搜索如何建立临时的字符串呢？
	 * 因为数是“对称”的，我们插入一个字母就知道对应位置的另一个字母是什么，所以我们可以从中间插入来建立这个临时的字符串。
	 * 这样每次从中间插入两个“对称”的字符，之前插入的就被挤到两边去了。这里有几个边界条件要考虑：

			1. 如果是第一个字符，即临时字符串为空时进行插入时，不能插入'0'，因为没有0开头的数字
			2. 如果n=1的话，第一个字符则可以是'0'
			3. 如果只剩下一个带插入的字符，这时候不能插入'6'或'9'，因为他们不能和自己产生映射，翻转后就不是自己了
	   这样，当深度优先搜索时遇到这些情况，则要相应的跳过

       注意
	        为了实现从中间插入，我们用StringBuilder在length/2的位置insert就行了

	 * */
	char[] dict;
    List<String> res;
    
    StrobogrammaticNumberII() {
    	dict = new char[]{'0', '1', '8', '6', '9'};
    }
	
	
	public List<String> findStrobogrammatic(int n) {
    	res = new ArrayList<String>();
    	dfs(n, "");
        return res;
    }
	
	private void dfs(int n, String tmp) {
		if (n == tmp.length()) {
            res.add(tmp);
            return;
        }
		
		boolean isLast = (n == tmp.length()+1);
		for (int i = 0; i < dict.length; i++) {
			char c = dict[i];
			// 第一个字符不能为'0'，但n=1除外。只插入一个字符时不能插入'6'和'9'
			if ((c == '0' && n != 1 && tmp.length() == 0) || (isLast && (c == '6' || c == '9'))) {
				continue;
			}
			
			StringBuilder newTmp = new StringBuilder(tmp);   ///// !!! tmp->StringBuilder
			// 插入字符c和它的对应字符
            append(isLast, c, newTmp);
            dfs(n, newTmp.toString());
		}
	}
	
	private void append(boolean isLast, char c, StringBuilder sb) {
		if (c == '6') {
            sb.insert(sb.length()/2, "69");
        } else if (c == '9') {
            sb.insert(sb.length()/2, "96");
        } else {
            sb.insert(sb.length()/2, isLast ? c : ""+c+c);
        }
	}
	
	
}
