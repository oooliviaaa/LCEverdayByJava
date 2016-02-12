package FirstAttempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FriendCircle {

	
	public ArrayList<ArrayList<Integer>> solution(boolean[][] friends) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(friends == null || friends.length == 0 || 
				friends[0].length == 0 || friends.length != friends[0].length) return res;
		int num = friends.length;
		boolean[] record = new boolean[num];
		Arrays.fill(record, false);
		
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		
		for(int i = 0; i < num; i++) {
			
			System.out.println("checking: " + i);
			if(record[i]) {
				System.out.println("skipped");
				continue;
			}
			queue.add(i);
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			while(!queue.isEmpty()) {
				int my = queue.poll();
				record[my] = true;
				tmp.add(my);
				ArrayList<Integer> myFriends = getFriends(friends, my);
				for(int mf : myFriends) {
					if(record[mf]) continue;
					queue.add(mf); 
				}
			}
			res.add(tmp);
		}
		
		return res;
	}
	
	private ArrayList<Integer> getFriends(boolean[][] friends, int me) {
		boolean[] myCol = friends[me];
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int i = 0; i < myCol.length; i++) {
			if(myCol[i]) res.add(i);
		}
		return res;
	}
	
	
	
	public static void main(String[] args) {
		boolean[][] friends1 = {
				{true, true, true, false, false},
				{true, true, false, false, true},
				{true, false, true, true, false},
				{false, false, true, true, true},
				{false, true, false, true, true}
				}; //answer: 1




				boolean[][] friends2 = {
				{true, true, false, false},
				{true, true, false, false},
				{false, false, true, true},
				{false, false, true, true}
				}; //answer: 2


				boolean[][] friends3 = {
				{true, false, false, false},
				{false, true, false, false},
				{false, false, true, true},
				{false, false, true, true}
				}; //answer: 3




				boolean[][] friends4 = {
				{true, false, false, false},
				{false, true, false, false},
				{false, false, true, false},
				{false, false, false, true}
				}; //answer: 4
				
		FriendCircle fc = new FriendCircle();
		ArrayList<ArrayList<Integer>> res = fc.solution(friends2);
		for(ArrayList<Integer> circle : res) {
			System.out.println("a circle: ");
			for(int friend: circle) System.out.print(friend + " ");
			System.out.println();
		}
	}
}
