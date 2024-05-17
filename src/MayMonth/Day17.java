package MayMonth;
/* 1325. Delete Leaves With a Given Value
* Given a binary tree root and an integer target, delete all the leaf nodes with value target.
Note that once you delete a leaf node with value target, if its parent node becomes a leaf node and has the value target, it should also be deleted (you need to continue doing that until you cannot).
Example 1:
Input: root = [1,2,3,2,null,2,4], target = 2
Output: [1,null,3,null,4]
Explanation: Leaf nodes in green with value (target = 2) are removed (Picture in left).
After removing, new nodes become leaf nodes with value (target = 2) (Picture in center).
Example 2:
Input: root = [1,3,3,3,2], target = 3
Output: [1,3,null,null,2]
Example 3:
Input: root = [1,2,null,2,null,2], target = 2
Output: [1]
Explanation: Leaf nodes in green with value (target = 2) are removed at each step.
Constraints:
The number of nodes in the tree is in the range [1, 3000].
1 <= Node.val, target <= 1000
* */

import java.util.*;

class TreeNode17May {
    int val;
    TreeNode17May left;
    TreeNode17May right;
    TreeNode17May(int x) { val = x; }
}

class DeleteLeaf {
    public TreeNode17May removeLeafNodes(TreeNode17May root, int target) {
        if (root == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        return root;
    }
}

public class Day17 {
    public static TreeNode17May createTree(Integer[] nodes) {
        if (nodes.length == 0) return null;

        TreeNode17May root = new TreeNode17May(nodes[0]);
        Queue<TreeNode17May> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode17May current = queue.poll();
            if (nodes[i] != null) {
                current.left = new TreeNode17May(nodes[i]);
                queue.add(current.left);
            }
            i++;
            if (i < nodes.length && nodes[i] != null) {
                current.right = new TreeNode17May(nodes[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Helper function to print the tree in level order
    public static void printTree(TreeNode17May root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode17May> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode17May current = queue.poll();
            if (current == null) {
                System.out.print("null ");
            } else {
                System.out.print(current.val + " ");
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example 1
        Integer[] nodes1 = {1, 2, 3, 2, null, 2, 4};
        int target1 = 2;
        TreeNode17May root1 = createTree(nodes1);
        DeleteLeaf sol1 = new DeleteLeaf();
        TreeNode17May result1 = sol1.removeLeafNodes(root1, target1);
        printTree(result1); // Expected Output: [1, null, 3, null, 4]

        // Example 2
        Integer[] nodes2 = {1, 3, 3, 3, 2};
        int target2 = 3;
        TreeNode17May root2 = createTree(nodes2);
        DeleteLeaf sol2 = new DeleteLeaf();
        TreeNode17May result2 = sol2.removeLeafNodes(root2, target2);
        printTree(result2); // Expected Output: [1, 3, null, null, 2]

        // Example 3
        Integer[] nodes3 = {1, 2, null, 2, null, 2};
        int target3 = 2;
        TreeNode17May root3 = createTree(nodes3);
        DeleteLeaf sol3 = new DeleteLeaf();
        TreeNode17May result3 = sol3.removeLeafNodes(root3, target3);
        printTree(result3); // Expected Output: [1]
    }
}
