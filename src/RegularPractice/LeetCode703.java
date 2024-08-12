package RegularPractice;

/*703. Kth Largest Element in a Stream

* Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.


Example 1:

Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8


Constraints:

1 <= k <= 104
0 <= nums.length <= 104
-104 <= nums[i] <= 104
-104 <= val <= 104
At most 104 calls will be made to add.
It is guaranteed that there will be at least k elements in the array when you search for the kth element.

* */


import java.util.*;

class KthLargest {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int K;
    public KthLargest(int k, int[] nums) {
        K = k;
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > K) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > K) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
public class LeetCode703 {
    public static void main(String[] args) {
        // Initialize the KthLargest object with k = 3 and an initial array [4, 5, 8, 2]
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});

        // Test the add method and print the kth largest element after each addition
        System.out.println(kthLargest.add(3)); // Expected output: 4
        System.out.println(kthLargest.add(5)); // Expected output: 5
        System.out.println(kthLargest.add(10)); // Expected output: 5
        System.out.println(kthLargest.add(9)); // Expected output: 8
        System.out.println(kthLargest.add(4)); // Expected output: 8
    }
}
