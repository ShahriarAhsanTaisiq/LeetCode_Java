package RegularPractice;

/*94. Binary Tree Inorder Traversal
* Given the root of a binary tree, return the inorder traversal of its nodes' values.
Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]
Example 2:
Input: root = []
Output: []
Example 3:
Input: root = [1]
Output: [1]

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
Follow up: Recursive solution is trivial, could you do it iteratively?
* */

import java.util.ArrayList;
import java.util.List;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
class InorderTraversalTree{
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root){
        inOrder(root);
        return result;
    }
    public void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        result.add(root.val);
        inOrder(root.right);
    }
}
public class LeetCode94 {
    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        InorderTraversalTree traversal1 = new InorderTraversalTree();
        List<Integer> result1 = traversal1.inorderTraversal(root1);
        System.out.println(result1); // Output: [1, 3, 2]

        // Example 2
        TreeNode root2 = null;
        InorderTraversalTree traversal2 = new InorderTraversalTree();
        List<Integer> result2 = traversal2.inorderTraversal(root2);
        System.out.println(result2); // Output: []

        // Example 3
        TreeNode root3 = new TreeNode(1);
        InorderTraversalTree traversal3 = new InorderTraversalTree();
        List<Integer> result3 = traversal3.inorderTraversal(root3);
        System.out.println(result3); // Output: [1]
    }
}
