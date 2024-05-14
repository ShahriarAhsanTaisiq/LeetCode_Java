package MayMonth;
/**1219. Path with Maximum Gold
 * In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.
 *
 * Return the maximum amount of gold you can collect under the conditions:
 *
 * Every time you are located in a cell you will collect all the gold in that cell.
 * From your position, you can walk one step to the left, right, up, or down.
 * You can't visit the same cell more than once.
 * Never visit a cell with 0 gold.
 * You can start and stop collecting gold from any position in the grid that has some gold.
 * Example 1:
 * Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
 * Output: 24
 * Explanation:
 * [[0,6,0],
 *  [5,8,7],
 *  [0,9,0]]
 * Path to get the maximum gold, 9 -> 8 -> 7.
 * Example 2:
 * Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
 * Output: 28
 * Explanation:
 * [[1,0,7],
 *  [2,0,6],
 *  [3,4,5],
 *  [0,3,0],
 *  [9,0,20]]
 * Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 15
 * 0 <= grid[i][j] <= 100
 * There are at most 25 cells containing gold.
 * */
class MaximumGold {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int maxGold = 0;

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }

        return maxGold;
    }

    private void dfs(int[][] grid, int x, int y, int currentGold) {
        currentGold += grid[x][y];
        maxGold = Math.max(maxGold, currentGold);

        int originalGold = grid[x][y];
        grid[x][y] = 0;

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (isValid(grid, newX, newY) && grid[newX][newY] > 0) {
                dfs(grid, newX, newY, currentGold);
            }
        }

        grid[x][y] = originalGold;
    }

    private boolean isValid(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}

public class Day14 {
    public static void main(String[] args) {
        MaximumGold solution = new MaximumGold();

        // Test case 1
        int[][] grid1 = {
                {0, 6, 0},
                {5, 8, 7},
                {0, 9, 0}
        };
        System.out.println("Test Case 1: " + solution.getMaximumGold(grid1));  // Expected output: 24

        // Test case 2
        int[][] grid2 = {
                {1, 0, 7},
                {2, 0, 6},
                {3, 4, 5},
                {0, 3, 0},
                {9, 0, 20}
        };
        System.out.println("Test Case 2: " + solution.getMaximumGold(grid2));  // Expected output: 28

        // Additional test cases
        // Test case 3 - Single cell with gold
        int[][] grid3 = {
                {10}
        };
        System.out.println("Test Case 3: " + solution.getMaximumGold(grid3));  // Expected output: 10

        // Test case 4 - All cells are empty
        int[][] grid4 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        System.out.println("Test Case 4: " + solution.getMaximumGold(grid4));  // Expected output: 0

        // Test case 5 - Mixed grid with isolated gold cells
        int[][] grid5 = {
                {1, 0, 3},
                {0, 4, 0},
                {7, 0, 2}
        };
        System.out.println("Test Case 5: " + solution.getMaximumGold(grid5));  // Expected output: 7

        // Test case 6 - Larger grid with complex paths
        int[][] grid6 = {
                {1, 2, 3, 0, 6},
                {0, 0, 0, 0, 0},
                {7, 8, 9, 0, 5},
                {0, 0, 0, 0, 0},
                {4, 3, 2, 1, 0}
        };
        System.out.println("Test Case 6: " + solution.getMaximumGold(grid6));  // Expected output: 30
    }
}