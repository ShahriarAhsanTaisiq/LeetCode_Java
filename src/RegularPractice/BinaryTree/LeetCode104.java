package RegularPractice.BinaryTree;
/*104. Maximum Depth of Binary Tree
*Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
* */
class TreeNode104{
    int val;
    TreeNode104 left;
    TreeNode104 right;
    TreeNode104(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
class MaximumDepthBTree{
    public int maxDepth(TreeNode104 root){
        if (root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int result = Math.max(leftDepth,rightDepth) + 1;

        return result;
    }
}
public class LeetCode104 {
    public static void main(String[] args) {
        // Create a binary tree for testing
        TreeNode104 root = new TreeNode104(1);
        root.left = new TreeNode104(2);
        root.right = new TreeNode104(3);
        root.left.left = new TreeNode104(4);
        root.left.right = new TreeNode104(5);
        root.right.left = new TreeNode104(6);
        root.left.left.left = new TreeNode104(7);

        // Create an instance of MaximumDepthBTree and test maxDepth
        MaximumDepthBTree tree = new MaximumDepthBTree();
        int depth = tree.maxDepth(root);

        // Print the result
        System.out.println("The maximum depth of the binary tree is: " + depth);
    }
}
