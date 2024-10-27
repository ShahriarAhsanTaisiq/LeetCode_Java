package RegularPractice;
/* 1277. Count Square Submatrices with All Ones
* Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation:
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix =
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation:
There are 6 squares of side 1.
There is 1 square of side 2.
Total number of squares = 6 + 1 = 7.


Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1

* */

class CountSquareSubMatrix{
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int [][] dp = new int [n+1][m+1];
        int ans = 0;

        for( int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 1){
                    dp[i+1][j+1] = 1 + Math.min(Math.min(dp[i][j+1], dp[i+1][j]),dp[i][j]);
                }
                ans +=dp[i+1][j+1];
            }
        }
        return ans;
    }
}
public class LeetCode1277 {
    public static void main(String[] args) {
        CountSquareSubMatrix solution = new CountSquareSubMatrix();

        // Test case 1
        int[][] matrix1 = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        System.out.println("Output for test case 1: " + solution.countSquares(matrix1)); // Expected output: 15

        // Test case 2
        int[][] matrix2 = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println("Output for test case 2: " + solution.countSquares(matrix2)); // Expected output: 7
    }
}
