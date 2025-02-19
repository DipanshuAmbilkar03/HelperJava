package BinaryTree;
import java.util.*;

public class diameterOfATree {
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

    public static int diameterOfTree(Node root) {
        if(root == null) {
            return 0;
        }

        int leftDia = diameterOfTree(root.left);
        int rightDia = diameterOfTree(root.right);
        int leftHeight = heightofTree(root.left);
        int rightHeight = heightofTree(root.right);

        int selfHeight = leftHeight + rightHeight + 1;
        return Math.max(selfHeight , Math.max(leftDia , rightDia));
    }

    static class Info {
        int dia;
        int ht;

        private Info(int dia,int ht) {
            this.dia = dia;
            this.ht = ht;
        }
    }
    public static Info diameter(Node root) {
        if(root == null){
            return new Info(0,0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int dia = Math.max(Math.max(leftInfo.dia,rightInfo.dia ), leftInfo.ht+rightInfo.ht+1);
        int ht = Math.max(leftInfo.ht ,rightInfo.ht) + 1;

        return new Info(dia, ht);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Diameter of the tree : " + diameterOfTree(root));

        System.out.println(diameter(root).dia);
    }
}
