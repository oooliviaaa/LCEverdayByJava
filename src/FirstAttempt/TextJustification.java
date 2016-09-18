package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	// http://www.cnblogs.com/springfor/p/3896168.html
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<String>();
		if (words == null || words.length == 0 || maxWidth == 0) return res;
		
		int preWordsLen = 0;  // 正在处理的这一行从行始所有单词的长度总和。
		int preWord = 0;  // 正在处理的这行第一个单词在words中的index
		
		for (int i = 0; i < words.length; i++) {
			int len = preWordsLen + words[i].length() + (preWord - i);  //preWord - i 是至少有几个空格（每词间仅有一个空格）
			
			if (len > maxWidth) {  // 这行加上words[i]之后超出长度maxWidth了，所以这行的单词就是preWord~words[i-1]这么多，开始处理这行
				StringBuffer sb = new StringBuffer();
				if (i-1 - preWord > 0) {  // 如果这行不止一个单词（因为尝试当前words[i]后发现比L长了， 所以只处理到i-1号单词）
					int spaceNum = (maxWidth - preWordsLen) / (i - 1 - preWord);
					int extraSpaceNum = (maxWidth - preWordsLen) % (i - 1 - preWord);
					
					for (int j = preWord; j < i-1; j++) {  // 最后一个词后面不用加空格，所以只进行到i-2
						sb.append(words[j]);
						for (int k = 0; k < spaceNum; k++) {
							sb.append(" ");
						}
						if (extraSpaceNum > 0) {
							sb.append(" ");
							extraSpaceNum--;
						}
					}
					sb.append(words[i-1]);
				} else {   // 如果这行只有一个单词(第i-1号单词) ！！！！！
					sb.append(words[preWord]);
					for (int k = words[preWord].length(); k < maxWidth; k++) {
						sb.append(" ");
					}
				}
				
				res.add(sb.toString());
				preWord = i;      // 下一行从第i个单词开始
				preWordsLen = 0;
				
				
			} 
				
			preWordsLen += words[i].length();  // 继续加单词
		}
		
		String lastLine = res.get(res.size()-1);
		res.remove(res.size()-1);
		String[] lastWords = lastLine.split(" ");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < lastWords.length-1; i++) {
			sb.append(lastWords[i]);
			sb.append(" ");
		}
		sb.append(lastWords[lastWords.length-1]);
		for (int i = sb.length(); i < maxWidth; i++) {
			sb.append(" ");
		}
		res.add(sb.toString());
		return res;
    }
	
	
	public static void main(String[] args) {
		String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
		TextJustification tj = new TextJustification();
		List<String> res = tj.fullJustify(words, 16);
		
		for (String s : res) {
			System.out.println(s);
		}
		
	}
}
