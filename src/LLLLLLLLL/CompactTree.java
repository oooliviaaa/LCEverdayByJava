package LLLLLLLLL;

import java.util.List;

public class CompactTree<T> {
	CompactTreeNode<T> compact(CompactTreeNode<T> root, int N) {
		
	}
	
}

interface CompactTreeBuilder<T> {
	CompactTreeNode<T> compact(CompactTreeNode<T> root, int N);
}

class CompactTreeNode<T> {
	 
    private final T data;
 
    private final List<CompactTreeNode<T>> children;
 
 
    public CompactTreeNode(T data, List<CompactTreeNode<T>> children) {
        this.data = data;
        this.children = children;
    }
 
    public T getData() {
        return data;
    }
 
    public List<CompactTreeNode<T>> getChildren() {
        return children;
    }
}