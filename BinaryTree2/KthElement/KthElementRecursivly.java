package BinaryTree2.KthElement;

public class KthElementRecursivly {
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

    public static void KthElement(Node root,int level ,int k) {
        if(root == null) {
            return;
        }

        if(level == k) {
            System.out.println(root.data + " ");
            return;
        }

        KthElement(root.left,level+1,k);
        KthElement(root.right, level+1, k);
    }
    public static void main(String[] args) {
        int k = 3;
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.left = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        KthElement(root,1,k);
    }
}
