package FirstAttempt;

import java.util.Iterator;
import java.util.List;

public class ZigzagIterator {

	// https://segmentfault.com/a/1190000003786218
	/**
	 * 该题实际上就是轮流取两个列表的下一个元素。我们存下两个列表的迭代器，然后用一个递增的turns变量和取模的方法来判断该取哪一个列表的元素。
	 * 时间 O(N) 空间 O(1)
	 * 
	 * Follow up:
	 * Q：如果输入是k个列表呢？
	 * A：使用一个迭代器的列表来管理这些迭代器。用turns变量和取模来判断我们该取列表中的第几个迭代器。
	 * 不同点在于，一个迭代器用完后，我们要将其从列表中移出，这样我们下次就不用再找这个空的迭代器了。
	 * 同样，由于每用完一个迭代器后都要移出一个，turns变量也要相应的更新为该迭代器下标的上一个下标。如果迭代器列表为空，说明没有下一个了。
	 * */
	
	Iterator<Integer> it1;
	Iterator<Integer> it2;
	int turns;
	
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        it1 = v1.iterator();
        it2 = v2.iterator();
        turns = 0;
    }

    public int next() {
        if (!hasNext()) return 0;
        turns++;
        if (turns % 2 == 1 && it1.hasNext() || !it2.hasNext()) {
        	return it1.next();
        } else if (turns % 2 == 0 && it2.hasNext() || !it1.hasNext()) {
        	return it2.next();
        }
        return 0;
    }

    public boolean hasNext() {
        return it1.hasNext() || it2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */