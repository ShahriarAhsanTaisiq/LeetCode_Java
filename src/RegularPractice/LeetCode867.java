package RegularPractice;
/* 862. Shortest Subarray with Sum at Least K
* Given an integer array nums and an integer k, return the length of the shortest non-empty subarray of nums with a sum of at least k. If there is no such subarray, return -1.
A subarray is a contiguous part of an array.

Example 1:
Input: nums = [1], k = 1
Output: 1
Example 2:
Input: nums = [1,2], k = 4
Output: -1
Example 3:
Input: nums = [2,-1,2], k = 3
Output: 3

Constraints:

1 <= nums.length <= 105
-105 <= nums[i] <= 105
1 <= k <= 109
* */
class ShortestSubarraySum{
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] sum = new long[n + 1];

        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        int[] q = new int[n + 1];
        int l = 0, r = 0;
        int minLength = n + 1;

        for (int i = 0; i < sum.length; i++) {
            while (r > l && sum[i] >= sum[q[l]] + k) {
                minLength = Math.min(minLength, i - q[l++]);
            }

            while (r > l && sum[i] <= sum[q[r - 1]]) {
                r--;
            }

            q[r++] = i;
        }

        return minLength <= n ? minLength : -1;
    }
}
public class LeetCode867 {
    public static void main(String[] args) {
        ShortestSubarraySum s = new ShortestSubarraySum();
        System.out.println(s.shortestSubarray(new int[]{1,2,3,0,4}, 2));
        System.out.println(s.shortestSubarray(new int[]{2,-1,2}, 3));
        System.out.println(s.shortestSubarray(new int[]{1,2}, 4));
    }
}
