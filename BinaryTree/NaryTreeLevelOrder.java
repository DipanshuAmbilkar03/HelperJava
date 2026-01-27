package BinaryTree;
import java.util.*;

public class NaryTreeLevelOrder {

    // N-ary Tree Node
    static class Node {
        int val;
        List<Node> children;

        Node() {
            children = new ArrayList<>();
        }

        Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }

        Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    // Level Order Traversal
    public static List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                level.add(node.val);

                for (Node child : node.children) {
                    if (child != null) {
                        q.offer(child);
                    }
                }
            }

            res.add(level);
        }

        return res;
    }

    public static void main(String[] args) {

        /*
                1
             /  |  \
            2   3   4
               / \
              5   6
        */

        Node root = new Node(1);

        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        root.children.add(node2);
        root.children.add(node3);
        root.children.add(node4);

        node3.children.add(node5);
        node3.children.add(node6);

        List<List<Integer>> result = levelOrder(root);

        System.out.println("Level Order Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
