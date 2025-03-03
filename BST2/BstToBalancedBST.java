package BST2;
import java.util.*;

public class BstToBalancedBST {
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

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+"->");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public static void getInorder(Node root,ArrayList<Integer> inorder) {
        if(root == null) {
            return;
        }

        getInorder(root.left, inorder);
        System.out.print(root.data+"->");
        getInorder(root.right, inorder);
    }

    public static Node createNode(ArrayList<Integer> inorder, int st, int end) {
        if(st > end) {
            return null;
        }
        int mid = ( st + end ) / 2;

        Node root = new Node(inorder.get(mid));
        root.left = createNode(inorder, st, mid-1);
        root.right = createNode(inorder, mid+1 , end);

        return root;
    }

    public static Node BstToBalBst(Node root) {
        // inorder
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root,inorder);

        // bst 
        root = createNode(inorder, 0, inorder.size()-1);
        
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        System.out.println("Original BST : ");
        BstToBalBst(root);
        System.out.println("\nBalanced BST : ");
        preOrder(root);
    }
}
