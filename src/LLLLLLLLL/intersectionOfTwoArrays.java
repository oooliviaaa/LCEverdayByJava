package LLLLLLLLL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class intersectionOfTwoArrays {

	public static Iterable<Integer> intersection(Iterator<Integer> a, Iterator<Integer> b) {
		List<Integer> res = new ArrayList<Integer>();
		
		Set<Integer> hs = new HashSet<Integer>();
		while (a.hasNext()) {
			hs.add(a.next());
		}
		
		while (b.hasNext()) {
			int cur = b.next();
			if (hs.contains(cur)) {
				res.add(cur);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		Integer[] a = {5,2,3,7,8,1,4};
		Integer[] b = {5,9,3,1};
		
		Iterable<Integer> res = intersectionOfTwoArrays.intersection(Arrays.asList(a).iterator(), Arrays.asList(b).iterator());
		Iterator<Integer> i = res.iterator();
		while(i.hasNext()) System.out.println(i.next());
	}
}
