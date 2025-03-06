package BST2;
import java.util.*;

public class merge2BST {
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
    
    public static void Inorder(Node root) {
        if(root == null) {
            return;
        }

        Inorder(root.left);
        System.out.println(root.data);
        Inorder(root.right);
    }

    public static void getInorder(Node root,ArrayList<Integer> arr) {
        if(root == null) {
            return;
        }

        getInorder(root.left,arr);
        arr.add(root.data);
        getInorder(root.right,arr);
    }

    public static Node createMergeBst(ArrayList<Integer> arr, int st, int end){
        if(st > end) { 
            return null;
        }
        
        int mid = ( st + end ) / 2;
        Node root = new Node(arr.get(mid));
        root.left = createMergeBst(arr, st, mid-1);
        root.right = createMergeBst(arr, mid+1, end);
        return root;
    }   

    public static Node mergeNode(Node root1, Node root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1,arr1);
        
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2,arr2);

        int i=0;int j=0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while(i<arr1.size() && j<arr2.size()) {
            if(arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            }else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        while(i<arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }
        while(j<arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }

        return createMergeBst(finalArr, 0, finalArr.size()-1);
    }
    public static void main(String[] args) {
        // tree 1
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        // tree 2
        Node root2 = new Node(5);
        root2.left = new Node(3);
        root2.right = new Node(6);

        Node mergedNode = mergeNode(root1, root2);
        Inorder(mergedNode);
    }
}
