package BinaryTree2;

import java.util.LinkedList;
import java.util.Queue;

public class sumTree {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void levelTreversal(Node root) {
            if(root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            
            while(!q.isEmpty()) {
                Node currNode = q.remove();
                // current element is null
                if(currNode == null) {
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }
                // current element is a number 
                else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if(currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

    public static int sumTrees(Node root) {
        if(root == null) { 
            return 0; 
        }

        int leftData = sumTrees(root.left);
        int rightData = sumTrees(root.right);

        int data = root.data;

        int leftNode = root.left == null ? 0 : root.left.data;
        int rightNode = root.right == null ? 0 : root.right.data;

        root.data = leftData + rightData + leftNode + rightNode;

        return data;
    }

    public static void main(String[] args) {
        /* Current Tree    
         *          1
         *        /  \
         *       2   3
         *     / \  / \              
         *   4   5 6   7
         * 
         *  Expected answer 
         *          25
         *        /  \
         *       9   13
         *     / \  / \              
         *    0  0 0   0
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        sumTrees(root);
        levelTreversal(root);
    }
}
