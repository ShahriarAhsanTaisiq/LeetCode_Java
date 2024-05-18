package MayMonth;
/* 979. Distribute Coins in Binary Tree
*You are given the root of a binary tree with n nodes where each node in the tree has node.val coins. There are n coins in total throughout the whole tree.
In one move, we may choose two adjacent nodes and move one coin from one node to another. A move may be from parent to child, or from child to parent.
Return the minimum number of moves required to make every node have exactly one coin.
Example 1:
Input: root = [3,0,0]
Output: 2
Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.
Example 2:
Input: root = [0,3,0]
Output: 3
Explanation: From the left child of the root, we move two coins to the root [taking two moves]. Then, we move one coin from the root of the tree to the right child.
Constraints:
The number of nodes in the tree is n.
1 <= n <= 100
0 <= Node.val <= n
The sum of all Node.val is n.
* */

class TreeNode18May {
    int val;
    TreeNode18May left;
    TreeNode18May right;

    TreeNode18May() {}

    TreeNode18May(int val) {
        this.val = val;
    }

    TreeNode18May(int val, TreeNode18May left, TreeNode18May right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int moves = 0;

    public int distributeCoins(TreeNode18May root) {
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode18May node) {
        if (node == null) return 0;

        int leftBalance = dfs(node.left);
        int rightBalance = dfs(node.right);

        int balance = node.val + leftBalance + rightBalance - 1;

        moves += Math.abs(leftBalance) + Math.abs(rightBalance);

        return balance;
    }
}
public class Day18 {
    public static void main(String[] args) {
        // Example 1: root = [3,0,0]
        TreeNode18May root1 = new TreeNode18May(3);
        root1.left = new TreeNode18May(0);
        root1.right = new TreeNode18May(0);
        Solution solution1 = new Solution();
        System.out.println("Example 1: " + solution1.distributeCoins(root1));  // Output: 2

        // Example 2: root = [0,3,0]
        TreeNode18May root2 = new TreeNode18May(0);
        root2.left = new TreeNode18May(3);
        root2.right = new TreeNode18May(0);
        Solution solution2 = new Solution();
        System.out.println("Example 2: " + solution2.distributeCoins(root2));  // Output: 3

        // Additional test cases can be added here
        // Example 3: root = [1,0,2]
        TreeNode18May root3 = new TreeNode18May(1);
        root3.left = new TreeNode18May(0);
        root3.right = new TreeNode18May(2);
        Solution solution3 = new Solution();
        System.out.println("Example 3: " + solution3.distributeCoins(root3));  // Output: 2

        // Example 4: root = [1,0,0,null,3]
        TreeNode18May root4 = new TreeNode18May(1);
        root4.left = new TreeNode18May(0);
        root4.left.right = new TreeNode18May(3);
        Solution solution4 = new Solution();
        System.out.println("Example 4: " + solution4.distributeCoins(root4));  // Output: 4
    }
}
