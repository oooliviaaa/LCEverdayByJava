package FirstAttempt;

import java.util.ArrayList;

public class PlusSignMinusSignGame {

	public static void main(String[] args) {
		String s = "+++--++-";
		PlusSignMinusSignGame game = new PlusSignMinusSignGame();
		boolean res = game.solution(s);
		System.out.println(res);
	}
	
	public boolean solution(String s) {		
		if(s == null || s.length() <= 1) return false;
		if(s.length() == 2) return (s.charAt(0) == '+') && (s.charAt(1) == '+');
		
		ArrayList<Integer> indexs = findContaPlusSign(s);
		for(int i : indexs) {
			String newStr = changeToMinus(s, i);
			ArrayList<Integer> enemy = findContaPlusSign(newStr);
			boolean flag = true;
			for(int e : enemy) {
				String enStr = changeToMinus(newStr, e);
				boolean eRes = solution(enStr);
				if(!eRes) {
					flag = false;
					break;
				}
			}
			if(flag) return true;
		}
		
		return false;
	}
	
	private ArrayList<Integer> findContaPlusSign(String s) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		for(int i = 0; i < s.length()-1; i++) {
			if(s.charAt(i) == '+' && s.charAt(i+1) == '+') {
				res.add(i);
			}
		}
		return res;
	}
	
	private String changeToMinus(String s, int pos) {
		StringBuilder sb = new StringBuilder(s);
		sb.setCharAt(pos, '-');
		sb.deleteCharAt(pos+1);
		return sb.toString();
	}
}
