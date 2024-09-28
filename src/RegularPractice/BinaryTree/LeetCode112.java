package RegularPractice.BinaryTree;

/* 112. Path Sum
*Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
A leaf is a node with no children.
Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
Example 2:
Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
Example 3:
Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
Constraints:
The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
* */


class Node112{
    int val;
    Node112 left, right;
    Node112(int val){
        this.val = val;
        left = right = null;
    }
}
class PathSum{
    public boolean hasPathSum(Node112 root, int targetSum){
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return targetSum == root.val;
        }

        boolean rightSum = hasPathSum(root.right, targetSum-root.val);
        boolean leftSum = hasPathSum(root.left, targetSum-root.val);
        return rightSum || leftSum;
    }
}
public class LeetCode112 {
    public static void main(String[] args) {
        // Create the binary tree for Example 1
        Node112 root1 = new Node112(5);
        root1.left = new Node112(4);
        root1.right = new Node112(8);
        root1.left.left = new Node112(11);
        root1.left.left.left = new Node112(7);
        root1.left.left.right = new Node112(2);
        root1.right.left = new Node112(13);
        root1.right.right = new Node112(4);
        root1.right.right.right = new Node112(1);

        int targetSum1 = 22;

        PathSum pathSum = new PathSum();
        System.out.println("Example 1: " + pathSum.hasPathSum(root1, targetSum1)); // Output: true

        // Create the binary tree for Example 2
        Node112 root2 = new Node112(1);
        root2.left = new Node112(2);
        root2.right = new Node112(3);

        int targetSum2 = 5;
        System.out.println("Example 2: " + pathSum.hasPathSum(root2, targetSum2)); // Output: false

        // Create the binary tree for Example 3 (empty tree)
        Node112 root3 = null;
        int targetSum3 = 0;
        System.out.println("Example 3: " + pathSum.hasPathSum(root3, targetSum3)); // Output: false
    }
}
