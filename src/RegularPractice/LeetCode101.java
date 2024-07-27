package RegularPractice;

/*101. Symmetric Tree
* Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:

Input: root = [1,2,2,null,3,null,3]
Output: false

Constraints:
The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
Follow up: Could you solve it both recursively and iteratively?

* */

class TreeNode101{
    int val;
    TreeNode101 left, right;
    TreeNode101(int val){
        this.val = val;
        left = right = null;
    }
}

class SymmetricTree{
    public boolean isSymmetric(TreeNode101 root){
        if (root == null){
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode101 root1, TreeNode101 root2) {
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }
        return root1.val == root2.val && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }
}
public class LeetCode101 {
    public static void main(String[] args) {
        // Test case 1
        TreeNode101 root1 = new TreeNode101(1);
        root1.left = new TreeNode101(2);
        root1.right = new TreeNode101(2);
        root1.left.left = new TreeNode101(3);
        root1.left.right = new TreeNode101(4);
        root1.right.left = new TreeNode101(4);
        root1.right.right = new TreeNode101(3);

        SymmetricTree st = new SymmetricTree();
        System.out.println(st.isSymmetric(root1));  // Output: true

        // Test case 2
        TreeNode101 root2 = new TreeNode101(1);
        root2.left = new TreeNode101(2);
        root2.right = new TreeNode101(2);
        root2.left.right = new TreeNode101(3);
        root2.right.right = new TreeNode101(3);

        System.out.println(st.isSymmetric(root2));  // Output: false
    }
}
