package MayMonth;

import java.util.*;

/**
 * 3068. Find the Maximum Sum of Node Values
 * There exists an undirected tree with n nodes numbered 0 to n - 1. You are given a 0-indexed 2D integer array edges of length n - 1, where edges[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the tree. You are also given a positive integer k, and a 0-indexed array of non-negative integers nums of length n, where nums[i] represents the value of the node numbered i.
 *
 * Alice wants the sum of values of tree nodes to be maximum, for which Alice can perform the following operation any number of times (including zero) on the tree:
 *
 * Choose any edge [u, v] connecting the nodes u and v, and update their values as follows:
 * nums[u] = nums[u] XOR k
 * nums[v] = nums[v] XOR k
 * Return the maximum possible sum of the values Alice can achieve by performing the operation any number of times.
 * Example 1:
 * Input: nums = [1,2,1], k = 3, edges = [[0,1],[0,2]]
 * Output: 6
 * Explanation: Alice can achieve the maximum sum of 6 using a single operation:
 * - Choose the edge [0,2]. nums[0] and nums[2] become: 1 XOR 3 = 2, and the array nums becomes: [1,2,1] -> [2,2,2].
 * The total sum of values is 2 + 2 + 2 = 6.
 * It can be shown that 6 is the maximum achievable sum of values.
 * Example 2:
 * Input: nums = [2,3], k = 7, edges = [[0,1]]
 * Output: 9
 * Explanation: Alice can achieve the maximum sum of 9 using a single operation:
 * - Choose the edge [0,1]. nums[0] becomes: 2 XOR 7 = 5 and nums[1] become: 3 XOR 7 = 4, and the array nums becomes: [2,3] -> [5,4].
 * The total sum of values is 5 + 4 = 9.
 * It can be shown that 9 is the maximum achievable sum of values.
 * Example 3:
 * Input: nums = [7,7,7,7,7,7], k = 3, edges = [[0,1],[0,2],[0,3],[0,4],[0,5]]
 * Output: 42
 * Explanation: The maximum achievable sum is 42 which can be achieved by Alice performing no operations.
 * Constraints:
 * 2 <= n == nums.length <= 2 * 104
 * 1 <= k <= 109
 * 0 <= nums[i] <= 109
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= edges[i][0], edges[i][1] <= n - 1
 * The input is generated such that edges represent a valid tree.
 */
class MaxSumOfNode {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {

        int n = nums.length;
        Integer [] diff = new Integer[n];
        long sum = 0;
        for(int i = 0;i<n;i++){
            diff[i] = (nums[i]^k)-nums[i];
            sum+=nums[i];
        }

        Arrays.sort(diff, Collections.reverseOrder());

        for(int i = 0;i<n;i+=2){
            if(i+1 == n) return sum;
            int pair = diff[i]+diff[i+1];
            if(pair>0)sum+=pair;
        }
        return sum;
    }
}
public class Day19 {
    public static void main(String[] args) {
        // Example test case 1
        int[] nums1 = {1, 2, 1};
        int k1 = 3;
        int[][] edges1 = {{0, 1}, {0, 2}};
        MaxSumOfNode solution1 = new MaxSumOfNode();
        long result1 = solution1.maximumValueSum(nums1, k1, edges1);
        System.out.println("Test case 1 result: " + result1); // Expected output: 6

        // Example test case 2
        int[] nums2 = {2, 3};
        int k2 = 7;
        int[][] edges2 = {{0, 1}};
        MaxSumOfNode solution2 = new MaxSumOfNode();
        long result2 = solution2.maximumValueSum(nums2, k2, edges2);
        System.out.println("Test case 2 result: " + result2); // Expected output: 9

        int[] nums4 = {24, 78, 1, 97, 44};
        int k4 = 6;
        int[][] edges4 = {{0, 2}, {1, 2}, {4, 2}, {3, 4}};
        MaxSumOfNode solution4 = new MaxSumOfNode();
        long result4 = solution4.maximumValueSum(nums4, k4, edges4);
        System.out.println("Test case 4 result: " + result4); // Expected output: 260
    }
}
