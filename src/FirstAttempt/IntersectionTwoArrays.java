package FirstAttempt;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}
        Set<Integer> s1 = new HashSet<Integer>(nums1.length);
        for (int i : nums1) {
        	s1.add(i);
        }
        
        Set<Integer> s2 = new HashSet<Integer>(nums2.length);
        for (int i : nums2) {
        	s2.add(i);
        }
        
        Iterator<Integer> it = s1.iterator();
        while (it.hasNext()) {
        	int i = it.next();
        	if (!s2.contains(i)) {
        		it.remove();    ///////////////// iterator remove !!!!!  
        						// https://docs.oracle.com/javase/7/docs/api/java/util/Iterator.html#remove()
        	}
        }
        int[] res = new int[s1.size()];
        int i = 0;
        for (int s : s1) {
        	res[i++] = s;
        }
        return res;
    }
}
