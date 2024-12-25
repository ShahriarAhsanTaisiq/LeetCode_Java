package RegularPractice.BinaryTree;

/* 515. Find Largest Value in Each Tree Row
* Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

Example 1:

Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
Example 2:

Input: root = [1,2,3]
Output: [1,3]


Constraints:

The number of nodes in the tree will be in the range [0, 104].
-231 <= Node.val <= 231 - 1
* */

import java.util.ArrayList;
import java.util.List;

class Node515{
    int val;
    Node515 left,right;
    Node515(int val){
        this.val = val;
        left = right = null;
    }
}

class LargestValInEachRowTree{
    List<Integer> res;
    public List<Integer> largestValues(Node515 root) {
        res = new ArrayList<>();
        dfs(root,0);
        return res;
    }

    private void dfs(Node515 root, int level) {
        if( root != null){
            int val = root.val;
            if (res.size() == level){
                res.add(val);
            } else{
                res.set(level, Math.max(res.get(level), val));
            }
            dfs(root.left,level+1);
            dfs(root.right,level+1);
        }
    }
}

public class LeetCode515 {
    public static void main(String[] args) {
        Node515 root = new Node515(1);
        root.left = new Node515(3);
        root.right = new Node515(2);
        root.left.left = new Node515(5);
        root.left.right = new Node515(3);
        root.right.right = new Node515(9);

        // Call the largestValues method
        LargestValInEachRowTree solver = new LargestValInEachRowTree();
        List<Integer> result = solver.largestValues(root);

        // Print the result
        System.out.println("Largest values in each row: " + result);
    }
}
