package RegularPractice;
/*21. Merge Two Sorted Lists
* You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
* */
class ListNode21{
    int val;
    ListNode21 next;
    ListNode21(int val){
        this.val = val;
    }
}
class MergeTwoSortedList{
    public ListNode21 mergeTwoLists(ListNode21 list1, ListNode21 list2){
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }

        if (list1 == null) {
            return list2;
        }

        return list1;
    }
        
}
public class LeetCode21 {
    public static void main(String[] args) {
        MergeTwoSortedList solution = new MergeTwoSortedList();

        // Test case 1
        ListNode21 list1a = new ListNode21(1);
        list1a.next = new ListNode21(2);
        list1a.next.next = new ListNode21(4);

        ListNode21 list2a = new ListNode21(1);
        list2a.next = new ListNode21(3);
        list2a.next.next = new ListNode21(4);

        ListNode21 mergedList1 = solution.mergeTwoLists(list1a, list2a);
        printList(mergedList1); // Expected output: [1, 1, 2, 3, 4, 4]

        // Test case 2
        ListNode21 list1b = null;
        ListNode21 list2b = null;

        ListNode21 mergedList2 = solution.mergeTwoLists(list1b, list2b);
        printList(mergedList2); // Expected output: []

        // Test case 3
        ListNode21 list1c = null;
        ListNode21 list2c = new ListNode21(0);

        ListNode21 mergedList3 = solution.mergeTwoLists(list1c, list2c);
        printList(mergedList3); // Expected output: [0]
    }

    // Utility method to print the linked list
    public static void printList(ListNode21 head) {
        ListNode21 current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
