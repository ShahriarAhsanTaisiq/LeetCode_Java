package MayMonth;
/*260. Single Number III
* Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
Example 1:
Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.
Example 2:
Input: nums = [-1,0]
Output: [-1,0]
Example 3:

Input: nums = [0,1]
Output: [1,0]
Constraints:
2 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each integer in nums will appear twice, only two integers will appear once.
* */

class SingleNum3 {
    public int[] singleNumber(int[] nums) {
        // Step 1: XOR of all the elements
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: Find a differentiating bit
        int diffBit = xor & (-xor);

        // Step 3: Divide elements into two groups and XOR within each group
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & diffBit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        // Step 4: Return the result
        return new int[]{a, b};
    }
}

public class Day31 {
    public static void main(String[] args) {
        SingleNum3 solution = new SingleNum3();

        // Test Case 1
        int[] nums1 = {1, 2, 1, 3, 2, 5};
        int[] result1 = solution.singleNumber(nums1);
        System.out.println("Test Case 1: " + result1[0] + ", " + result1[1]);

        // Test Case 2
        int[] nums2 = {-1, 0};
        int[] result2 = solution.singleNumber(nums2);
        System.out.println("Test Case 2: " + result2[0] + ", " + result2[1]);

        // Test Case 3
        int[] nums3 = {0, 1};
        int[] result3 = solution.singleNumber(nums3);
        System.out.println("Test Case 3: " + result3[0] + ", " + result3[1]);

    }
}
