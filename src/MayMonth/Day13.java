package MayMonth;
/*861. Score After Flipping Matrix
* You are given an m x n binary matrix grid.
A move consists of choosing any row or column and toggling each value in that row or column (i.e., changing all 0's to 1's, and all 1's to 0's).
Every row of the matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.
Return the highest possible score after making any number of moves (including zero moves).
Example 1:
Input: grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
Output: 39
Explanation: 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
Example 2:

Input: grid = [[0]]
Output: 1
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 20
grid[i][j] is either 0 or 1.
*
* */
class FlippingMatrixScore {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int score = m * (1 << (n - 1)); // Initialize score with the maximum possible score for the first column

        // Step 1: Calculate the contribution of each column to the final score
        for (int j = 1; j < n; j++) {
            int countOnes = 0;
            for (int i = 0; i < m; i++) {
                countOnes += grid[i][j] ^ grid[i][0]; // If grid[i][j] != grid[i][0], then toggling this cell will increase the score
            }
            int colScore = Math.max(countOnes, m - countOnes) * (1 << (n - 1 - j)); // Contribution of this column to the score
            score += colScore;
        }

        return score;
    }
}

public class Day13 {
    public static void main(String[] args) {
        FlippingMatrixScore solution = new FlippingMatrixScore();

        // Example 1
        int[][] grid1 = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        System.out.println("Example 1 Output: " + solution.matrixScore(grid1)); // Output: 39

        // Example 2
        int[][] grid2 = {{0}};
        System.out.println("Example 2 Output: " + solution.matrixScore(grid2)); // Output: 1

        // Custom test case
        int[][] grid3 = {{1, 1, 0}, {0, 1, 1}, {0, 0, 1}};
        System.out.println("Custom Test Output: " + solution.matrixScore(grid3)); // Output: 22
    }
}
