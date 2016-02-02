package FirstAttempt;

public class LongestCommonPrefix {

	//http://www.cnblogs.com/springfor/p/3872316.html
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0) return "";
		
		String s = strs[0]; 
		for(int i = 0; i < s.length(); i++) {
			char x = s.charAt(i);
			
			for(int j = 1; j < strs.length; j++) {  // go over every string in the array
				String cur = strs[j];
				if(cur.length() == i || x != cur.charAt(i)) {
					return s.substring(0, i);
				}
			}
		}
		return s;
    }
	
	
	// solution2
	private int minlen(String[] strs) {
		 int min = Integer.MAX_VALUE;
		 for(int i=0; i<strs.length;i++)
		 	min = Math.min(min,strs[i].length());
		 	return min;
		 }
		      
		 public String longestCommonPrefix2(String[] strs) {
		 	if (strs == null || strs.length == 0)
		 		return "";
			StringBuilder res = new StringBuilder();
			int index = 0;
			int len = minlen(strs);
			while (index < len){
				for (int i=1; i<strs.length;i++){
					if (strs[i].charAt(index) != strs[0].charAt(index))
						return res.toString();
					}
				res.append(strs[0].charAt(index));
				index++;
			}
			return res.toString();
		}
	
}
