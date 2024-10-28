package RegularPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 559. Maximum Depth of N-ary Tree
* Given a n-ary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: 3
Example 2:
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: 5
Constraints:
The total number of nodes is in the range [0, 104].
The depth of the n-ary tree is less than or equal to 1000.
* */
class Node559{
    int val;
   public List<Node559> children;
    Node559(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
   Node559(int val,List<Node559> children){
       this.val = val;
       this.children = children;
   }
}

class MaxDepthNTree{
    public int maxDepth(Node559 root){
       if( root == null){
           return 0;
       }
       int ans = dfs(root);
       return ans;
    }

    private int dfs(Node559 root) {
        if (root == null){
            return 0;
        }
        int maxDepth = 0;
        for (Node559 node : root.children){
            maxDepth = Math.max(maxDepth,dfs(node));
        }
        return maxDepth + 1;
    }
}
public class LeetCode559 {
    public static void main(String[] args) {
        // Example 1: root = [1,null,3,2,4,null,5,6]
        Node559 node5 = new Node559(5);
        Node559 node6 = new Node559(6);
        Node559 node3 = new Node559(3, Arrays.asList(node5, node6));
        Node559 node2 = new Node559(2);
        Node559 node4 = new Node559(4);
        Node559 root1 = new Node559(1, Arrays.asList(node3, node2, node4));

        MaxDepthNTree solution = new MaxDepthNTree();
        int result1 = solution.maxDepth(root1);
        System.out.println("Max Depth of Example 1: " + result1);  // Output: 3

        // Example 2: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
        Node559 node14 = new Node559(14);
        Node559 node13 = new Node559(13);
        Node559 node12 = new Node559(12);
        Node559 node11 = new Node559(11, Arrays.asList(node14));
        Node559 node10 = new Node559(10);
        Node559 node9 = new Node559(9);
        Node559 node8 = new Node559(8);
        Node559 node7 = new Node559(7, Arrays.asList(node11, node12, node13));
        Node559 node6_2 = new Node559(6);
        Node559 node5_2 = new Node559(5);
        Node559 node4_2 = new Node559(4);
        Node559 node3_2 = new Node559(3, Arrays.asList(node9, node10));
        Node559 node2_2 = new Node559(2, Arrays.asList(node6_2, node7, node8));
        Node559 root2 = new Node559(1, Arrays.asList(node2_2, node3_2, node4_2, node5_2));

        int result2 = solution.maxDepth(root2);
        System.out.println("Max Depth of Example 2: " + result2);  // Output: 5
    }
}
