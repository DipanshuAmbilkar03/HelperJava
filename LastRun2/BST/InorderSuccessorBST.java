package LastRun2.BST;

import java.util.*;

public class InorderSuccessorBST {

    // BST Node
    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    // Returns inorder successor value of node x
    public static int inorderSuccessor(Node root, Node x) {

        int ans = -1;

        while (root != null) {

            if (root.data > x.data) {
                ans = root.data;     // possible successor
                root = root.left;    // try to find smaller greater value
            } else {
                root = root.right;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        /*
                20
               /  \
              10   30
             / \   / \
            5  15 25  35
        */

        Node root = new Node(20);

        root.left = new Node(10);
        root.right = new Node(30);

        root.left.left = new Node(5);
        root.left.right = new Node(15);

        root.right.left = new Node(25);
        root.right.right = new Node(35);

        Node x = root.left;   // 10

        int successor = inorderSuccessor(root, x);

        System.out.println("Inorder Successor of " + x.data + " is: " + successor);
    }
}