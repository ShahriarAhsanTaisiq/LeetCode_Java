package RegularPractice.BinaryTree;

/*222. Count Complete Tree Nodes
* Given the root of a complete binary tree, return the number of the nodes in the tree.
According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
Design an algorithm that runs in less than O(n) time complexity.

Example 1:

Input: root = [1,2,3,4,5,6]
Output: 6
Example 2:

Input: root = []
Output: 0
Example 3:

Input: root = [1]
Output: 1

Constraints:

The number of nodes in the tree is in the range [0, 5 * 104].
0 <= Node.val <= 5 * 104
The tree is guaranteed to be complete.
* */

class TreeNode222{
    int val;
    TreeNode222 left;
    TreeNode222 right;
    TreeNode222(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
class CountNodesOfBTree{
    public int countNodes(TreeNode222 root){
        if (root == null){
            return 0;
        }
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return leftCount + rightCount + 1;
    }
}
public class LeetCode222 {
    public static void main(String[] args) {
        // Example 1: [1, 2, 3, 4, 5, 6]
        TreeNode222 root1 = new TreeNode222(1);
        root1.left = new TreeNode222(2);
        root1.right = new TreeNode222(3);
        root1.left.left = new TreeNode222(4);
        root1.left.right = new TreeNode222(5);
        root1.right.left = new TreeNode222(6);

        CountNodesOfBTree counter = new CountNodesOfBTree();
        System.out.println("Example 1: " + counter.countNodes(root1)); // Output: 6

        // Example 2: []
        TreeNode222 root2 = null;
        System.out.println("Example 2: " + counter.countNodes(root2)); // Output: 0

        // Example 3: [1]
        TreeNode222 root3 = new TreeNode222(1);
        System.out.println("Example 3: " + counter.countNodes(root3)); // Output: 1
    }
}
