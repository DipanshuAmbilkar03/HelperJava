package BinaryTree;

public class subTreeOfAnotherTree {
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

    public static boolean isIdentical(Node root, Node subNode){
        // both node are null 
        if(root == null && subNode == null) {
            return true;
        }
        // either of a node is null or not equal 
        else if(root == null || subNode == null || root.data != subNode.data){
            return false;
        }
        // left subNode not same
        if(!isIdentical(root.left, subNode.left)){
            return false;
        } 
        // right subNode not same
        if(!isIdentical(root.right, subNode.right)){
            return false;
        } 

        return true;
    }

    public static boolean isSubtree(Node root,Node subNode) {
        if(root == null) {
            return false;
        }
        
        if(root.data == subNode.data) {
            if(isIdentical(root,subNode)) {
                return true;
            }
        }

        return isSubtree(root.left, subNode) || isSubtree(root.right, subNode);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        Node SubNode = new Node(2);
        SubNode.left = new Node(4);
        SubNode.right = new Node(5); 

        System.out.print(isSubtree(root, SubNode));
    }
}
