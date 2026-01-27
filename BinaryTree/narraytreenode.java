package BinaryTree;

import java.util.*;

public class narraytreenode {
    static class NArrayTreeNode<E> {
        E data;
        ArrayList<NArrayTreeNode<E>> children;

		// public NArrayTreeNode(E data,ArrayList<NArayTreeNode> children) {
		// 	this.data = data;
		// 	this.children = children;
		// }

        public NArrayTreeNode(E data) {
            
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    public static ArrayList<Integer> bfs(NArrayTreeNode<Integer> root) {

        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<NArrayTreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            NArrayTreeNode<Integer> node = q.poll();
            res.add(node.data);

            for (NArrayTreeNode<Integer> child : node.children) {
                if (child != null) {
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

        root.children.add(node2);
        root.children.add(node3);
        root.children.add(node4);

        node3.children.add(node5);
        node3.children.add(node6);

        ArrayList<Integer> bfsTraversal = bfs(root);

        System.out.println("BFS Traversal:");
        for (int val : bfsTraversal) {
            System.out.print(val + " ");
        }
    }
}
