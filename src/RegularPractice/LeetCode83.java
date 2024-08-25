package RegularPractice;

/*83. Remove Duplicates from Sorted List
* Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
Example 1:
Input: head = [1,1,2]
Output: [1,2]
Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]
Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
* */

class ListNode83{
    int val;
    ListNode83 next;
    ListNode83(int val){
        this.val = val;
        next = null;
    }
    // Utility method to print the list
    static void printList(ListNode83 head) {
        ListNode83 current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
class RemoveDuplicatesFromSortList{
    public ListNode83 deleteDuplicates(ListNode83 head){
        ListNode83 current = head;
        while (current != null && current.next != null){
            if(current.next.val == current.val){
                current.next = current.next.next;
            } else{
                current = current.next;
            }
        }
        return head;
    }
}
public class LeetCode83 {
    public static void main(String[] args) {
        // Example 1: Input: [1,1,2]
        ListNode83 head1 = new ListNode83(1);
        head1.next = new ListNode83(1);
        head1.next.next = new ListNode83(2);

        // Example 2: Input: [1,1,2,3,3]
        ListNode83 head2 = new ListNode83(1);
        head2.next = new ListNode83(1);
        head2.next.next = new ListNode83(2);
        head2.next.next.next = new ListNode83(3);
        head2.next.next.next.next = new ListNode83(3);

        // Create an instance of the class
        RemoveDuplicatesFromSortList solution = new RemoveDuplicatesFromSortList();

        // Process the first example
        System.out.println("Before removing duplicates:");
        ListNode83.printList(head1);
        head1 = solution.deleteDuplicates(head1);
        System.out.println("After removing duplicates:");
        ListNode83.printList(head1);

        // Process the second example
        System.out.println("Before removing duplicates:");
        ListNode83.printList(head2);
        head2 = solution.deleteDuplicates(head2);
        System.out.println("After removing duplicates:");
        ListNode83.printList(head2);
    }
}
