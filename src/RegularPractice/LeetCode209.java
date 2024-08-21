package RegularPractice;

/* 209. Minimum Size Subarray Sum
* Given an array of positive integers nums and a positive integer target, return the minimal length of a
subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

Constraints:
1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104
Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
* */

class MinSizeSubArrSum{
    public int minSubArrayLen( int target, int [] nums){
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for (int right = 0; right < n; right++){
            sum +=nums[right];

            while (sum >= target){
                minLength = Math.min(minLength, right-left+1);
                sum -=nums[left];
                left++;
            }
        }
        if (minLength == Integer.MAX_VALUE){
            return 0;
        }
        return minLength;
    }
}
public class LeetCode209 {
    public static void main(String[] args) {
        // Create an instance of the MinSizeSubArrSum class
        MinSizeSubArrSum solution = new MinSizeSubArrSum();

        // Test case 1
        int target1 = 7;
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        System.out.println("Test Case 1: " + solution.minSubArrayLen(target1, nums1)); // Expected output: 2

        // Test case 2
        int target2 = 4;
        int[] nums2 = {1, 4, 4};
        System.out.println("Test Case 2: " + solution.minSubArrayLen(target2, nums2)); // Expected output: 1

        // Test case 3
        int target3 = 11;
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("Test Case 3: " + solution.minSubArrayLen(target3, nums3)); // Expected output: 0

        // Additional test cases
        int target4 = 15;
        int[] nums4 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 4: " + solution.minSubArrayLen(target4, nums4)); // Expected output: 5

        int target5 = 100;
        int[] nums5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Test Case 5: " + solution.minSubArrayLen(target5, nums5)); // Expected output: 0
    }
}
