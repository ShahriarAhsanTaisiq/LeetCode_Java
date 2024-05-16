package MayMonth;
/* 2331. Evaluate Boolean Binary Tree
* You are given the root of a full binary tree with the following properties:
Leaf nodes have either the value 0 or 1, where 0 represents False and 1 represents True.
Non-leaf nodes have either the value 2 or 3, where 2 represents the boolean OR and 3 represents the boolean AND.
The evaluation of a node is as follows:
If the node is a leaf node, the evaluation is the value of the node, i.e. True or False.
Otherwise, evaluate the node's two children and apply the boolean operation of its value with the children's evaluations.
Return the boolean result of evaluating the root node.
A full binary tree is a binary tree where each node has either 0 or 2 children.
A leaf node is a node that has zero children.
Example 1:
Input: root = [2,1,3,null,null,0,1]
Output: true
Explanation: The above diagram illustrates the evaluation process.
The AND node evaluates to False AND True = False.
The OR node evaluates to True OR False = True.
The root node evaluates to True, so we return true.
Example 2:
Input: root = [0]
Output: false
Explanation: The root node is a leaf node and it evaluates to false, so we return false.
Constraints:
The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 3
Every node has either 0 or 2 children.
Leaf nodes have a value of 0 or 1.
Non-leaf nodes have a value of 2 or 3.
*
* */
class TreeNode16May {
    int val;
    TreeNode16May left;
    TreeNode16May right;
    TreeNode16May() {}
    TreeNode16May(int val) { this.val = val; }
    TreeNode16May(int val, TreeNode16May left, TreeNode16May right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class EvaluateBinaryTree {
    public boolean evaluateTree(TreeNode16May root) {
        // Base case: If the node is a leaf node, return its value as boolean
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        // Recursive case: Evaluate the left and right subtrees
        boolean leftValue = evaluateTree(root.left);
        boolean rightValue = evaluateTree(root.right);

        // Apply the boolean operation based on the node's value
        if (root.val == 2) {
            // OR operation
            return leftValue || rightValue;
        } else if (root.val == 3) {
            // AND operation
            return leftValue && rightValue;
        }

        // The problem guarantees that all node values are either 0, 1, 2, or 3
        // So, there is no need to handle other cases
        return false; // This line will never be reached
    }
}

public class Day16 {
    public static void main(String[] args) {
        // Example 1: [2,1,3,null,null,0,1]
        TreeNode16May node1 = new TreeNode16May(1);
        TreeNode16May node0 = new TreeNode16May(0);
        TreeNode16May node1Right = new TreeNode16May(1);
        TreeNode16May andNode = new TreeNode16May(3, node0, node1Right);
        TreeNode16May root1 = new TreeNode16May(2, node1, andNode);

        // Example 2: [0]
        TreeNode16May root2 = new TreeNode16May(0);

        // Solution instance
        EvaluateBinaryTree solution = new EvaluateBinaryTree();

        // Evaluating the trees
        boolean result1 = solution.evaluateTree(root1);
        boolean result2 = solution.evaluateTree(root2);

        // Printing the results
        System.out.println("Result of evaluating tree 1: " + result1); // Expected: true
        System.out.println("Result of evaluating tree 2: " + result2); // Expected: false
    }
}
