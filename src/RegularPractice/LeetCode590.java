package RegularPractice;

/* 590. N-ary Tree Postorder Traversal
* Given the root of an n-ary tree, return the postorder traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)
Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [5,6,3,2,4,1]
Example 2:
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
Constraints:
The number of nodes in the tree is in the range [0, 104].
0 <= Node.val <= 104
The height of the n-ary tree is less than or equal to 1000.
Follow up: Recursive solution is trivial, could you do it iteratively
* */

import java.util.*;

class Node590{
    int val;
    List<Node590> children;
    Node590(int val, List<Node590> children){
        this.val = val;
        this.children = children;
    }
}
class PostOrderTraversal{
    public List<Integer>  postorder(Node590 root){
        List<Integer> result = new ArrayList<>();
        postOrderTraversal(root, result);
        return result;
    }

    private void postOrderTraversal(Node590 node, List<Integer> result) {
        if (node == null) return;
        for (Node590 child : node.children){
            postOrderTraversal(child,result);
        }
        result.add(node.val);
    }
}
public class LeetCode590 {
    public static void main(String[] args) {
        // Example 1: Constructing the tree [1,null,3,2,4,null,5,6]
        Node590 node5 = new Node590(5, new ArrayList<>());
        Node590 node6 = new Node590(6, new ArrayList<>());
        List<Node590> children1 = new ArrayList<>(Arrays.asList(node5, node6));
        Node590 node3 = new Node590(3, children1);
        Node590 node2 = new Node590(2, new ArrayList<>());
        Node590 node4 = new Node590(4, new ArrayList<>());
        List<Node590> children2 = new ArrayList<>(Arrays.asList(node3, node2, node4));
        Node590 root1 = new Node590(1, children2);

        // Example 2: Constructing the tree [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
        Node590 node14 = new Node590(14, new ArrayList<>());
        Node590 node11 = new Node590(11, new ArrayList<>(Arrays.asList(node14)));
        Node590 node12 = new Node590(12, new ArrayList<>());
        Node590 node13 = new Node590(13, new ArrayList<>());
        Node590 node6_2 = new Node590(6, new ArrayList<>());
        Node590 node7 = new Node590(7, new ArrayList<>(Arrays.asList(node11)));
        Node590 node8 = new Node590(8, new ArrayList<>(Arrays.asList(node12)));
        Node590 node9 = new Node590(9, new ArrayList<>(Arrays.asList(node13)));
        Node590 node10 = new Node590(10, new ArrayList<>());
        Node590 node3_2 = new Node590(3, new ArrayList<>(Arrays.asList(node6_2, node7)));
        Node590 node4_2 = new Node590(4, new ArrayList<>(Arrays.asList(node8)));
        Node590 node5_2 = new Node590(5, new ArrayList<>(Arrays.asList(node9, node10)));
        Node590 node2_2 = new Node590(2, new ArrayList<>());
        List<Node590> children3 = new ArrayList<>(Arrays.asList(node2_2, node3_2, node4_2, node5_2));
        Node590 root2 = new Node590(1, children3);

        // PostOrder Traversal
        PostOrderTraversal traversal = new PostOrderTraversal();

        // Test with first example
        List<Integer> result1 = traversal.postorder(root1);
        System.out.println("Postorder traversal of tree 1: " + result1);

        // Test with second example
        List<Integer> result2 = traversal.postorder(root2);
        System.out.println("Postorder traversal of tree 2: " + result2);
    }
}
