package BST2;

public class SortedArrToBalancedTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node sortToBal(int[] arr, int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = ( start + end ) / 2;
        Node root = new Node(arr[mid]);
        root.left = sortToBal(arr, start, mid-1);
        root.right = sortToBal(arr, mid+1, end);

        return root;
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

    public static void main(String[] args) {
        int[] arr = {3,5,6,7,8,10,11,12};
        Node root = sortToBal(arr, 0, arr.length-1);
        inorder(root);
    }
}
