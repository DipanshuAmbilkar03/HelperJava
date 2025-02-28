package BST1;

public class build {
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

    public static Node insert(Node root, int val) {
        if(root == null) {
            return new Node(val);
        }

        if(root.data > val) {
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data+",");
        inorder(root.right);

    }

    public static void main(String[] args) {
        int[] values = {6,10,5,1,9,3,8,4,2,7};
        Node root = null;

        for(int i=0; i<values.length; i++) {
            root = insert(root, values[i]);
        }
        
        // for(int i=1; i<=10; i++) {
        //     root = insert(root, i);
        // }

        inorder(root);
    }
}