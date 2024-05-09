package MayMonth;
/* 3075. Maximize Happiness of Selected Children
* You are given an array happiness of length n, and a positive integer k.
There are n children standing in a queue, where the ith child has happiness value happiness[i]. You want to select k children from these n children in k turns.
In each turn, when you select a child, the happiness value of all the children that have not been selected till now decreases by 1. Note that the happiness value cannot become negative and gets decremented only if it is positive.
Return the maximum sum of the happiness values of the selected children you can achieve by selecting k children.
Example 1:
Input: happiness = [1,2,3], k = 2
Output: 4
Explanation: We can pick 2 children in the following way:
- Pick the child with the happiness value == 3. The happiness value of the remaining children becomes [0,1].
- Pick the child with the happiness value == 1. The happiness value of the remaining child becomes [0]. Note that the happiness value cannot become less than 0.
The sum of the happiness values of the selected children is 3 + 1 = 4.
Example 2:
Input: happiness = [1,1,1,1], k = 2
Output: 1
Explanation: We can pick 2 children in the following way:
- Pick any child with the happiness value == 1. The happiness value of the remaining children becomes [0,0,0].
- Pick the child with the happiness value == 0. The happiness value of the remaining child becomes [0,0].
The sum of the happiness values of the selected children is 1 + 0 = 1.
Example 3:
Input: happiness = [2,3,4,5], k = 1
Output: 5
Explanation: We can pick 1 child in the following way:
- Pick the child with the happiness value == 5. The happiness value of the remaining children becomes [1,2,3].
The sum of the happiness values of the selected children is 5.
Constraints:
1 <= n == happiness.length <= 2 * 105
1 <= happiness[i] <= 108
1 <= k <= n
* */

import java.util.Arrays;

class MaximizeHappiness {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long res = 0;
        int n = happiness.length, j = 0;

        for (int i = n - 1; i >= n - k; --i) {
            happiness[i] = Math.max(happiness[i] - j++, 0);
            res += happiness[i];
        }

        return res;
    }
}
public class Day9 {
    public static void main(String[] args) {
        MaximizeHappiness solution = new MaximizeHappiness();

        // Test cases
        int[] happiness1 = {1, 2, 3};
        int k1 = 2;
        System.out.println("Case 1: " + solution.maximumHappinessSum(happiness1, k1)); // Expected output: 4

        int[] happiness2 = {1, 1, 1, 1};
        int k2 = 2;
        System.out.println("Case 2: " + solution.maximumHappinessSum(happiness2, k2)); // Expected output: 1

        int[] happiness3 = {2, 3, 4, 5};
        int k3 = 1;
        System.out.println("Case 3: " + solution.maximumHappinessSum(happiness3, k3)); // Expected output: 5
    }
}
