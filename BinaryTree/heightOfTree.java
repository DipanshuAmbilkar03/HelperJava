package BinaryTree;
import java.util.*;

public class heightOfTree {
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

    public static int heightofTree(Node root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = heightofTree(root.left);
        int rightHeight = heightofTree(root.right);

        return (Math.max(leftHeight, rightHeight)+1);
    }

    public static int countNode(Node root) {
        if(root == null) {
            return 0;
        }

        int leftNode = countNode(root.left);
        int rightNode = countNode(root.right);

        return leftNode + rightNode + 1;
    }
    public static void main(String[] args) {
        System.out.println("enter root node : ");
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node root = new Node(data);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
    
        System.out.println("Height of the tree : "+heightofTree(root));

        System.out.println("Total number of nodes are : " + countNode(root));
    }
}
