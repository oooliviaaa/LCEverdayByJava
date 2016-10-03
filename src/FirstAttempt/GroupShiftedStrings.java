package FirstAttempt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {

	// http://blog.csdn.net/pointbreak1/article/details/48780345
	/**
	 * eg. ["eqdf", "qcpr"]。
	 * ((‘q’ - 'e') + 26) % 26 = 12, ((‘d’ - 'q') + 26) % 26 = 13, ((‘f’ - 'd') + 26) % 26 = 2
	 * ((‘c’ - 'q') + 26) % 26 = 12, ((‘p’ - 'c') + 26) % 26 = 13, ((‘r’ - 'p') + 26) % 26 = 2
	 * 所以"eqdf"和"qcpr"是一组shifted strings。
	 * +26是为了防止后一个数比前一个数大，导致差值为负数
	 * */
	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> res = new ArrayList<List<String>>();
		
		if (strings == null || strings.length == 0) return res;
		
		// key是每个字母与第一个字母的差值合成的string， eg. key="0 12 25 1", value是所有有这种间隔的string的arraylist
		Map<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
		
		for (String s : strings) {
			char first = s.charAt(0);
			StringBuffer sb = new StringBuffer();  
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				int diff = (c - first + 26) % 26;
				sb.append(diff + " ");
			}
			String sbs = sb.toString();
			ArrayList<String> list = hm.get(sbs);
			if (list == null) {
				list = new ArrayList<String>();
			}
			list.add(s);
			hm.put(sbs, list);
		}
		
		for (String s : hm.keySet()) {
			List<String> list = hm.get(s);
			Collections.sort(list);
			res.add(list);
		}
		return res;
    }
}
