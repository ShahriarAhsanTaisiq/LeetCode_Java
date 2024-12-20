package RegularPractice.BinaryTree;
/* 2415. Reverse Odd Levels of Binary Tree
* Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.
For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].Return the root of the reversed tree.
A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.
The level of a node is the number of edges along the path between it and the root node.

Example 1:

Input: root = [2,3,5,8,13,21,34]
Output: [2,5,3,8,13,21,34]
Explanation:
The tree has only one odd level.
The nodes at level 1 are 3, 5 respectively, which are reversed and become 5, 3.
Example 2:

Input: root = [7,13,11]
Output: [7,11,13]
Explanation:
The nodes at level 1 are 13, 11, which are reversed and become 11, 13.
Example 3:

Input: root = [0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]
Output: [0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]
Explanation:
The odd levels have non-zero values.
The nodes at level 1 were 1, 2, and are 2, 1 after the reversal.
The nodes at level 3 were 1, 1, 1, 1, 2, 2, 2, 2, and are 2, 2, 2, 2, 1, 1, 1, 1 after the reversal.

Constraints:

The number of nodes in the tree is in the range [1, 214].
0 <= Node.val <= 105
root is a perfect binary tree.
* */

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

class Node2415{
    int val;
    Node2415 left, right;
    public Node2415(Node2415 root){
        this.left = root;
        this.right = root;
    }

    public Node2415(int val) {
        this.val = val;
    }
}

class ReverseOddLevelBTree{
    public Node2415 reverseOddLevel(Node2415 root){
        OddLevelTraverse(root.left, root.right, 0);
        return root;
    }

    private void OddLevelTraverse(Node2415 left, Node2415 right, int level) {
        if (left == null && right == null) {
            return;
        }
        if(level % 2 == 0){
            int val = left.val;
            left.val = right.val;
            right.val = val;
        }
        OddLevelTraverse(left.left, right.right, level + 1);
        OddLevelTraverse(left.right, right.left, level + 1);
    }
}

public class LeetCode2415 {
    public static void main(String[] args) {
        ReverseOddLevelBTree tree = new ReverseOddLevelBTree();
        // Example 1: [2,3,5,8,13,21,34]
        Node2415 root1 = new Node2415(2);
        root1.left = new Node2415(3);
        root1.right = new Node2415(5);
        root1.left.left = new Node2415(8);
        root1.left.right = new Node2415(13);
        root1.right.left = new Node2415(21);
        root1.right.right = new Node2415(34);
        System.out.println("Example 1 - Original Tree:");
        printTree(root1);
        tree.reverseOddLevel(root1);
        System.out.println("Example 1 - After Reversing Odd Levels:");
        printTree(root1);

        // Example 2: [7,13,11]
        Node2415 root2 = new Node2415(7);
        root2.left = new Node2415(13);
        root2.right = new Node2415(11);
        System.out.println("Example 2 - Original Tree:");
        printTree(root2);
        tree.reverseOddLevel(root2);
        System.out.println("Example 2 - After Reversing Odd Levels:");
        printTree(root2);

        // Example 3: [0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]
        Node2415 root3 = new Node2415(0);
        root3.left = new Node2415(1);
        root3.right = new Node2415(2);
        root3.left.left = new Node2415(0);
        root3.left.right = new Node2415(0);
        root3.right.left = new Node2415(0);
        root3.right.right = new Node2415(0);
        root3.left.left.left = new Node2415(1);
        root3.left.left.right = new Node2415(1);
        root3.left.right.left = new Node2415(1);
        root3.left.right.right = new Node2415(1);
        root3.right.left.left = new Node2415(2);
        root3.right.left.right = new Node2415(2);
        root3.right.right.left = new Node2415(2);
        root3.right.right.right = new Node2415(2);
        System.out.println("Example 3 - Original Tree:");
        printTree(root3);
        tree.reverseOddLevel(root3);
        System.out.println("Example 3 - After Reversing Odd Levels:");
        printTree(root3);
    }

    // Helper method to print the tree in level-order
    private static void printTree(Node2415 root) {
        if (root == null) return;
        Queue<Node2415> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node2415 current = queue.poll();
            System.out.print(current.val + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        System.out.println();
    }
}
