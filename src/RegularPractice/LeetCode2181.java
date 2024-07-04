package RegularPractice;

/*2181. Merge Nodes in Between Zeros
* You are given the head of a linked list, which contains a series of integers separated by 0's. The beginning and end of the linked list will have Node.val == 0.
For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes. The modified list should not contain any 0's.
Return the head of the modified linked list.

Example 1:

Input: head = [0,3,1,0,4,5,2,0]
Output: [4,11]
Explanation:
The above figure represents the given linked list. The modified list contains
- The sum of the nodes marked in green: 3 + 1 = 4.
- The sum of the nodes marked in red: 4 + 5 + 2 = 11.
Example 2:

Input: head = [0,1,0,3,0,2,2,0]
Output: [1,3,4]
Explanation:
The above figure represents the given linked list. The modified list contains
- The sum of the nodes marked in green: 1 = 1.
- The sum of the nodes marked in red: 3 = 3.
- The sum of the nodes marked in yellow: 2 + 2 = 4.
Constraints:

The number of nodes in the list is in the range [3, 2 * 105].
0 <= Node.val <= 1000
There are no two consecutive nodes with Node.val == 0.
The beginning and end of the linked list have Node.val == 0.
* */
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class MergeNodeBtw0s {
    public ListNode mergeNodes(ListNode head) {
        ListNode current = head.next;
        ListNode nextSum = current;

        while (nextSum != null) {
            int sum = 0;
            while (nextSum.val != 0) {
                sum += nextSum.val;
                nextSum = nextSum.next;
            }
            // Update current node with the summed value
            current.val = sum;

            // Move to the next segment, skipping the zero
            nextSum = nextSum.next;
            current.next = nextSum;

            // Move the current pointer
            current = current.next;
        }
        return head.next;
    }
}

public class LeetCode2181 {
    public static void main(String[] args) {
        // Create the linked list: [0, 3, 1, 0, 4, 5, 2, 0]
        ListNode head = new ListNode(0);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);

        // Create an instance of MergeNodeBtw0s and call mergeNodes method
        MergeNodeBtw0s solution = new MergeNodeBtw0s();
        ListNode result = solution.mergeNodes(head);

        // Print the resulting linked list
        printList(result);
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}