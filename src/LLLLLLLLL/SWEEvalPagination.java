package LLLLLLLLL;

import java.util.ArrayList;
import java.util.List;

public class SWEEvalPagination {

	public static List<String> paginate(String input, int maxWidth) {
		List<String> res = new ArrayList<String>();
		String[] words = input.trim().split(" ");
		if (words == null || words.length == 0) return res;
		
		int preWordsLen = 0;  // 正在处理的这一行从行始所有单词的长度总和（不包括空格）
		int preWord = 0;  // 正在处理的这行第一个单词在words中的index
		
		for (int i = 0; i < words.length; i++) {
			int len = preWordsLen + words[i].length() + (i - preWord);  //i - preWord 是至少有几个空格（每词间仅有一个空格）
			if (len > maxWidth) {  // 这行加上words[i]之后超出长度maxWidth了，所以这行的单词就是preWord~words[i-1]这么多，开始处理这行
				StringBuffer sb = new StringBuffer();
				for (int j = preWord; j < i-1; j++) {
					sb.append(words[j] + " ");
				}
				sb.append(words[i-1]);
				res.add(sb.toString());
				preWord = i;      // 下一行从第i个单词开始
				preWordsLen = 0;
			} 
			
			preWordsLen += words[i].length();	
				
		} 
		
		// 处理最后一行 !!!!!
		StringBuffer sb = new StringBuffer();
		for (int i = preWord; i < words.length-1; i++) {
			sb.append(words[i] + " ");
		}
		sb.append(words[words.length-1]);
		for (int i = sb.length(); i < maxWidth; i++) {
			sb.append(" ");
		}
		res.add(sb.toString());
		return res;
	}
	
	public static void main(String[] args) {
		String words = "This is an example of pagination.";
		List<String> res = SWEEvalPagination.paginate(words, 16);
		
		for (String s : res) {
			System.out.println(s);
		}
		
	}
}
