package RegularPractice.BinaryTree.BinarySearchTree;
/*450. Delete Node in a BST
* Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
Basically, the deletion can be divided into two stages:
Search for a node to remove.
If the node is found, delete the node.

Example 1:
Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:

Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.
Example 3:

Input: root = [], key = 0
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 104].
-105 <= Node.val <= 105
Each node has a unique value.
root is a valid binary search tree.
-105 <= key <= 105

Follow up: Could you solve it with time complexity O(height of tree)?
* */

class Node450{
    int val;
    Node450 left,right;
    Node450(int val){
        this.val = val;
        left = right = null;
    }
}
class DeleteNodeInBST{
    public Node450 deleteNode(Node450 root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            // case 1
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            //case 3
            Node450 IS = inorderSuccessor(root.right);
            root.val = IS.val;
            root.right = deleteNode(root.right, IS.val);
        }
        return root;
    }

    private Node450 inorderSuccessor(Node450 root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
public class LeetCode450 {
    public static void main(String[] args) {
        DeleteNodeInBST tree = new DeleteNodeInBST();

        // Creating a sample tree: [5,3,6,2,4,null,7]
        Node450 root = new Node450(5);
        root.left = new Node450(3);
        root.right = new Node450(6);
        root.left.left = new Node450(2);
        root.left.right = new Node450(4);
        root.right.right = new Node450(7);

        // Printing the original tree
        System.out.println("Original tree (in-order):");
        printInOrder(root);
        System.out.println();

        // Deleting a value from the BST
        int keyToDelete = 3;
        root = tree.deleteNode(root, keyToDelete);

        // Printing the updated tree
        System.out.println("Updated tree after deleting " + keyToDelete + " (in-order):");
        printInOrder(root);
    }

    // Helper method to print the BST in-order
    public static void printInOrder(Node450 root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }
}
