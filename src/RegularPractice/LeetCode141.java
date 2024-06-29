package RegularPractice;
/*141. Linked List Cycle
* Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.

Follow up: Can you solve it using O(1) (i.e. constant) memory?
* */

class ListNode141{
    int val;
    ListNode141 next;
    ListNode141(int val, ListNode141 next){
        this.val = val;
        this.next = next;
    }
}

class LinkedListCycle {
    public boolean hasCycle(ListNode141 head){
        if (head == null) return false;
        ListNode141 here = head;
        ListNode141 turtle = head;
        while (here != null && here.next != null){
            here = here.next.next;
            turtle = turtle.next;
            if (here == turtle){
                return true;
            }
        }
        return false;
    }
}
public class LeetCode141 {
    public static void main(String[] args) {
        // Create a linked list with a cycle
        ListNode141 node1 = new ListNode141(1, null);
        ListNode141 node2 = new ListNode141(2, null);
        ListNode141 node3 = new ListNode141(3, null);
        ListNode141 node4 = new ListNode141(4, null);

        // Link the nodes
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates a cycle

        // Create an instance of LinkedListCycle
        LinkedListCycle cycleChecker = new LinkedListCycle();

        // Check if the linked list has a cycle
        boolean result = cycleChecker.hasCycle(node1);
        System.out.println("Linked List has cycle: " + result); // Should print true

        // Create a linked list without a cycle
        ListNode141 nodeA = new ListNode141(1, null);
        ListNode141 nodeB = new ListNode141(2, null);
        ListNode141 nodeC = new ListNode141(3, null);

        // Link the nodes
        nodeA.next = nodeB;
        nodeB.next = nodeC;

        // Check if the linked list has a cycle
        result = cycleChecker.hasCycle(nodeA);
        System.out.println("Linked List has cycle: " + result); // Should print false
    }
}
