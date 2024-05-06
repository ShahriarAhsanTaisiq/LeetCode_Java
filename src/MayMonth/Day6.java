package MayMonth;
/*2487. Remove Nodes From Linked List
* You are given the head of a linked list.
Remove every node which has a node with a greater value anywhere to the right side of it.
Return the head of the modified linked list.
Example 1:
Input: head = [5,2,13,3,8]
Output: [13,8]
Explanation: The nodes that should be removed are 5, 2 and 3.
- Node 13 is to the right of node 5.
- Node 13 is to the right of node 2.
- Node 8 is to the right of node 3.
Example 2:
Input: head = [1,1,1,1]
Output: [1,1,1,1]
Explanation: Every node has value 1, so no nodes are removed.
Constraints:
The number of the nodes in the given list is in the range [1, 105].
1 <= Node.val <= 105
* */
class ListNode6May {
    int val;
    ListNode6May next;
    ListNode6May() {}
    ListNode6May(int val) { this.val = val; }
    ListNode6May(int val, ListNode6May next) { this.val = val; this.next = next; }
}
class RemoveGreaterNode {
    public ListNode6May removeNodes(ListNode6May head) {
        if (head == null) {
            return null;
        }
        ListNode6May node = head;
        ListNode6May nxtGreater = removeNodes(node.next);

        node.next = nxtGreater;
        if (nxtGreater == null || node.val >= nxtGreater.val) {
            return node;
        }
        return nxtGreater;
    }
}

public class Day6 {
    public static void main(String[] args) {
        // Create a linked list: 5 -> 2 -> 13 -> 3 -> 8
        ListNode6May head = new ListNode6May(5);
        head.next = new ListNode6May(2);
        head.next.next = new ListNode6May(13);
        head.next.next.next = new ListNode6May(3);
        head.next.next.next.next = new ListNode6May(8);

        RemoveGreaterNode solution = new RemoveGreaterNode();
        ListNode6May result = solution.removeNodes(head);

        // Print the modified linked list
        printList(result);
    }

    // Helper function to print the linked list
    private static void printList(ListNode6May head) {
        ListNode6May current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
