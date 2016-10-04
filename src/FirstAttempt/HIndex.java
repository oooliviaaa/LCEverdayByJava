package FirstAttempt;

import java.util.Arrays;

public class HIndex {

	// https://segmentfault.com/a/1190000003794831
	// solution 1, Sorting, 时间 O(NlogN) 空间 O(1)
	/**
	 * 某researcher有h篇论文引用次数至少为h次, 找出最大的h
	 * */
	public int hIndex(int[] citations) {
        int h = 0;
        
        Arrays.sort(citations);   ///// !!!!!
        
        for (int i = 0; i < citations.length; i++) {
        	int c = Math.min(citations[i], citations.length-i);   // 本文引用citations[i]次，有citations.length-i篇文章至少引用citations[i]次
        	h = Math.max(h, c);
        }
        return h;
    }
	
	
	//////////////////
	// solution 2, 数组映射法， 时间 O(N) 空间 O(N)
	/**
	 * stats[i]表示有多少文章被引用了i次，这里如果一篇文章引用大于N次，我们就将其当为N次，因为H指数不会超过文章的总数。
	 * 为了构建这个数组，我们需要先将整个文献引用数组遍历一遍，对相应的格子加一。
	 * 统计完后，我们从N向1开始遍历这个统计数组。如果遍历到某一个引用次数时，大于或等于该引用次数的文章数量，大于引用次数本身时，我们可以认为这是H指数。
	 * 之所以不用再向下找，因为我们要取最大的H指数。
	 * 那如何求大于或等于某个引用次数的文章数量呢？我们可以用一个变量，从高引用次的文章数累加下来。
	 * 因为我们知道，如果有x篇文章的引用大于等于3次，那引用大于等于2次的文章数量一定是x加上引用次数等于2次的文章数量。
	 * */
	public int hIndex2(int[] citations) {
		int n = citations.length;  // 一共n篇文章
		int[] count = new int[n+1];  // 引用多于n次的，统一当n次，存入count[n]，所以数组长度n+1
		
		for (int i = 0; i < citations.length; i++) {
			int c = citations[i];
			count[c>n ? n : c] += 1;      ///// !!!!! 小心，引用次数可能多于n
		}
		
		int res = 0;
		for (int i = n; i > 0; i--) {     ///// 倒序找 !!!!!
			res += count[i];
			
			if (res >= i) {
				return i;
			}
		}
		return 0;
	}
}
