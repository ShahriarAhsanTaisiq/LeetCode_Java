package RegularPractice;
/*234. Palindrome Linked List
* Given the head of a singly linked list, return true if it is a
palindrome or false otherwise.

Example 1:
Input: head = [1,2,2,1]
Output: true
Example 2:
Input: head = [1,2]
Output: false

Constraints:
The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
Follow up: Could you do it in O(n) time and O(1) space?
* */
class ListNode234{
    int val;
    ListNode234 next;
    ListNode234(int val, ListNode234 next){
        this.val =  val;
        this.next = next;
    }
}

class PalindromeLinkedList{
    public boolean isPalindrome(ListNode234 head){
        if (head == null && head.next == null){
            return true;
        }
        ListNode234 middle = findMiddle(head);
        ListNode234 secondHalf = reverse(middle.next);

        ListNode234 firstHalf = head;
        while(secondHalf != null){
            if (firstHalf.val != secondHalf.val){
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    private ListNode234 reverse(ListNode234 middle) {
        ListNode234 prev = null;
        ListNode234 curr = middle;
        while (curr != null){
            ListNode234 next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode234 findMiddle(ListNode234 head) {
        ListNode234 here = head;
        ListNode234 turtle = head;
        while (here.next != null && here.next.next != null){
            here = here.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

}

public class LeetCode234 {
    public static void main(String[] args) {
        // Test case 1
        ListNode234 node4 = new ListNode234(1, null);
        ListNode234 node3 = new ListNode234(2, node4);
        ListNode234 node2 = new ListNode234(2, node3);
        ListNode234 node1 = new ListNode234(1, node2);
        PalindromeLinkedList pll = new PalindromeLinkedList();
        System.out.println(pll.isPalindrome(node1)); // Output: true

        // Test case 2
        ListNode234 node6 = new ListNode234(2, null);
        ListNode234 node5 = new ListNode234(1, node6);
        System.out.println(pll.isPalindrome(node5)); // Output: false
    }
}
