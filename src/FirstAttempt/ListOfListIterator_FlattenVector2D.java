package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

// Shuai's solution
public class ListOfListIterator_FlattenVector2D {

	int row;
	int col;
	int rowPre;
	int colPre;
	List<ArrayList<Integer>> matrix;

	public ListOfListIterator_FlattenVector2D(List<ArrayList<Integer>> list) {
		row = col = 0;
		rowPre = colPre = -1;
		matrix = list;
	}

	public int next() {
		int res = matrix.get(row).get(col);
		rowPre = row; colPre = col;
		++col;
		if (col >= matrix.get(row).size() && row < matrix.size() - 1) {
			// navigate to the next available index
			++row;
			col = 0;
		}
		return res;
	}

	public boolean hasNext() {
		// find the next available element
		while (row < matrix.size()
				&& (matrix.get(row) == null || matrix.get(row).size() == 0)) {
			row++;
		}
		return row < matrix.size() && col < matrix.get(row).size();
	}
	
	public void remove() {
		matrix.get(rowPre).remove(colPre);
		col = colPre; row = rowPre;  // the next() one replace the removed one's place
	}
	
	public static void main(String[] args) {
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(1); l1.add(2); 
		
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		ArrayList<Integer> l3 = new ArrayList<Integer>();
		l3.add(5); l3.add(6);
		
		list.add(l1); list.add(l2); list.add(l3);
		
		ListOfListIterator_FlattenVector2D s = new ListOfListIterator_FlattenVector2D(list);
		while(s.hasNext()) {
			int a = s.next();
			System.out.println(" " + a);
			s.remove();
		}
		
		System.out.println("after remove: [");
		for(ArrayList<Integer> l : list) {
			for(int j : l) System.out.println(j);
		}
		System.out.println("]");
	}
	
}

/**
 * Your Vector2D object will be instantiated and called as such: Vector2D i =
 * new Vector2D(vec2d); while (i.hasNext()) v[f()] = i.next();
 */
