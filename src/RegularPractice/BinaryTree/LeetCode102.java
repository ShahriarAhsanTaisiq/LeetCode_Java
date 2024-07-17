package RegularPractice.BinaryTree;
/*102. Binary Tree Level Order Traversal
* Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
* */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node102{
    int val;
    Node102 left,right;
    Node102(int val){
        this.val = val;
        left = right = null;
    }
}

class LevelOrderTraversal{
    public List<List<Integer>> levelOrder(Node102 root){
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null){
            return ans;
        }
        Queue<Node102> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; ++i){
                Node102 node = queue.poll();
                level.add(node.val);

                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            ans.add(level);
        }

        return ans;
    }
}
public class LeetCode102 {
    public static void main(String[] args) {
        // Test Case 1
        Node102 root1 = new Node102(3);
        root1.left = new Node102(9);
        root1.right = new Node102(20);
        root1.right.left = new Node102(15);
        root1.right.right = new Node102(7);

        LevelOrderTraversal lot = new LevelOrderTraversal();
        List<List<Integer>> result1 = lot.levelOrder(root1);
        System.out.println("Test Case 1: " + result1); // Expected Output: [[3], [9, 20], [15, 7]]

        // Test Case 2
        Node102 root2 = new Node102(1);
        List<List<Integer>> result2 = lot.levelOrder(root2);
        System.out.println("Test Case 2: " + result2); // Expected Output: [[1]]

        // Test Case 3
        Node102 root3 = null;
        List<List<Integer>> result3 = lot.levelOrder(root3);
        System.out.println("Test Case 3: " + result3); // Expected Output: []

    }
}
