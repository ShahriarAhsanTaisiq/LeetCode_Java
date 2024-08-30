package RegularPractice;
/* 206. Reverse Linked List
* Given the head of a singly linked list, reverse the list, and return the reversed list.
Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]Example 2:
Input: head = [1,2]
Output: [2,1]
Example 3:
Input: head = []
Output: []
Constraints:
The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
* */
class ListNode206{
    int val;
    ListNode206 next;
    ListNode206(int val){
        this.val = val;
        next = null;
    }
}
class ReverseLinkedList{
    public ListNode206 reverseList(ListNode206 head){
        ListNode206 prev = null;
        ListNode206 current = head;

        while (current != null){
            ListNode206 next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return  prev;
    }
}
public class LeetCode206 {
    // Helper method to create a linked list from an array of values
    public static ListNode206 createLinkedList(int[] values) {
        if (values.length == 0) {
            return null;
        }
        ListNode206 head = new ListNode206(values[0]);
        ListNode206 current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode206(values[i]);
            current = current.next;
        }
        return head;
    }

    // Helper method to print a linked list
    public static void printLinkedList(ListNode206 head) {
        ListNode206 current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method to test reverseList method
    public static void main(String[] args) {
        ReverseLinkedList reverser = new ReverseLinkedList();

        // Test case 1
        int[] values1 = {1, 2, 3, 4, 5};
        ListNode206 head1 = createLinkedList(values1);
        System.out.print("Original list: ");
        printLinkedList(head1);

        ListNode206 reversedHead1 = reverser.reverseList(head1);
        System.out.print("Reversed list: ");
        printLinkedList(reversedHead1);

        // Test case 2
        int[] values2 = {1, 2};
        ListNode206 head2 = createLinkedList(values2);
        System.out.print("Original list: ");
        printLinkedList(head2);

        ListNode206 reversedHead2 = reverser.reverseList(head2);
        System.out.print("Reversed list: ");
        printLinkedList(reversedHead2);

        // Test case 3
        int[] values3 = {};
        ListNode206 head3 = createLinkedList(values3);
        System.out.print("Original list: ");
        printLinkedList(head3);

        ListNode206 reversedHead3 = reverser.reverseList(head3);
        System.out.print("Reversed list: ");
        printLinkedList(reversedHead3);
    }
}
