package LLLLLLLLLLL;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordFinderII {

	Set<String> dict;
	Trie trie;
	static final int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
	
	public void init (Set<String> words) {
		dict = words;
		trie = new Trie();
	}
	
	public Set<String> find (char[][] board) {
		Set<String> res = new HashSet<String>();
		
		for (String s : dict) {
			trie.insert(s);
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, trie, "", res);
			}
		}
		return res;
	}
	
	private void dfs(char[][] board, int i, int j, Trie trie, String tmp, Set<String> res) {
		char c = board[i][j];
		tmp += c;
		if (!trie.startWith(tmp)) return;
		if (trie.search(tmp)) {
			res.add(tmp);
		}
		
		board[i][j] = '.';
		for (int[] dir : directions) {
			int x = i + dir[0];
			int y = j + dir[1];
			if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] != '.') {
				dfs(board, x, y, trie, tmp, res);
			}
		}
		board[i][j] = c;
	}
	
}
