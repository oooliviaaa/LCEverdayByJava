package FirstAttempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FriendCircle {

	// native union find - Shuai
	private static int getCycleNumUnionFind(boolean[][] friends) {
		int length = friends.length;
		int[] relation = new int[length];

		for (int n = 0; n < length; n++) {
			relation[n] = n;
		}

		//union
		for (int row = 1; row < length; row ++) {
			for (int col = 0; col < row; col ++) {
				if (friends[row][col]) {
					for (int n = 0; n < relation.length; n++) {
						if (relation[n] == col) {
							relation[n] = row;
						}
					}
				}
			}
		}
		//find
		HashSet<Integer> nums = new HashSet<Integer>();
		for (int aRelation : relation) {
			nums.add(aRelation);
		}
		return nums.size();
	}
	
	
	// BFS - Yaolin
	public ArrayList<ArrayList<Integer>> solution(boolean[][] friends) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(friends == null || friends.length == 0 || 
				friends[0].length == 0 || friends.length != friends[0].length) return res;
		int num = friends.length;
		boolean[] record = new boolean[num];
		Arrays.fill(record, false);
		
		Queue<Integer> queue = new LinkedList<Integer>();	
		
		for(int i = 0; i < num; i++) {
			if(record[i]) continue;
			queue.add(i);
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			while(!queue.isEmpty()) {
				int my = queue.poll();
				if(record[my]) continue;// different ppl can have same friend, so same friend may be added to queue multiple times
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
	
	
	// DFS - Yin
	public List<List<Integer>> connectPeople (boolean[][] people) {
	       List<List<Integer>> result = new ArrayList<List<Integer>>();
	       if (people == null || people.length == 0) {
	           return result;
	       }
	       boolean[] visited = new boolean[people.length];
	       
	       for (int i = 0; i < people.length; i++) {
	           if (!visited[i]) {
	        	   List<Integer> list = new ArrayList<Integer>();
	               helper(people, i, visited, list, result);
	               result.add(new ArrayList<Integer>(list));
	           }
	       }
	       return result;
	   }
	   
	   private void helper(boolean[][] people, int index,  boolean[] visited, List<Integer> list, List<List<Integer>> result) {
	 
	       list.add(index);
	       visited[index] = true;
	       boolean flag = false;
	       for (int i = index + 1; i <people.length; i++) {
	           if (people[index][i] && people[i][index]&& !visited[i]) {
	               flag = true;
	               helper(people, i, visited,list, result);
	        
	           }
	       }
	       if (!flag) {
	           return;
	       }     
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
		List<List<Integer>> res = fc.connectPeople(friends3);
		for(List<Integer> circle : res) {
			System.out.println("a circle: ");
			for(int friend: circle) System.out.print(friend + " ");
			System.out.println();
		}
	}
}
