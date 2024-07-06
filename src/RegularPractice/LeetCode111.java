package RegularPractice;
/*111. Minimum Depth of Binary Tree
* Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5


Constraints:

The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000
* */
class TreeNode111{
    int val;
    TreeNode111 left;
    TreeNode111 right;
    TreeNode111(int val){
        this.val = val;
        left = null;
        right = null;
    }
}

class MinimumDepthBTree {
    public int minDepth(TreeNode111 root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);

        if (root.left == null) {
            return 1 + rightHeight;
        }
        if (root.right == null) {
            return 1 + leftHeight;
        }
        return Math.min(leftHeight, rightHeight) + 1;
    }
}
public class LeetCode111 {
    public static void main(String[] args) {
        // Create a binary tree for testing
        TreeNode111 root = new TreeNode111(1);
        root.left = new TreeNode111(2);
        root.right = new TreeNode111(3);
        root.left.left = new TreeNode111(4);
        root.left.right = new TreeNode111(5);
        root.right.left = new TreeNode111(6);
        root.left.left.left = new TreeNode111(7);

        // Create an instance of MaximumDepthBTree and test maxDepth
        MinimumDepthBTree tree = new MinimumDepthBTree();
        int depth = tree.minDepth(root);

        // Print the result
        System.out.println("The minimum depth of the binary tree is: " + depth);
    }

}
