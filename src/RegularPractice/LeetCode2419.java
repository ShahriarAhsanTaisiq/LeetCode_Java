package RegularPractice;
/* 2419. Longest Subarray With Maximum Bitwise AND
* You are given an integer array nums of size n.
Consider a non-empty subarray from nums that has the maximum possible bitwise AND.
In other words, let k be the maximum value of the bitwise AND of any subarray of nums. Then, only subarrays with a bitwise AND equal to k should be considered.
Return the length of the longest such subarray.
The bitwise AND of an array is the bitwise AND of all the numbers in it.
A subarray is a contiguous sequence of elements within an array.
Example 1:
Input: nums = [1,2,3,3,2,2]
Output: 2
Explanation:
The maximum possible bitwise AND of a subarray is 3.
The longest subarray with that value is [3,3], so we return 2.
Example 2:
Input: nums = [1,2,3,4]
Output: 1
Explanation:
The maximum possible bitwise AND of a subarray is 4.
The longest subarray with that value is [4], so we return 1.
Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 106
* */
class LongestSubarrayMaxBitwiseAnd{
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = 0;
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if (max == nums[i]) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount, count);
        if (max == 0) {
            return 1;
        }
        return maxCount;
    }
}
public class LeetCode2419 {
    public static void main(String[] args) {
        LongestSubarrayMaxBitwiseAnd solution = new LongestSubarrayMaxBitwiseAnd();

        // Test case 1
        int[] nums1 = {1, 2, 3, 3, 2, 2};
        System.out.println("Test case 1: " + solution.longestSubarray(nums1)); // Expected output: 2

        // Test case 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Test case 2: " + solution.longestSubarray(nums2)); // Expected output: 1

        // Test case 3
        int[] nums3 = {4, 4, 4, 4, 4};
        System.out.println("Test case 3: " + solution.longestSubarray(nums3)); // Expected output: 5

        // Test case 4
        int[] nums4 = {5, 5, 1, 5, 5, 5, 5};
        System.out.println("Test case 4: " + solution.longestSubarray(nums4)); // Expected output: 4

        // Test case 5: Single element array
        int[] nums5 = {7};
        System.out.println("Test case 5: " + solution.longestSubarray(nums5)); // Expected output: 1

        // Test case 6: Large array with alternating values
        int[] nums6 = {8, 6, 8, 6, 8, 6, 8, 8, 8, 6};
        System.out.println("Test case 6: " + solution.longestSubarray(nums6)); // Expected output: 3
    }
}
