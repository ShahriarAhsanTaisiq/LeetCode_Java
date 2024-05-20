package MayMonth;
/*1863. Sum of All Subset XOR Totals
* The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.

For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
Given an array nums, return the sum of all XOR totals for every subset of nums.

Note: Subsets with the same elements should be counted multiple times.

An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.
Example 1:
Input: nums = [1,3]
Output: 6
Explanation: The 4 subsets of [1,3] are:
- The empty subset has an XOR total of 0.
- [1] has an XOR total of 1.
- [3] has an XOR total of 3.
- [1,3] has an XOR total of 1 XOR 3 = 2.
0 + 1 + 3 + 2 = 6
Example 2:
Input: nums = [5,1,6]
Output: 28
Explanation: The 8 subsets of [5,1,6] are:
- The empty subset has an XOR total of 0.
- [5] has an XOR total of 5.
- [1] has an XOR total of 1.
- [6] has an XOR total of 6.
- [5,1] has an XOR total of 5 XOR 1 = 4.
- [5,6] has an XOR total of 5 XOR 6 = 3.
- [1,6] has an XOR total of 1 XOR 6 = 7.
- [5,1,6] has an XOR total of 5 XOR 1 XOR 6 = 2.
0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28
Example 3:
Input: nums = [3,4,5,6,7,8]
Output: 480
Explanation: The sum of all XOR totals for every subset is 480.
Constraints:
1 <= nums.length <= 12
1 <= nums[i] <= 20
*
* */
class SumOfXORSubset {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        // There are 2^n possible subsets
        int numOfSubsets = 1 << n; // 2^n

        // Iterate over all possible subsets
        for (int i = 0; i < numOfSubsets; i++) {
            int currentXOR = 0;
            for (int j = 0; j < n; j++) {
                // Check if the j-th element is in the i-th subset
                if ((i & (1 << j)) != 0) {
                    currentXOR ^= nums[j];
                }
            }
            // Add the XOR of the current subset to the total sum
            totalSum += currentXOR;
        }

        return totalSum;
    }
}

public class Day20 {
    public static void main(String[] args) {
        SumOfXORSubset solution = new SumOfXORSubset();

        // Test case 1
        int[] nums1 = {1, 3};
        System.out.println("Test case 1: Input: [1, 3] - Expected: 6 - Output: " + solution.subsetXORSum(nums1));

        // Test case 2
        int[] nums2 = {5, 1, 6};
        System.out.println("Test case 2: Input: [5, 1, 6] - Expected: 28 - Output: " + solution.subsetXORSum(nums2));

        // Test case 3
        int[] nums3 = {3, 4, 5, 6, 7, 8};
        System.out.println("Test case 3: Input: [3, 4, 5, 6, 7, 8] - Expected: 480 - Output: " + solution.subsetXORSum(nums3));

    }
}
