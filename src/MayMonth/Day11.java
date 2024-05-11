package MayMonth;

import java.util.*;

/*857. Minimum Cost to Hire K Workers
* There are n workers. You are given two integer arrays quality and wage where quality[i] is the quality of the ith worker and wage[i] is the minimum wage expectation for the ith worker.

We want to hire exactly k workers to form a paid group. To hire a group of k workers, we must pay them according to the following rules:

Every worker in the paid group must be paid at least their minimum wage expectation.
In the group, each worker's pay must be directly proportional to their quality. This means if a worker’s quality is double that of another worker in the group, then they must be paid twice as much as the other worker.
Given the integer k, return the least amount of money needed to form a paid group satisfying the above conditions. Answers within 10-5 of the actual answer will be accepted.
Example 1:
Input: quality = [10,20,5], wage = [70,50,30], k = 2
Output: 105.00000
Explanation: We pay 70 to 0th worker and 35 to 2nd worker.
Example 2:
Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
Output: 30.66667
Explanation: We pay 4 to 0th worker, 13.33333 to 2nd and 3rd workers separately.
Constraints:
n == quality.length == wage.length
1 <= k <= n <= 104
1 <= quality[i], wage[i] <= 104
* */
class MinCostToHire {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) wage[i] / quality[i];
            workers[i][1] = quality[i];
        }

        Arrays.sort(workers, Comparator.comparingDouble(a -> a[0]));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double minCost = Double.POSITIVE_INFINITY;
        double sumQuality = 0;

        for (double[] worker : workers) {
            sumQuality += worker[1];
            maxHeap.offer((int) worker[1]);

            if (maxHeap.size() > k) {
                sumQuality -= maxHeap.poll();
            }

            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, sumQuality * worker[0]);
            }
        }

        return minCost;
    }
}
public class Day11 {
    public static void main(String[] args) {
        MinCostToHire solution = new MinCostToHire();

        // Example 1
        int[] quality1 = {10, 20, 5};
        int[] wage1 = {70, 50, 30};
        int k1 = 2;
        double result1 = solution.mincostToHireWorkers(quality1, wage1, k1);
        System.out.println("Example 1: " + result1);  // Expected output: 105.0

        // Example 2
        int[] quality2 = {3, 1, 10, 10, 1};
        int[] wage2 = {4, 8, 2, 2, 7};
        int k2 = 3;
        double result2 = solution.mincostToHireWorkers(quality2, wage2, k2);
        System.out.println("Example 2: " + result2);  // Expected output: 30.666666666666668
    }
}
