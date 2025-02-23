package RegularPractice;

/* 889. Construct Binary Tree from Preorder and Postorder Traversal
* Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.

If there exist multiple answers, you can return any of them.

Example 1:

Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]
Example 2:

Input: preorder = [1], postorder = [1]
Output: [1]

Constraints:

1 <= preorder.length <= 30
1 <= preorder[i] <= preorder.length
All the values of preorder are unique.
postorder.length == preorder.length
1 <= postorder[i] <= postorder.length
All the values of postorder are unique.
It is guaranteed that preorder and postorder are the preorder traversal and postorder traversal of the same binary tree.

* */

class Node889{
    int val;
    Node889 left;
    Node889 right;
    Node889(int val){
        this.val = val;
    }
    Node889(int val, Node889 left, Node889 right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ConstructBTFromPreAndPostOrder{
    int preIndx, postIndx;
    public Node889 constructFromPrePost(int [] preorder, int [] postorder){
        Node889 root = new Node889(preorder[preIndx]);
        preIndx++;
        if (root.val != postorder[postIndx]){
            root.left = constructFromPrePost(preorder, postorder);
        }
        if (root.val != postorder[postIndx]){
            root.right = constructFromPrePost(preorder, postorder);
        }
        postIndx++;
        return root;
    }
}

public class LeetCode889 {
    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        ConstructBTFromPreAndPostOrder treeBuilder = new ConstructBTFromPreAndPostOrder();
        Node889 root = treeBuilder.constructFromPrePost(preorder, postorder);

        // Print the tree in pre-order traversal to verify correctness
        printPreOrder(root);
    }

    private static void printPreOrder(Node889 root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
}
