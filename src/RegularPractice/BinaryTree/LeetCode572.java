package RegularPractice.BinaryTree;

/*572. Subtree of Another Tree
* Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
*
Example 1:

Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
Example 2:

Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false

Constraints:

The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104
* */
class TreeNode572{
    int val;
    TreeNode572 left,right;
    TreeNode572(int val){
        this.val = val;
        left = right = null;
    }
}
class SubTreeOfAnotherTree{
    public boolean isSubTree(TreeNode572 root, TreeNode572 subRoot){
        if (subRoot== null){
            return true;
        }
        if (root == null){
            return false;
        }
        if (root.val == subRoot.val && isIdentical(root, subRoot)){
            return true;
        }
        return isSubTree(root.left,subRoot) || isSubTree(root.right, subRoot);
    }

    private boolean isIdentical(TreeNode572 root, TreeNode572 subRoot) {
        if (root==null && subRoot == null){
            return true;
        }
        if (root==null || subRoot == null){
            return false;
        }
        if (root.val == subRoot.val){
            return isIdentical(root.left,subRoot.left) && isIdentical(root.right,subRoot.right);
        }
        return false;
    }
}
public class LeetCode572 {
    public static void main(String[] args) {
        // Example 1
        TreeNode572 root1 = new TreeNode572(3);
        root1.left = new TreeNode572(4);
        root1.right = new TreeNode572(5);
        root1.left.left = new TreeNode572(1);
        root1.left.right = new TreeNode572(2);

        TreeNode572 subRoot1 = new TreeNode572(4);
        subRoot1.left = new TreeNode572(1);
        subRoot1.right = new TreeNode572(2);

        SubTreeOfAnotherTree solution = new SubTreeOfAnotherTree();
        boolean result1 = solution.isSubTree(root1, subRoot1);
        System.out.println("Example 1: " + result1); // Output: true

        // Example 2
        TreeNode572 root2 = new TreeNode572(3);
        root2.left = new TreeNode572(4);
        root2.right = new TreeNode572(5);
        root2.left.left = new TreeNode572(1);
        root2.left.right = new TreeNode572(2);
        root2.left.right.left = new TreeNode572(0);

        TreeNode572 subRoot2 = new TreeNode572(4);
        subRoot2.left = new TreeNode572(1);
        subRoot2.right = new TreeNode572(2);

        boolean result2 = solution.isSubTree(root2, subRoot2);
        System.out.println("Example 2: " + result2); // Output: false
    }
}
