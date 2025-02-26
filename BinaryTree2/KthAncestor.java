package BinaryTree2;

public class KthAncestor {
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
    
    public static int KthNode(Node root, int n,int k) {
        if(root == null) {
            return -1;
        }
        if(root.data == n) {
            return 0;
        }

        int leftDist = KthNode(root.left, n,k);
        int rightDist = KthNode(root.right, n,k);

        if(leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int maxDis = Math.max(leftDist, rightDist);

        if(maxDis+1 == k ){
            System.out.println("KthNode is : "+root.data);
        }

        return maxDis+1;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
    
        int n = 6;
        int k = 2; 

        KthNode(root, n, k);
    }
}

