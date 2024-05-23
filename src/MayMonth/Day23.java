package MayMonth;

import java.util.*;

/*2597. The Number of Beautiful Subsets
* You are given an array nums of positive integers and a positive integer k.

A subset of nums is beautiful if it does not contain two integers with an absolute difference equal to k.

Return the number of non-empty beautiful subsets of the array nums.

A subset of nums is an array that can be obtained by deleting some (possibly none) elements from nums. Two subsets are different if and only if the chosen indices to delete are different.
Example 1:
Input: nums = [2,4,6], k = 2
Output: 4
Explanation: The beautiful subsets of the array nums are: [2], [4], [6], [2, 6].
It can be proved that there are only 4 beautiful subsets in the array [2,4,6].
Example 2:
Input: nums = [1], k = 1
Output: 1
Explanation: The beautiful subset of the array nums is [1].
It can be proved that there is only 1 beautiful subset in the array [1].
Constraints:
1 <= nums.length <= 20
1 <= nums[i], k <= 1000
* */
class BeautifulSubset {
    private int dfs(int[] nums, int k, int i, Set<Integer> set) {
        if (i == nums.length)
            return set.isEmpty() ? 0 : 1;

        var cnt = dfs(nums, k, i+1, set);

        if (set.contains(nums[i] - k)) return cnt;

        set.add(nums[i]);
        cnt += dfs(nums, k, i+1 ,set);
        set.remove(nums[i]);

        return cnt;
    }

    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);

        return dfs(nums, k, 0, new HashSet<Integer>());
    }
}
public class Day23 {
    public static void main(String[] args) {
        BeautifulSubset solution = new BeautifulSubset();

        int[] nums1 = {2, 4, 6};
        int k1 = 2;
        System.out.println("Test Case 1: " + solution.beautifulSubsets(nums1, k1));  // Expected output: 4

        int[] nums2 = {1};
        int k2 = 1;
        System.out.println("Test Case 2: " + solution.beautifulSubsets(nums2, k2));  // Expected output: 1

        // Additional test cases
        int[] nums3 = {1, 3, 5, 7};
        int k3 = 2;
        System.out.println("Test Case 3: " + solution.beautifulSubsets(nums3, k3));  // Expected output: 15

        int[] nums4 = {1, 2, 3, 4, 5};
        int k4 = 1;
        System.out.println("Test Case 4: " + solution.beautifulSubsets(nums4, k4));  // Expected output: 26
    }

}
