package RegularPractice;
/*110. Balanced Binary Tree
* Given a binary tree, determine if it is height-balanced
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:
Input: root = []
Output: true
Constraints:
The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
* */

class Node110{
    int val;
    Node110 left;
    Node110 right;
    Node110(int val){
        this.val = val;
        left = right = null;
    }
}

class BalancedBT{
    public boolean isBalanced(Node110 root){
        if (root == null)
            return true;
        if (Height(root) == -1)
            return false;
        return true;
    }

    private int Height(Node110 root) {
        if (root == null)
            return 0;
        int leftHeight = Height(root.left);
        int rightHeight = Height(root.right);
        if (leftHeight == -1 || rightHeight == -1)
            return -1;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
public class LeetCode110 {
    public static void main(String[] args) {
        // Create example trees to test the BalancedBT class

        // Example 1: Input: root = [3,9,20,null,null,15,7]
        Node110 root1 = new Node110(3);
        root1.left = new Node110(9);
        root1.right = new Node110(20);
        root1.right.left = new Node110(15);
        root1.right.right = new Node110(7);

        // Example 2: Input: root = [1,2,2,3,3,null,null,4,4]
        Node110 root2 = new Node110(1);
        root2.left = new Node110(2);
        root2.right = new Node110(2);
        root2.left.left = new Node110(3);
        root2.left.right = new Node110(3);
        root2.left.left.left = new Node110(4);
        root2.left.left.right = new Node110(4);

        // Example 3: Input: root = []
        Node110 root3 = null;

        // Instantiate BalancedBT class
        BalancedBT treeChecker = new BalancedBT();

        // Test each example
        System.out.println("Example 1: " + treeChecker.isBalanced(root1)); // Output: true
        System.out.println("Example 2: " + treeChecker.isBalanced(root2)); // Output: false
        System.out.println("Example 3: " + treeChecker.isBalanced(root3)); // Output: true
    }
}
