package InterestingQuestions.SortArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(4);
		input.add(2);
		input.add(6);
		input.add(8);
		input.add(1);
		Collections.sort(input);  // build in sort for integer
		
		for(int i : input) {
			System.out.println(i);
		}
		
		System.out.println(" ~~~~~ ");
		
		ArrayList<Integer> input2 = new ArrayList<Integer>();
		input2.add(4);
		input2.add(2);
		input2.add(6);
		input2.add(8);
		input2.add(1);
		intSolution(input2);   // self-defined sort
		for(int i : input2) {
			System.out.println(i);
		}
	}
	
	public static void solution(ArrayList<Fruit> fruits) {
		// Sorting
		Collections.sort(fruits, new Comparator<Fruit>() {
		        public int compare(Fruit fruit2, Fruit fruit1) {
		            return  fruit1.fruitName.compareTo(fruit2.fruitName);
		        }
		    });
	}
	
	public static void intSolution(ArrayList<Integer> input) {
		// Sorting
		Collections.sort(input, new Comparator<Integer>() {
						public int compare(Integer o1, Integer o2) {
							return o1 - o2;
						}
				    });
	}
}
