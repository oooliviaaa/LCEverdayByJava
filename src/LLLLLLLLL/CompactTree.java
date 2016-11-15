package LLLLLLLLL;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CompactTree<T> {
	CompactTreeNode<T> compact(CompactTreeNode<T> root, int N) {
		Queue<CompactTreeNode<T>> childQueue = new LinkedList<CompactTreeNode<T>>();
		Queue<CompactTreeNode<T>> parentQueue = new LinkedList<CompactTreeNode<T>>();
		
		childQueue.offer(root);
		while (!childQueue.isEmpty()) {
			CompactTreeNode<T> cur = childQueue.poll();
			for (CompactTreeNode<T> child : cur.getChildren()) {
				childQueue.offer(child);
			}
			cur.getChildren().clear();
			
			if (!parentQueue.isEmpty()) {
				while (parentQueue.peek().getChildren().size() >= N) {
					parentQueue.poll();
				}
				parentQueue.peek().getChildren().add(cur);
			}
			
			parentQueue.offer(cur);
		}
		return root;
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