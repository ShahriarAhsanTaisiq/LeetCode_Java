package RegularPractice;
/*2461. Maximum Sum of Distinct Subarrays With Length K
* You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
Example 2:

Input: nums = [4,4,4], k = 3
Output: 0
Explanation: The subarrays of nums with length 3 are:
- [4,4,4] which does not meet the requirements because the element 4 is repeated.
We return 0 because no subarrays meet the conditions.

Constraints:

1 <= k <= nums.length <= 105
1 <= nums[i] <= 105
* */

import java.util.HashSet;

class MaximumSubArraySum{
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        long sum = 0, maxSum = 0;

        while( j < nums.length){
            if (!set.contains(nums[j])){
                set.add(nums[j]);
                sum += nums[j];

                if (j - i + 1 == k){
                    maxSum = Math.max(maxSum, sum);
                    sum -= nums[i];
                    set.remove(nums[i]);
                    i++;
                }
            } else {
                while (set.contains(nums[j])){
                    sum -= nums[i];
                    set.remove(nums[i]);
                    i++;
                }
                set.add(nums[j]);
                sum += nums[j];
            }
            j++;
        }
        return maxSum;
    }
}
public class LeetCode2461 {
    public static void main(String[] args) {
        MaximumSubArraySum maximumSubArraySum = new MaximumSubArraySum();

        System.out.println(maximumSubArraySum.maximumSubarraySum(new int[]{1,5,4,2,9,9,9}, 3));
        System.out.println(maximumSubArraySum.maximumSubarraySum(new int[]{4,4,4}, 3));
    }
}
