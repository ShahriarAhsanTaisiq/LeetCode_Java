package RegularPractice;
/*19. Remove Nth Node From End of List
* Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:
Input: head = [1], n = 1
Output: []
Example 3:
Input: head = [1,2], n = 1
Output: [1]

Constraints:
The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
Follow up: Could you do this in one pass?
* */

class ListNode19{
    int val;
    ListNode19 next;
    ListNode19(){}
    ListNode19(int val){this.val=val; }
    ListNode19(int val, ListNode19 next) { this.val = val; this.next = next; }
}

class RemoveNthNodeFromLast{
    public ListNode19 removeNthNodeFromEnd(ListNode19 head, int n){
        if (head.next == null) return null;

        //size
        int size = 0;
        ListNode19 curr = head;
        while(curr != null){
            curr = curr.next;
            size++;
        }
        //base case
        if(size == n){
            return head.next;
        }

        int index = size-n;
        ListNode19 prev = head;
        int i = 1;
        while(i<index){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
    }
}
public class LeetCode19 {
    public static void printList(ListNode19 head) {
        ListNode19 curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example 1
        ListNode19 head1 = new ListNode19(1, new ListNode19(2, new ListNode19(3, new ListNode19(4, new ListNode19(5)))));
        int n1 = 2;
        RemoveNthNodeFromLast solution1 = new RemoveNthNodeFromLast();
        head1 = solution1.removeNthNodeFromEnd(head1, n1);
        System.out.print("Output 1: ");
        printList(head1); // Expected output: 1 2 3 5

        // Example 2
        ListNode19 head2 = new ListNode19(1);
        int n2 = 1;
        RemoveNthNodeFromLast solution2 = new RemoveNthNodeFromLast();
        head2 = solution2.removeNthNodeFromEnd(head2, n2);
        System.out.print("Output 2: ");
        printList(head2); // Expected output: (empty list)

        // Example 3
        ListNode19 head3 = new ListNode19(1, new ListNode19(2));
        int n3 = 1;
        RemoveNthNodeFromLast solution3 = new RemoveNthNodeFromLast();
        head3 = solution3.removeNthNodeFromEnd(head3, n3);
        System.out.print("Output 3: ");
        printList(head3); // Expected output: 1
    }
}
