package FirstAttempt;

public class RangeSumQueryMutable {

	// http://www.cnblogs.com/yrbbest/p/5056739.html
	// segment tree
	class SegmentTreeNode {
        int start;
        int end;
        int val;
        SegmentTreeNode left, right;
        
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.val = 0;  // 表示start~end这个range的sum
        }
    }
	
	private SegmentTreeNode root;
    private int[] nums;
	
	public RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
        this.root = buildSegmentTree(0, nums.length-1);
    }

	private SegmentTreeNode buildSegmentTree(int start, int end) {
		if (start > end) return null;
		SegmentTreeNode node = new SegmentTreeNode(start, end); ///// 新建node，存储当前区间
		if (start == end) {  // leaf
			node.val = nums[start];
		} else {
			int mid = (start + end) / 2;
			node.left = buildSegmentTree(start, mid);
			node.right = buildSegmentTree(mid+1, end);
			node.val = node.left.val + node.right.val;  ///// node的val是sum !!!!!
		}
		
		return node;
	}
	
    void update(int i, int val) {
        update(root, i, val);
    }
    
    private void update(SegmentTreeNode node, int pos, int val) {
    	if (root == null) return;
    	if (node.start == pos && node.end == pos) {
    		node.val = val;
    		nums[pos] = val;
    		return;
    	}
    	
    	int mid = (node.start + node.end) / 2;
    	if (pos <= mid) {
    		update(node.left, pos, val);
    	} else {
    		update(node.right, pos, val);
    	}
    	node.val = node.left.val + node.right.val;  ///// 更新node的val !!!!!
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    private int sumRange(SegmentTreeNode node, int qStart, int qEnd) {
    	if (qStart > qEnd) return 0;
    	if (node.start == qStart && node.end == qEnd) return node.val;
    	
    	int mid = (qStart + qEnd) / 2;
    	if (qEnd <= mid) {          ///// 只考虑左边。 <=, 因为node.left包涵mid那个位置的val（因为buildSegmentTree()那个方法这么写的）!!!!!
    		return sumRange(node.left, qStart, qEnd);
    	} else if (qStart > mid) {  ///// 只考虑右边。>, 因为node.right不包含mid那个位置的val!!!!!
    		return sumRange(node.right, qStart, qEnd);
    	} else {                    ///// 两侧都需要考虑
    		return sumRange(node.left, qStart, mid) + sumRange(node.right, mid+1, qEnd);
    	}
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
//numArray.update(1, 10);
//numArray.sumRange(1, 2);