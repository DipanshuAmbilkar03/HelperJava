package BST2;

public class validBST {
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

    static class Info {
        boolean isBst;
        int min;
        int max;
        int size;

        public Info(boolean isBst, int min, int max, int size) {
            this.isBst = isBst;
            this.min = min;
            this.size = size;
            this.max = max;
        }
    }

    public static int BSTsize = 0;

    public static Info isBstNode(Node root) {
        if(root == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);        }

        Info leftnode = isBstNode(root.left);
        Info rightNode = isBstNode(root.right);
        int size = leftnode.size + rightNode.size + 1;
        int min = Math.min(root.data , Math.min(leftnode.min, rightNode.min));
        int max = Math.max(root.data , Math.max(leftnode.max, rightNode.max));

        if(root.data <= leftnode.max || root.data >= rightNode.min ) {
            return new Info(false, min, max, size);
        }

        if(leftnode.isBst && rightNode.isBst){
            BSTsize = Math.max(BSTsize,size);
            return new Info(true, min, max, size);
        }

    return new Info(false, min, max, size);
    }

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+"->");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);        
        root.right.right = new Node(70);
        root.right.right.right = new Node(80);
        root.right.right.left = new Node(65);

        Info info = isBstNode(root);
        System.out.println("Largest Bst is : "+BSTsize);

        preOrder(Info);
    }   
}

