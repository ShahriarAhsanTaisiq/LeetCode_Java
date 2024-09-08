package RegularPractice;
/*725. Split Linked List in Parts
* Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.
The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.
The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.
Return an array of the k parts.
Example 1:
Input: head = [1,2,3], k = 5
Output: [[1],[2],[3],[],[]]
Explanation:
The first element output[0] has output[0].val = 1, output[0].next = null.
The last element output[4] is null, but its string representation as a ListNode is [].
Example 2:
Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
Output: [[1,2,3,4],[5,6,7],[8,9,10]]
Explanation:
The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
Constraints:
The number of nodes in the list is in the range [0, 1000].
0 <= Node.val <= 1000
1 <= k <= 50
* */
class ListNode725{
    int val;
    ListNode725 next;
    ListNode725(int val){
        this.val = val;
        next = null;
    }
}
class SplitLinkedList{
    public ListNode725[] splitListToParts(ListNode725 head, int k) {
        ListNode725 [] res = new ListNode725[k];
        int n = 0;
        ListNode725 curr = head;
        while (curr != null) {
            n += 1;
            curr = curr.next;
        }
        int size = n / k;
        int rem = n % k;
        curr = head;
        ListNode725 prev = head;
        for (int i = 0 ; i < k ; i++) {
            ListNode725 part = curr;
            int partSize = size;
            if (rem > 0) {
                rem -= 1;
                partSize += 1;
            }
            for (int j = 0 ; j < partSize ; j++) {
                prev = curr;
                curr = curr.next;
            }
            if (prev != null) prev.next = null;
            res[i] = part;
        }
        return res;

    }
}
public class LeetCode725 {
    public static void main(String[] args) {
        // Test Case 1: head = [1, 2, 3], k = 5
        ListNode725 head1 = new ListNode725(1);
        head1.next = new ListNode725(2);
        head1.next.next = new ListNode725(3);
        int k1 = 5;
        SplitLinkedList solution1 = new SplitLinkedList();
        ListNode725[] result1 = solution1.splitListToParts(head1, k1);
        System.out.println("Test Case 1:");
        printResult(result1);

        // Test Case 2: head = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
        ListNode725 head2 = new ListNode725(1);
        ListNode725 curr = head2;
        for (int i = 2; i <= 10; i++) {
            curr.next = new ListNode725(i);
            curr = curr.next;
        }
        int k2 = 3;
        SplitLinkedList solution2 = new SplitLinkedList();
        ListNode725[] result2 = solution2.splitListToParts(head2, k2);
        System.out.println("Test Case 2:");
        printResult(result2);
    }

    // Helper method to print the linked list parts
    public static void printResult(ListNode725[] result) {
        for (int i = 0; i < result.length; i++) {
            ListNode725 part = result[i];
            System.out.print("[");
            while (part != null) {
                System.out.print(part.val);
                part = part.next;
                if (part != null) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
