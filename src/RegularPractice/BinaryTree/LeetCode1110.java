package RegularPractice.BinaryTree;

/*1110. Delete Nodes And Return Forest
* Given the root of a binary tree, each node in the tree has a distinct value.
After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
Return the roots of the trees in the remaining forest. You may return the result in any order.

Example 1:
Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
Example 2:

Input: root = [1,2,4,null,3], to_delete = [3]
Output: [[1,2,4]]


Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000.
* */

import java.util.*;

class TreeNode1110{
    int val;
    TreeNode1110 left,right;
    TreeNode1110(int val){
        this.val = val;
        left = right = null;
    }
}

class DelNodeAndReturnForest{
    private boolean[] s = new boolean[1001];
    private List<TreeNode1110> ans = new ArrayList<>();

    public List<TreeNode1110> delNodes(TreeNode1110 root, int[] to_delete) {
        for (int x : to_delete) {
            s[x] = true;
        }
        if (dfs(root) != null) {
            ans.add(root);
        }
        return ans;
    }

    private TreeNode1110 dfs(TreeNode1110 root) {
        if (root == null) {
            return null;
        }
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        if (!s[root.val]) {
            return root;
        }
        if (root.left != null) {
            ans.add(root.left);
        }
        if (root.right != null) {
            ans.add(root.right);
        }
        return null;
    }
}
public class LeetCode1110 {
    public static void main(String[] args) {
        DelNodeAndReturnForest solution = new DelNodeAndReturnForest();

        // Example 1
        TreeNode1110 root1 = new TreeNode1110(1);
        root1.left = new TreeNode1110(2);
        root1.right = new TreeNode1110(3);
        root1.left.left = new TreeNode1110(4);
        root1.left.right = new TreeNode1110(5);
        root1.right.left = new TreeNode1110(6);
        root1.right.right = new TreeNode1110(7);

        int[] to_delete1 = {3, 5};
        List<TreeNode1110> result1 = solution.delNodes(root1, to_delete1);
        System.out.println("Example 1: ");
        printForest(result1);

        // Example 2
        TreeNode1110 root2 = new TreeNode1110(1);
        root2.left = new TreeNode1110(2);
        root2.right = new TreeNode1110(4);
        root2.left.right = new TreeNode1110(3);

        int[] to_delete2 = {3};
        List<TreeNode1110> result2 = solution.delNodes(root2, to_delete2);
        System.out.println("Example 2: ");
        printForest(result2);
    }

    private static void printForest(List<TreeNode1110> forest) {
        for (TreeNode1110 root : forest) {
            List<List<Integer>> levels = new ArrayList<>();
            getLevels(root, levels, 0);
            System.out.println(levels);
        }
    }

    private static void getLevels(TreeNode1110 root, List<List<Integer>> levels, int level) {
        if (root == null) {
            return;
        }
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(root.val);
        getLevels(root.left, levels, level + 1);
        getLevels(root.right, levels, level + 1);
    }
}
