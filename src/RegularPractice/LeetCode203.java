package RegularPractice;
/* 203. Remove Linked List Elements
* Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
Example 1:
Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
Example 2:
Input: head = [], val = 1
Output: []
Example 3:
Input: head = [7,7,7,7], val = 7
Output: []
Constraints:
The number of nodes in the list is in the range [0, 104].
1 <= Node.val <= 50
0 <= val <= 50
* */


class Node203{
    int val;
    Node203 next;
    Node203(int val){
        this.val = val;
        next = null;
    }
}

class RemoveLLElements{
    public Node203 removeElements( Node203 head, int val){
        if (head == null)
            return head;
        head.next = removeElements(head.next, val);
        if (head.val == val){
            return head.next;
        }
        return head;
    }
}
public class LeetCode203 {
    public static Node203 createLinkedList(int[] values) {
        if (values.length == 0) return null;
        Node203 head = new Node203(values[0]);
        Node203 current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new Node203(values[i]);
            current = current.next;
        }
        return head;
    }

    // Helper function to print the linked list
    public static void printLinkedList(Node203 head) {
        Node203 current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveLLElements remover = new RemoveLLElements();

        // Example 1: [1,2,6,3,4,5,6], val = 6
        int[] values1 = {1, 2, 6, 3, 4, 5, 6};
        Node203 head1 = createLinkedList(values1);
        System.out.print("Original List 1: ");
        printLinkedList(head1);
        Node203 result1 = remover.removeElements(head1, 6);
        System.out.print("Modified List 1: ");
        printLinkedList(result1);

        // Example 2: [], val = 1
        int[] values2 = {};
        Node203 head2 = createLinkedList(values2);
        System.out.print("Original List 2: ");
        printLinkedList(head2);
        Node203 result2 = remover.removeElements(head2, 1);
        System.out.print("Modified List 2: ");
        printLinkedList(result2);

        // Example 3: [7,7,7,7], val = 7
        int[] values3 = {7, 7, 7, 7};
        Node203 head3 = createLinkedList(values3);
        System.out.print("Original List 3: ");
        printLinkedList(head3);
        Node203 result3 = remover.removeElements(head3, 7);
        System.out.print("Modified List 3: ");
        printLinkedList(result3);
    }
}
