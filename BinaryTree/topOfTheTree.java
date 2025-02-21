package BinaryTree;
import java.util.*;

public class topOfTheTree {
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
    static class Info {
        Node node;
        int hd;

        Info(Node node,int hd) {
            this.node = null;
            this.hd = hd;
        }
    }

    public static void topofTree(Node root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();

        int min = 0; int max = 0;

        q.add(new Info(root,0));   
        q.add(null);

        while(!q.isEmpty()) {
            Info curr = q.remove();

            if(curr == null) {
                if(q.isEmpty()) {
                    break;
                }else{
                    q.add(null);
                }
            }else{
                
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
    }
}
