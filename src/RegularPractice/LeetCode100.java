package RegularPractice;

/* 100. Same Tree
* Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:
Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:
Input: p = [1,2,1], q = [1,1,2]
Output: false
Constraints:
The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104
* */

class Node100{
    int val;
    Node100 left, right;
     Node100(int val){
         this.val = val;
         left = right = null;
     }
}
class SameTree{
    public boolean isSameTree( Node100 p, Node100 q){
        if (p == null && q == null){
            return false;
        } else if (p == null){
            return false;
        } else if (q == null) {
            return false;
        } else if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
public class LeetCode100 {
    public static void main(String[] args) {
        SameTree tree = new SameTree();

        // Example 1: Input: p = [1,2,3], q = [1,2,3]
        Node100 p1 = new Node100(1);
        p1.left = new Node100(2);
        p1.right = new Node100(3);

        Node100 q1 = new Node100(1);
        q1.left = new Node100(2);
        q1.right = new Node100(3);

        System.out.println("Example 1: " + tree.isSameTree(p1, q1));  // Output: true

        // Example 2: Input: p = [1,2], q = [1,null,2]
        Node100 p2 = new Node100(1);
        p2.left = new Node100(2);

        Node100 q2 = new Node100(1);
        q2.right = new Node100(2);

        System.out.println("Example 2: " + tree.isSameTree(p2, q2));  // Output: false

        // Example 3: Input: p = [1,2,1], q = [1,1,2]
        Node100 p3 = new Node100(1);
        p3.left = new Node100(2);
        p3.right = new Node100(1);

        Node100 q3 = new Node100(1);
        q3.left = new Node100(1);
        q3.right = new Node100(2);

        System.out.println("Example 3: " + tree.isSameTree(p3, q3));  // Output: false
    }
}
