public class univalidBinaryTreeOrNot {
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
            /* Current Tree    
         *          1
         *        /  \
         *       2   3
         *     / \  / \              
         *   4   5 6   7
         * */

    public static boolean univalideNode(Node root) {
        if(root == null) {
            return true;
        }

        if(root.left != null && root.data != root.left.data) {
            return false;
        }

        if(root.right != null && root.data != root.right.data){
            return false;
        }

        return univalideNode(root.left) && univalideNode(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(2);
        root.left.right = new Node(2);
    
        // System.out.println(univalideNode(root));

        if(univalideNode(root)) {
            System.out.println("YES!!! It is a Univalued tree.");
        }else{
            System.out.println("NO, It isn't a Univalued tree.");
        }
    }
}
