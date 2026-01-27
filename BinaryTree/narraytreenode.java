package BinaryTree;

import java.util.ArrayList;
import java.util.Queue;

public class narraytreenode {
	static class NArrayTreeNode<E> {
		E data;
		ArrayList<Integer> children;
		
//		public NArrayTreeNode(E data) {
//			this.data = data;
//			children = new ArrayList<>();
//		}
		
		public NArrayTreeNode(E data,ArrayList<Integer> children) {
			this.data = data;
			this.children = children;
		}
	}
	
	public ArrayList<Integer> bfs(NArrayTreeNode<Integer> root) {
		ArrayList<Integer> res = new ArrayList<Integer>(); 
			
		Queue<NArrayTreeNode> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			NArrayTreeNode<Integer> node = q.poll();
			res.add(node.data);
			for(NArrayTreeNode child : node.children) {
				if(child!=null) {
					q.offer(child);
				}
			}
		}
		return res;
	}
	
    public static void main(String[] args) {
    	NArrayTreeNode<Integer> root = new NArrayTreeNode<>(1);
    	
    	NArrayTreeNode<Integer> node2 = new NArrayTreeNode<>(2);
    	NArrayTreeNode<Integer> node3 = new NArrayTreeNode<>(3);
    	NArrayTreeNode<Integer> node4 = new NArrayTreeNode<>(4);
  
    	NArrayTreeNode<Integer> node5 = new NArrayTreeNode<>(5);
    	NArrayTreeNode<Integer> node6 = new NArrayTreeNode<>(6);
    	
    	root.children(node2);
    	root.children(node3);
    	root.children(node4);

    	node3.children(node5);
    	node3.children(node6);
    	
    	
    	ArrayList<Integer> bfsTraversal = bfs(root);
    	System.out.println("BFS Traversal:");
        for (int val : bfsTraversal) {
            System.out.print(val + " ");
        }
    }	
}
