import java.util.LinkedList;
import java.util.Queue;

public class deleteNode {
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

    public static Node deletenode(Node root,int k) {
        if(root == null) {
            return null;
        }

        root.left = deletenode(root.left, k);
        root.right = deletenode(root.right, k);

        if(root.data == k && root.left == null && root.right == null) {
            return null;
        }

        return root;
    }

    public static void levelTreversal(Node root) {
            if(root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            
            while(!q.isEmpty()) {
                Node currNode = q.remove();
                // current element is null
                if(currNode == null) {
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }
                // current element is a number 
                else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if(currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(3);

        levelTreversal(root);
        deletenode(root, 3);
        levelTreversal(root);
    }
}
