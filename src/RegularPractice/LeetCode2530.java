package RegularPractice;

/* 2530. Maximal Score After Applying K Operations
* You are given a 0-indexed integer array nums and an integer k. You have a starting score of 0.
In one operation:
choose an index i such that 0 <= i < nums.length,
increase your score by nums[i], and
replace nums[i] with ceil(nums[i] / 3).
Return the maximum possible score you can attain after applying exactly k operations.

The ceiling function ceil(val) is the least integer greater than or equal to val.

Example 1:

Input: nums = [10,10,10,10,10], k = 5
Output: 50
Explanation: Apply the operation to each array element exactly once. The final score is 10 + 10 + 10 + 10 + 10 = 50.
Example 2:

Input: nums = [1,10,3,3,3], k = 3
Output: 17
Explanation: You can do the following operations:
Operation 1: Select i = 1, so nums becomes [1,4,3,3,3]. Your score increases by 10.
Operation 2: Select i = 1, so nums becomes [1,2,3,3,3]. Your score increases by 4.
Operation 3: Select i = 2, so nums becomes [1,1,1,3,3]. Your score increases by 3.
The final score is 10 + 4 + 3 = 17.

Constraints:
1 <= nums.length, k <= 105
1 <= nums[i] <= 109
* */

import java.util.PriorityQueue;

class MaxScoreAfterKOperation{
    public long maxKElements( int [] nums, int k){
        long ans = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for(int num : nums){
            maxHeap.add(num);
        }

        for (int i = 0; i < k; i++){
            int largest = maxHeap.poll();
            ans += largest;
            int value = (largest+2) / 3;
            maxHeap.offer(value);
        }
        return ans;
    }
}
public class LeetCode2530 {
    public static void main(String[] args) {
        // Create an instance of the class
        MaxScoreAfterKOperation solver = new MaxScoreAfterKOperation();

        // Test Case 1
        int[] nums1 = {10, 10, 10, 10, 10};
        int k1 = 5;
        long result1 = solver.maxKElements(nums1, k1);
        System.out.println("Test Case 1: Expected Output = 50, Actual Output = " + result1);

        // Test Case 2
        int[] nums2 = {1, 10, 3, 3, 3};
        int k2 = 3;
        long result2 = solver.maxKElements(nums2, k2);
        System.out.println("Test Case 2: Expected Output = 17, Actual Output = " + result2);

        // Test Case 3 (Large numbers)
        int[] nums3 = {672579538, 806947365, 854095676, 815137524};
        int k3 = 3;
        long result3 = solver.maxKElements(nums3, k3);
        System.out.println("Test Case 3: Expected Output = 2476180565, Actual Output = " + result3);
    }
}
