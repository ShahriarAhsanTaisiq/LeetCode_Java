package RegularPractice;

/*1508. Range Sum of Sorted Subarray Sums
* You are given the array nums consisting of n positive integers. You computed the sum of all non-empty continuous subarrays from the array and then sorted them in non-decreasing order, creating a new array of n * (n + 1) / 2 numbers.
Return the sum of the numbers from index left to index right (indexed from 1), inclusive, in the new array. Since the answer can be a huge number return it modulo 109 + 7.
Example 1:

Input: nums = [1,2,3,4], n = 4, left = 1, right = 5
Output: 13
Explanation: All subarray sums are 1, 3, 6, 10, 2, 5, 9, 3, 7, 4. After sorting them in non-decreasing order we have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10]. The sum of the numbers from index le = 1 to ri = 5 is 1 + 2 + 3 + 3 + 4 = 13.
Example 2:

Input: nums = [1,2,3,4], n = 4, left = 3, right = 4
Output: 6
Explanation: The given array is the same as example 1. We have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10]. The sum of the numbers from index le = 3 to ri = 4 is 3 + 3 = 6.
Example 3:

Input: nums = [1,2,3,4], n = 4, left = 1, right = 10
Output: 50

Constraints:
n == nums.length
1 <= nums.length <= 1000
1 <= nums[i] <= 100
1 <= left <= right <= n * (n + 1) / 2
* */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class RangeSum{
    public int rangeSum(int [] nums, int n, int left, int right){
        List<Integer> arr = new ArrayList<>();

        //Continuous prefix sum
        for (int i = 0; i < n; i++){
            int prefix = 0;
            for (int j = i; j < n; j++){
                prefix += nums[j];
                arr.add(prefix);
            }
        }
        Collections.sort(arr);
        int result = 0;
        int mod = 1000000007;
        for (int i = left - 1; i < right; i++){
            result = (result+arr.get(i)) % mod;
        }
        return  result;
    }
}
public class LeetCode1508 {
    public static void main(String[] args) {
        RangeSum rangeSumCalculator = new RangeSum();

        // Test case 1
        int[] nums1 = {1, 2, 3, 4};
        int n1 = 4;
        int left1 = 1;
        int right1 = 5;
        System.out.println("Output for test case 1: " + rangeSumCalculator.rangeSum(nums1, n1, left1, right1)); // Expected: 13

        // Test case 2
        int[] nums2 = {1, 2, 3, 4};
        int n2 = 4;
        int left2 = 3;
        int right2 = 4;
        System.out.println("Output for test case 2: " + rangeSumCalculator.rangeSum(nums2, n2, left2, right2)); // Expected: 6

        // Test case 3
        int[] nums3 = {1, 2, 3, 4};
        int n3 = 4;
        int left3 = 1;
        int right3 = 10;
        System.out.println("Output for test case 3: " + rangeSumCalculator.rangeSum(nums3, n3, left3, right3)); // Expected: 50

    }

}
