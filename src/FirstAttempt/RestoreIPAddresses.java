package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        
        dfs(s, 0, new ArrayList<String>(), res);
        
        for (List<String> r : res) {
        	StringBuffer sb = new StringBuffer();
        	for (String i : r) {
        		sb.append(i);
        		sb.append('.');
        	}
        	sb.deleteCharAt(sb.length()-1);
        	result.add(sb.toString());
        }
        return result;
    }
	
	private void dfs(String s, int index, List<String> tmp, List<ArrayList<String>> res) {
		if (index == s.length() && tmp.size() == 4) {
			ArrayList<String> r = new ArrayList<String>(tmp);
			res.add(r);
		}
		if (index >= s.length() || tmp.size() >= 4) return;
		
		for (int i = 1; i <= 3 && index+i <= s.length(); i++) {
			String sub = s.substring(index, index+i);
			if (isValid(sub)) {
				tmp.add(sub);
				dfs(s, index+i, tmp, res);
				tmp.remove(tmp.size()-1);
			}
		}
	}
	
	private boolean isValid(String s) {
		if (s.charAt(0) == '0') {
			return s.equals("0");
		}
		int num = Integer.parseInt(s);
		if (num <= 255 && num > 0) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String s = "25525511135";
		RestoreIPAddresses ra = new RestoreIPAddresses();
		List<String> res = ra.restoreIpAddresses(s);
		for (String r : res) System.out.println(r);
	}
}
