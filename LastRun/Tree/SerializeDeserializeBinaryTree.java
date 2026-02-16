package LastRun.Tree;
import java.util.*;

public class SerializeDeserializeBinaryTree {

    // Binary Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Codec {

        // Preorder serialization
        private void dfs(TreeNode root, StringBuilder str) {
            if (root == null) {
                str.append("null,");
                return;
            }

            str.append(root.val).append(",");
            dfs(root.left, str);
            dfs(root.right, str);
        }

        public String serialize(TreeNode root) {
            StringBuilder str = new StringBuilder();
            dfs(root, str);
            return str.toString();
        }

        private TreeNode buildTree(Queue<String> queue) {

            String val = queue.poll();

            if (val.equals("null")) return null;

            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(queue);
            node.right = buildTree(queue);

            return node;
        }

        public TreeNode deserialize(String data) {

            String[] nodes = data.split(",");
            Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));

            return buildTree(queue);
        }
    }

    // For verification
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
                 / \
                4   5
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec ser = new Codec();
        Codec deser = new Codec();

        String serialized = ser.serialize(root);
        System.out.println("Serialized Tree:");
        System.out.println(serialized);

        TreeNode newRoot = deser.deserialize(serialized);

        System.out.println("Inorder of Deserialized Tree:");
        printInorder(newRoot);
    }
}
