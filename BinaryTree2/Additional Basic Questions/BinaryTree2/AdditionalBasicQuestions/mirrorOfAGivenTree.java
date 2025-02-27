package BinaryTree2.AdditionalBasicQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class mirrorOfAGivenTree {
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

    public static Node Findmirror(Node root) {
        if(root == null) {
                return root;
            }

        Node leftNode = Findmirror(root.left);
        Node rightNode = Findmirror(root.right);

        root.left = rightNode;
        root.right = leftNode;

        // int temp = leftNode.data;
        // leftNode = rightNode;
        // rightNode.data = temp;

        return root;
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
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Original Tree.");
        levelTreversal(root);
        Findmirror(root);
        System.out.println("Mirror Tree.");
        levelTreversal(root);
    }
}
