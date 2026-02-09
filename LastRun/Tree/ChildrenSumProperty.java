package LastRun.Tree;
import java.util.*;

public class ChildrenSumProperty {

    // Binary Tree Node
    static class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    public static boolean isSumProperty(Node root) {

        if (root == null) return true;

        // Leaf node
        if (root.left == null && root.right == null) return true;

        int left = 0;
        int right = 0;

        if (root.left != null) {
            left = root.left.data;
        }

        if (root.right != null) {
            right = root.right.data;
        }

        return (root.data == left + right)
                && isSumProperty(root.left)
                && isSumProperty(root.right);
    }

    public static void main(String[] args) {

        /*
                10
               /  \
              8    2
             / \    \
            3   5    2
        */

        Node root = new Node(10);

        root.left = new Node(8);
        root.right = new Node(2);

        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(2);

        boolean result = isSumProperty(root);

        System.out.println("Children Sum Property Valid? " + result);
    }
}
