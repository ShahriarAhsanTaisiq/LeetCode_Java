package RegularPractice;

/* 2563. Count the Number of Fair Pairs
* Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.
A pair (i, j) is fair if:
0 <= i < j < n, and
lower <= nums[i] + nums[j] <= upper
Example 1:
Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
Output: 6
Explanation: There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).
Example 2:
Input: nums = [1,7,9,2,5], lower = 11, upper = 11
Output: 1
Explanation: There is a single fair pair: (2,3).
Constraints:
1 <= nums.length <= 105
nums.length == n
-109 <= nums[i] <= 109
-109 <= lower <= upper <= 109
* */

import java.util.Arrays;

class CountNumOfFairPairs{
    public long countFairPairs(int [] nums, int lower, int upper) {
        Arrays.sort(nums);
        return getPairs(nums, upper+1) - getPairs(nums, lower);
    }

    private long getPairs(int[] nums, int val) {
        int left = 0, right = nums.length-1;
        long result = 0;
        while (left <= right) {
            if (nums[left]+nums[right] < val) {
                result += right - left;
                left++;
            } else{
                right--;
            }
        }
        return result;
    }
}
public class LeetCode2563 {
    public static void main(String[] args) {
        CountNumOfFairPairs c = new CountNumOfFairPairs();
        // Test case 1
        int[] nums1 = {0, 1, 7, 4, 4, 5};
        int lower1 = 3;
        int upper1 = 6;
        System.out.println("Output for test case 1: " + c.countFairPairs(nums1, lower1, upper1)); // Expected output: 6

        // Test case 2
        int[] nums2 = {1, 7, 9, 2, 5};
        int lower2 = 11;
        int upper2 = 11;
        System.out.println("Output for test case 2: " + c.countFairPairs(nums2, lower2, upper2)); // Expected output: 1

        // Additional test case 3
        int[] nums3 = {-5, -3, 0, 2, 4, 6};
        int lower3 = -2;
        int upper3 = 3;
        System.out.println("Output for test case 3: " + c.countFairPairs(nums3, lower3, upper3)); // Expected output depends on the setup

        // Additional test case 4 - edge case with smallest input
        int[] nums4 = {1};
        int lower4 = 0;
        int upper4 = 2;
        System.out.println("Output for test case 4: " + c.countFairPairs(nums4, lower4, upper4)); // Expected output: 0
    }
}
