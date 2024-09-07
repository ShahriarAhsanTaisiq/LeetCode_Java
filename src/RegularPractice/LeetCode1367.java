package RegularPractice;

/*1367. Linked List in Binary Tree
* Given a binary tree root and a linked list with head as the first node.
Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.
In this context downward path means a path that starts at some node and goes downwards.

Example 1:
Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true
Explanation: Nodes in blue form a subpath in the binary Tree.
Example 2:
Input: head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true
Example 3:
Input: head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: false
Explanation: There is no path in the binary tree that contains all the elements of the linked list from head.
Constraints:
The number of nodes in the tree will be in the range [1, 2500].
The number of nodes in the list will be in the range [1, 100].
1 <= Node.val <= 100 for each node in the linked list and binary tree.
* */

class ListNode1367{
    int val;
    ListNode1367 next;
    ListNode1367(int val){
        this.val = val;
        next = null;
    }
}

class TreeNode1367{
    int val;
    TreeNode1367 left;
    TreeNode1367 right;
    TreeNode1367(int val){
        this.val = val;
        left = right = null;
    }
}

class LinkedListBT{
    public  boolean isSubPath(ListNode1367 head, TreeNode1367 root){
        return dfs(head,head,root);
    }

    private boolean dfs(ListNode1367 head, ListNode1367 cur, TreeNode1367 root) {
        if (cur == null) return true;
        if (root == null) return false;

        if (cur.val == root.val){
            cur = cur.next;
        } else if (head.val == root.val) {
            head = head.next;
        } else {
            cur = head;
        }
        return dfs(head,cur,root.left) || dfs(head, cur, root.right);
    }
}
public class LeetCode1367 {
    private static ListNode1367 createLinkedList(int[] values) {
        ListNode1367 head = new ListNode1367(values[0]);
        ListNode1367 current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode1367(values[i]);
            current = current.next;
        }
        return head;
    }

    // Helper function to create a binary tree from an array (BFS representation)
    private static TreeNode1367 createBinaryTree(Integer[] values) {
        if (values.length == 0 || values[0] == null) {
            return null;
        }
        TreeNode1367 root = new TreeNode1367(values[0]);
        TreeNode1367[] nodes = new TreeNode1367[values.length];
        nodes[0] = root;
        int i = 1;
        for (int j = 0; i < values.length; j++) {
            if (nodes[j] != null) {
                if (i < values.length && values[i] != null) {
                    nodes[j].left = new TreeNode1367(values[i]);
                    nodes[i] = nodes[j].left;
                }
                i++;
                if (i < values.length && values[i] != null) {
                    nodes[j].right = new TreeNode1367(values[i]);
                    nodes[i] = nodes[j].right;
                }
                i++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] list1 = {4, 2, 8};
        Integer[] tree1 = {1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3};

        ListNode1367 head1 = createLinkedList(list1);
        TreeNode1367 root1 = createBinaryTree(tree1);

        LinkedListBT linkedListBT = new LinkedListBT();
        System.out.println(linkedListBT.isSubPath(head1, root1));  // Expected output: true

        // Test Case 2
        int[] list2 = {1, 4, 2, 6};
        Integer[] tree2 = {1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3};

        ListNode1367 head2 = createLinkedList(list2);
        TreeNode1367 root2 = createBinaryTree(tree2);

        System.out.println(linkedListBT.isSubPath(head2, root2));  // Expected output: true

        // Test Case 3
        int[] list3 = {1, 4, 2, 6, 8};
        Integer[] tree3 = {1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3};

        ListNode1367 head3 = createLinkedList(list3);
        TreeNode1367 root3 = createBinaryTree(tree3);

        System.out.println(linkedListBT.isSubPath(head3, root3));  // Expected output: false
    }
}
