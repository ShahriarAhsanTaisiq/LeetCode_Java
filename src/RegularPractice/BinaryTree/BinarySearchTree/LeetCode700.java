package RegularPractice.BinaryTree.BinarySearchTree;

/*700. Search in a Binary Search Tree
* You are given the root of a binary search tree (BST) and an integer val.
Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
Example 1:
Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]
Example 2:
Input: root = [4,2,7,1,3], val = 5
Output: []

Constraints:

The number of nodes in the tree is in the range [1, 5000].
1 <= Node.val <= 107
root is a binary search tree.
1 <= val <= 107
* */

class TreeNode700{
    int val;
    TreeNode700 left;
    TreeNode700 right;
    TreeNode700(int val){
        this.val = val;
        left = right = null;
    }
}
class SearchInBST{
    public TreeNode700 searchBST(TreeNode700 root, int val){
        if (root == null){
            return null;
        }
        if (root.val == val){
            return root;
        } else if (root.val > val){
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }


    }
}
public class LeetCode700 {
    public static void main(String[] args) {
        // Create a sample binary search tree
        TreeNode700 root = new TreeNode700(4);
        root.left = new TreeNode700(2);
        root.right = new TreeNode700(7);
        root.left.left = new TreeNode700(1);
        root.left.right = new TreeNode700(3);

        // Create an instance of the SearchInBST class
        SearchInBST search = new SearchInBST();

        // Test case 1
        int val1 = 2;
        TreeNode700 result1 = search.searchBST(root, val1);
        printTree(result1); // Expected output: 2 1 3

        // Test case 2
        int val2 = 5;
        TreeNode700 result2 = search.searchBST(root, val2);
        printTree(result2); // Expected output: (null or no output)
    }

    // Helper method to print the tree in pre-order traversal
    public static void printTree(TreeNode700 node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }
}
