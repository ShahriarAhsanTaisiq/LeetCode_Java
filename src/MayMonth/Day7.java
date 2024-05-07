package MayMonth;
/* 2816. Double a Number Represented as a Linked List
* You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.
Return the head of the linked list after doubling it.
Example 1:
Input: head = [1,8,9]
Output: [3,7,8]
Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.
Example 2:
Input: head = [9,9,9]
Output: [1,9,9,8]
Explanation: The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998.
Constraints:
The number of nodes in the list is in the range [1, 104]
0 <= Node.val <= 9
The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.
* */

import java.util.Stack;

class ListNode7May {
    int val;
    ListNode7May next;
    ListNode7May() {}
    ListNode7May(int val) { this.val = val; }
    ListNode7May(int val, ListNode7May next) { this.val = val; this.next = next; }
}
class DoubleLinkedList {
    public ListNode7May doubleIt(ListNode7May head) {
        Stack<Integer> values = new Stack<>();
        int val = 0;

        while (head != null) {
            values.push(head.val);
            head = head.next;
        }

        ListNode7May newTail = null;

        while (!values.isEmpty() || val != 0) {
            newTail = new ListNode7May(0, newTail);

            if (!values.isEmpty()) {
                val += values.pop() * 2;
            }
            newTail.val = val % 10;
            val /= 10;
        }

        return newTail;
    }
}
public class Day7 {
    public static void main(String[] args) {
        // Create a sample linked list
        ListNode7May head1 = new ListNode7May(1);
        head1.next = new ListNode7May(8);
        head1.next.next = new ListNode7May(9);

        // Test Case 1
        DoubleLinkedList solution = new DoubleLinkedList();
        ListNode7May result1 = solution.doubleIt(head1);
        printList(result1); // Output: 3 -> 7 -> 8

        // Create another sample linked list
        ListNode7May head2 = new ListNode7May(9);
        head2.next = new ListNode7May(9);
        head2.next.next = new ListNode7May(9);

        // Test Case 2
        ListNode7May result2 = solution.doubleIt(head2);
        printList(result2); // Output: 1 -> 9 -> 9 -> 8
    }

    public static void printList(ListNode7May head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
