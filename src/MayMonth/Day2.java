package MayMonth;

import java.util.*;

/* 2441. Largest Positive Integer That Exists With Its Negative
* Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.

Return the positive integer k. If there is no such integer, return -1.
Example 1:
Input: nums = [-1,2,-3,3]
Output: 3
Explanation: 3 is the only valid k we can find in the array.
Example 2:
Input: nums = [-1,10,6,7,-7,1]
Output: 7
Explanation: Both 1 and 7 have their corresponding negative values in the array. 7 has a larger value.
Example 3:

Input: nums = [-10,8,6,7,-2,-3]
Output: -1
Explanation: There is no a single valid k, we return -1.
Constraints:
1 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
nums[i] != 0
* */
class LargestPositive {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxNum=-1;
        for(int num:nums){
            if(set.contains(-num)){
                maxNum=Math.max(maxNum,Math.abs(num));
            }
            set.add(num);
        }
        return maxNum;
    }
}
public class Day2 {
    public static void main(String[] args) {
        LargestPositive solution = new LargestPositive();

        // Test cases
        int[] nums1 = {-1, 2, -3, 3};
        int[] nums2 = {-1, 10, 6, 7, -7, 1};
        int[] nums3 = {-10, 8, 6, 7, -2, -3};

        System.out.println("Output for nums1: " + solution.findMaxK(nums1)); // Output: 3
        System.out.println("Output for nums2: " + solution.findMaxK(nums2)); // Output: 7
        System.out.println("Output for nums3: " + solution.findMaxK(nums3)); // Output: -1
    }
}
