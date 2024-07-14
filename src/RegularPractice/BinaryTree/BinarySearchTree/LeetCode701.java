package RegularPractice.BinaryTree.BinarySearchTree;

/*701. Insert into a Binary Search Tree
* You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

Example 1:
Input: root = [4,2,7,1,3], val = 5
Output: [4,2,7,1,3,5]
Explanation: Another accepted tree is:

Example 2:
Input: root = [40,20,60,10,30,50,70], val = 25
Output: [40,20,60,10,30,50,70,null,null,25]
Example 3:
Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
Output: [4,2,7,1,3,5]

Constraints:

The number of nodes in the tree will be in the range [0, 104].
-108 <= Node.val <= 108
All the values Node.val are unique.
-108 <= val <= 108
It's guaranteed that val does not exist in the original BST.
* */

class Node701{
    int val;
    Node701 left,right;
    Node701(int val){
        this.val = val;
        left = right = null;
    }
}

class InsertAtBST{
    public Node701 insetIntoBST( Node701 root, int val){
        if(root == null){
            root = new Node701(val);
            return root;
        }
        if (root.val > val){
            root.left = insetIntoBST(root.left, val);
        } else {
            root.right = insetIntoBST(root.right,val);
        }
        return root;
    }
}
public class LeetCode701 {
    public static void main(String[] args) {
        InsertAtBST tree = new InsertAtBST();

        // Creating a sample tree: [4,2,7,1,3]
        Node701 root = new Node701(4);
        root.left = new Node701(2);
        root.right = new Node701(7);
        root.left.left = new Node701(1);
        root.left.right = new Node701(3);

        // Inserting a value into the BST
        int valToInsert = 5;
        root = tree.insetIntoBST(root, valToInsert);

        // Printing the BST in-order to verify the insertion
        printInOrder(root);
    }

    // Helper method to print the BST in-order
    public static void printInOrder(Node701 root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }
}
