package BinaryTree;
import java.util.*;

public class bulidTree{
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    } 

    static class binaryTree {
        static int idx = -1;
        public static Node BT(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = BT(nodes);
            newNode.right = BT(nodes);
        
            return newNode;
        }
        
        public static void inOrder(Node root) {
            if(root == null) {
                return;
            }
            
            inOrder(root.left);
            System.out.print(root.data + "->");
            inOrder(root.right);
        }

        public static void postOrder(Node root) {
            if(root == null) {
                return;
            }
            
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + "->");
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
    }
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
    
        binaryTree tree = new binaryTree();
        Node root = tree.BT(nodes);
        System.out.println("First element of the tree : "+root.data);

        System.out.print("inOrder : ");
        tree.inOrder(root);
        System.out.println();
        System.out.print("Post Order : ");
        tree.postOrder(root);
        System.out.println();

        System.out.println("level wise treversal : ");
        tree.levelTreversal(root);
    }
}