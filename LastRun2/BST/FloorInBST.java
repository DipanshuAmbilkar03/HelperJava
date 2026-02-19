package LastRun2.BST;

import java.util.*;

public class FloorInBST {

    // BST Node
    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    public static int floor(Node root, int x) {

        int ans = -1;

        while (root != null) {

            if (root.data == x)
                return root.data;

            if (root.data < x) {
                ans = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        /*
                8
               / \
              4   12
             / \  / \
            2  6 10 14
        */

        Node root = new Node(8);

        root.left = new Node(4);
        root.right = new Node(12);

        root.left.left = new Node(2);
        root.left.right = new Node(6);

        root.right.left = new Node(10);
        root.right.right = new Node(14);

        int x = 11;

        int result = floor(root, x);

        System.out.println("Floor of " + x + " is: " + result);
    }
}
