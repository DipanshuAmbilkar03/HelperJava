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

    public static Node search(Node root, int key) {
        if(root == null) {
            return root;
        }

        if(root.data == key) {
            return root;
        }

        if(key < root.data) {
            root = search(root.left, key);
        }else{
            root = search(root.right, key);
        }

        return root;
    }
    
    public static boolean search2(Node root, int key) {
        if(root == null) {
            return false;
        }

        if(root.data == key) {
            return true;
        }

        if(key < root.data) {
            return search2(root.left, key);
        }else{
            return search2(root.right, key);
        }

    }

    public static Node deleteNode(Node root, int val) {
        if(root.data < val) {
            root.right = deleteNode(root.right, val);
        }

        else if(root.data > val) {
            root.left = deleteNode(root.left, val);
        }   

        else{
            // case -1 
            if(root.right == null && root.left == null) {
                return null;
            }
            
            // case - 2 
            if(root.left == null) {
                return root.right;
            }else if(root.right == null) {
                return root.left;
            }

            //case - 3
            Node IC = ICSuccessor(root.right);
            root.data = IC.data;
            root.right = deleteNode(root.right, IC.data);
        }   

        return root;
    }   

    public static Node ICSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;        
        }
        return root;
    }

    public static void findRange(Node root, int k1, int k2) {
        if(root == null) {
            return;
        }
        
        if(root.data >= k1 && root.data <= k2) {
            findRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            findRange(root.right, k1, k2);
        }

        else if(root.data < k1) {
            findRange(root.left, k1, k2);
        }

        else {
            findRange(root.right, k1, k2);
        }
    }


    public static void main(String[] args) {
        int[] values = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for(int i=0; i<values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);

        // Node result = search(root, 5);
        // if (result != null) {
        //     System.out.println("\nFound at index: " + result.data);
        // } else {
        //     System.out.println("\nNot Found!");
        // }
        
        // root = deleteNode(root, 1);
        // System.out.println("\nDeleted");
        // inorder(root);

        System.out.print("\nRange of nodes : ");
        findRange(root, 5, 12);
    }
}