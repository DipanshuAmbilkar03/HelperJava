package BinaryTree;
import java.util.*;
public class bfs {

    static class Tree<E> {
        E data;
        Tree<E> left;
        Tree<E> right;

        Tree(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // BFS / Level Order Traversal
    public static ArrayList<Integer> bfs(Tree<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Tree<Integer>> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Tree<Integer> node = q.poll();
            res.add(node.data);

            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }

        return res;
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */

        Tree<Integer> root = new Tree<>(1);
        root.left = new Tree<>(2);
        root.right = new Tree<>(3);

        root.left.left = new Tree<>(4);
        root.left.right = new Tree<>(5);
        root.right.right = new Tree<>(6);

        ArrayList<Integer> bfsTraversal = bfs(root);

        System.out.println("BFS Traversal:");
        for (int val : bfsTraversal) {
            System.out.print(val + " ");
        }
    }
}
