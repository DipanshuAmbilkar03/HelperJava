package LastRun2.BST;

import java.util.*;

public class BSTIteratorDemo {

    // BST Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class BSTIterator {

        private Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            leftPush(root);
        }

        public int next() {

            TreeNode node = stack.pop();

            if (node.right != null) {
                leftPush(node.right);
            }

            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void leftPush(TreeNode node) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

    public static void main(String[] args) {

        /*
                7
               / \
              3   15
                 /  \
                9    20
        */

        TreeNode root = new TreeNode(7);

        root.left = new TreeNode(3);
        root.right = new TreeNode(15);

        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root);

        System.out.println("BST Iterator Output:");

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}