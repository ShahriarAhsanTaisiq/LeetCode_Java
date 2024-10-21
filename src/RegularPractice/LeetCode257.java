package RegularPractice;

import java.util.*;

/* 257. Binary Tree Paths
* Given the root of a binary tree, return all root-to-leaf paths in any order.
A leaf is a node with no children.
Example 1:
Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:
Input: root = [1]
Output: ["1"]

Constraints:
The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100
* */
class TreeNode257{
    int val;
    TreeNode257 left, right;
    TreeNode257(int val){
        this.val = val;
        left = right = null;
    }
}

class BinaryTreePath{
    public List<String> binaryTreePaths(TreeNode257 root) {
        List<String> res = new ArrayList<>();
        traverse(root, res, "");
        return res;
    }
    private void traverse(TreeNode257 root, List<String> res, String s){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            res.add( s + root.val);
            return;
        }
        traverse( root.left, res, s + root.val + "->");
        traverse( root.right, res, s + root.val + "->");
    }

}
public class LeetCode257 {
    public static void main(String[] args) {
        // Example 1: root = [1, 2, 3, null, 5]
        TreeNode257 root1 = new TreeNode257(1);
        root1.left = new TreeNode257(2);
        root1.right = new TreeNode257(3);
        root1.left.right = new TreeNode257(5);

        BinaryTreePath treePath1 = new BinaryTreePath();
        List<String> result1 = treePath1.binaryTreePaths(root1);
        System.out.println("Example 1 Output: " + result1); // Expected Output: ["1->2->5", "1->3"]

        // Example 2: root = [1]
        TreeNode257 root2 = new TreeNode257(1);

        BinaryTreePath treePath2 = new BinaryTreePath();
        List<String> result2 = treePath2.binaryTreePaths(root2);
        System.out.println("Example 2 Output: " + result2); // Expected Output: ["1"]
    }
}
