package FirstAttempt.WordSearchII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
	
	//
	/** http://blog.csdn.net/ljiabin/article/details/45846527
	 * 我们可以利用Trie数据结构，也就是前缀树。然后dfs时，如果当前dfs形成的单词不在Trie里，就没必要继续dfs下去了。如果当前字符串在trie里，就说明board可以形成这个word。
	 * */
	int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
	
	public List<String> findWords(char[][] board, String[] words) {
		Set<String> res = new HashSet<String>();
		Trie trie = new Trie();
		
		for (String s : words) {
			trie.insert(s);
		}
		
		boolean[][] visited = new boolean[board.length][board[0].length];  
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, trie, "", visited, res);
			}
		}
		
		return new ArrayList<String>(res);
    }
	
	private void dfs(char[][] board, int i, int j, Trie trie, String tmp, boolean[][] visited, Set<String> res) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
		if (visited[i][j]) return;
		
		tmp += board[i][j];
		if (!trie.startWith(tmp)) return;

		if (trie.search(tmp)) res.add(tmp);
		
		visited[i][j] = true;
		for (int[] dir : directions) {
			int x = i + dir[0];
			int y = j + dir[1];
			dfs(board, x, y, trie, tmp, visited, res);
		}
		visited[i][j] = false;
	}
	
	
	
	
}
