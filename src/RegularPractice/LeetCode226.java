package RegularPractice;

/* 226. Invert Binary Tree
* Given the root of a binary tree, invert the tree, and return its root.
Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:
Input: root = [2,1,3]
Output: [2,3,1]
Example 3:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
* */

import java.util.LinkedList;
import java.util.Queue;

class TreeNode226{
    int val;
    TreeNode226 left, right;
    TreeNode226(int val){
        this.val = val;
        left = right = null;
    }
}

class InvertBinaryTree{
    public TreeNode226 invertTree(TreeNode226 root){
        if (root == null){
            return null;
        }
        TreeNode226 right = invertTree(root.right);
        TreeNode226 left  = invertTree(root.left);

        root.left = right;
        root.right = left;
        return root;
    }
}
public class LeetCode226 {
    public static void printLevelOrder(TreeNode226 root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode226> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode226 current = queue.poll();
            if (current != null) {
                System.out.print(current.val + " ");
                queue.add(current.left);
                queue.add(current.right);
            } else {
                System.out.print("null ");
            }
        }
        System.out.println();
    }

    // Helper method to build a binary tree from an array (for testing purposes)
    public static TreeNode226 buildTree(Integer[] values) {
        if (values.length == 0 || values[0] == null) return null;

        TreeNode226 root = new TreeNode226(values[0]);
        Queue<TreeNode226> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            TreeNode226 current = queue.poll();

            if (values[i] != null) {
                current.left = new TreeNode226(values[i]);
                queue.add(current.left);
            }
            i++;

            if (i < values.length && values[i] != null) {
                current.right = new TreeNode226(values[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

        // Test Case 1
        Integer[] values1 = {4, 2, 7, 1, 3, 6, 9};
        TreeNode226 root1 = buildTree(values1);
        System.out.println("Original tree:");
        printLevelOrder(root1);

        root1 = invertBinaryTree.invertTree(root1);
        System.out.println("Inverted tree:");
        printLevelOrder(root1);

        // Test Case 2
        Integer[] values2 = {2, 1, 3};
        TreeNode226 root2 = buildTree(values2);
        System.out.println("Original tree:");
        printLevelOrder(root2);

        root2 = invertBinaryTree.invertTree(root2);
        System.out.println("Inverted tree:");
        printLevelOrder(root2);

        // Test Case 3 (Empty Tree)
        Integer[] values3 = {};
        TreeNode226 root3 = buildTree(values3);
        System.out.println("Original tree:");
        printLevelOrder(root3);

        root3 = invertBinaryTree.invertTree(root3);
        System.out.println("Inverted tree:");
        printLevelOrder(root3);
    }
}
