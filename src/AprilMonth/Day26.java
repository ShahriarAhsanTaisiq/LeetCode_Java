package AprilMonth;
/* 1289. Minimum Falling Path Sum II
* Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.
A falling path with non-zero shifts is a choice of exactly one element from each row of grid such that no two elements chosen in adjacent rows are in the same column.
Example 1:
Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
Output: 13
Explanation:
The possible falling paths are:
[1,5,9], [1,5,7], [1,6,7], [1,6,8],
[2,4,8], [2,4,9], [2,6,7], [2,6,8],
[3,4,8], [3,4,9], [3,5,7], [3,5,9]
The falling path with the smallest sum is [1,5,7], so the answer is 13.
Example 2:
Input: grid = [[7]]
Output: 7
Constraints:
n == grid.length == grid[i].length
1 <= n <= 200
-99 <= grid[i][j] <= 99
* */
class FallingPathSum2 {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = grid[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int minPrev = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        minPrev = Math.min(minPrev, dp[i - 1][k]);
                    }
                }
                dp[i][j] = grid[i][j] + minPrev;
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[n - 1][j]);
        }

        return minSum;
    }
}
public class Day26 {
    public static void main(String[] args) {
        FallingPathSum2 solution = new FallingPathSum2();

        // Test case 1
        int[][] grid1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int result1 = solution.minFallingPathSum(grid1);
        System.out.println("Minimum falling path sum for test case 1: " + result1); // Expected output: 13

        // Test case 2
        int[][] grid2 = {{7}};
        int result2 = solution.minFallingPathSum(grid2);
        System.out.println("Minimum falling path sum for test case 2: " + result2); // Expected output: 7
    }
}
