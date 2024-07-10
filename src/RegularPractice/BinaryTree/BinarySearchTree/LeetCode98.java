package RegularPractice.BinaryTree.BinarySearchTree;

/*98. Validate Binary Search Tree
* Given the root of a binary tree, determine if it is a valid binary search tree (BST).
A valid BST is defined as follows:
The left
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [2,1,3]
Output: true
Example 2:

Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
 * */


class TreeNode98{
    int val;
    TreeNode98 left;
    TreeNode98 right;
    TreeNode98(int val){
        this.val = val;
        left = right = null;
    }
}
class ValidateBST{
    public boolean isValidBST(TreeNode98 root){
        return helper(root, null, null);
    }

    private boolean helper(TreeNode98 root, Integer min, Integer max) {
        if (root == null){
            return true;
        }
        if ((min != null && root.val <= min) || (max != null && root.val >= max)){
            return false;
        }
        return helper(root.left,min,root.val) && helper(root.right, root.val, max);
    }

}
public class LeetCode98 {
    public static void main(String[] args) {
        // Example 1: [2,1,3]
        TreeNode98 root1 = new TreeNode98(2);
        root1.left = new TreeNode98(1);
        root1.right = new TreeNode98(3);

        ValidateBST validator = new ValidateBST();
        boolean isValid1 = validator.isValidBST(root1);
        System.out.println("Example 1 is valid BST: " + isValid1); // Output should be true

        // Example 2: [5,1,4,null,null,3,6]
        TreeNode98 root2 = new TreeNode98(5);
        root2.left = new TreeNode98(1);
        root2.right = new TreeNode98(4);
        root2.right.left = new TreeNode98(3);
        root2.right.right = new TreeNode98(6);

        boolean isValid2 = validator.isValidBST(root2);
        System.out.println("Example 2 is valid BST: " + isValid2); // Output should be false
    }
}
