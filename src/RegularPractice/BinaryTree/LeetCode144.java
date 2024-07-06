package RegularPractice.BinaryTree;

/*144. Binary Tree Preorder Traversal
* Given the root of a binary tree, return the preorder traversal of its nodes' values.
Example 1:
Input: root = [1,null,2,3]
Output: [1,2,3]
Example 2:
Input: root = []
Output: []
Example 3:
Input: root = [1]
Output: [1]

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
* */

import java.util.ArrayList;
import java.util.List;

class TreeNode144{
    int val;
    TreeNode144 left;
    TreeNode144 right;
    TreeNode144(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
class preorderTraversalTree{
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode144 root){
        preOrder(root);
        return result;
    }

    private void preOrder(TreeNode144 root) {
        if (root == null){
            return;
        }
        result.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
public class LeetCode144 {
    public static void main(String[] args) {
        // Example 1
        TreeNode144 root1 = new TreeNode144(1);
        root1.right = new TreeNode144(2);
        root1.right.left = new TreeNode144(3);
        preorderTraversalTree traversal1 = new preorderTraversalTree();
        List<Integer> result1 = traversal1.preorderTraversal(root1);
        System.out.println(result1); // Output: [1, 2, 3]

        // Example 2
        TreeNode144 root2 = null;
        preorderTraversalTree traversal2 = new preorderTraversalTree();
        List<Integer> result2 = traversal2.preorderTraversal(root2);
        System.out.println(result2); // Output: []

        // Example 3
        TreeNode144 root3 = new TreeNode144(1);
        preorderTraversalTree traversal3 = new preorderTraversalTree();
        List<Integer> result3 = traversal3.preorderTraversal(root3);
        System.out.println(result3); // Output: [1]
    }
}
