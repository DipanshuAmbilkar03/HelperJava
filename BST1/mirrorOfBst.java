package BST1;

public class mirrorOfBst {
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

    public static Node inorder(Node root) {
        if(root == null) {
            return root;
        }

        inorder(root.left);
        System.out.print(root.data+"->");
        inorder(root.right);

        return root;
    } 

    public static Node mirrorBST(Node root) {
        if(root == null) {
            return root;
        }

        Node leftNode = mirrorBST(root.left);
        Node rightNode = mirrorBST(root.right);

        root.left = rightNode;
        root.right = leftNode;

        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        System.out.println("Original BST : ");
        inorder(root);
        System.out.println("\nMirror of the BST : ");
        mirrorBST(root);
        inorder(root);
    }
}
