package RegularPractice.BinaryTree;

/*145. Binary Tree Postorder Traversal
* Given the root of a binary tree, return the postorder traversal of its nodes' values.
Example 1:

Input: root = [1,null,2,3]
Output: [3,2,1]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]

Constraints:
The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
* */
import java.util.ArrayList;
import java.util.List;

class TreeNode145{
    int val;
    TreeNode145 left;
    TreeNode145 right;
    TreeNode145(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
class postorderTraversalTree{
    List<Integer> result = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode145 root){
        postOrder(root);
        return result;
    }

    private void postOrder(TreeNode145 root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        result.add(root.val);
    }
}
public class LeetCode145 {
    public static void main(String[] args) {
        // Example 1
        TreeNode145 root1 = new TreeNode145(1);
        root1.right = new TreeNode145(2);
        root1.right.left = new TreeNode145(3);
        postorderTraversalTree traversal1 = new postorderTraversalTree();
        List<Integer> result1 = traversal1.postorderTraversal(root1);
        System.out.println(result1); // Output: [1, 2, 3]

        // Example 2
        TreeNode145 root2 = null;
        postorderTraversalTree traversal2 = new postorderTraversalTree();
        List<Integer> result2 = traversal2.postorderTraversal(root2);
        System.out.println(result2); // Output: []

        // Example 3
        TreeNode145 root3 = new TreeNode145(1);
        postorderTraversalTree traversal3 = new postorderTraversalTree();
        List<Integer> result3 = traversal3.postorderTraversal(root3);
        System.out.println(result3); // Output: [1]
    }
}
