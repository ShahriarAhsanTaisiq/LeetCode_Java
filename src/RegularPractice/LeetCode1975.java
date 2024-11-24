package RegularPractice;

/* 1975. Maximum Matrix Sum
* You are given an n x n integer matrix. You can do the following operation any number of times:

Choose any two adjacent elements of matrix and multiply each of them by -1.
Two elements are considered adjacent if and only if they share a border.

Your goal is to maximize the summation of the matrix's elements. Return the maximum sum of the matrix's elements using the operation mentioned above.

Example 1:

Input: matrix = [[1,-1],[-1,1]]
Output: 4
Explanation: We can follow the following steps to reach sum equals 4:
- Multiply the 2 elements in the first row by -1.
- Multiply the 2 elements in the first column by -1.
Example 2:


Input: matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
Output: 16
Explanation: We can follow the following step to reach sum equals 16:
- Multiply the 2 last elements in the second row by -1.

Constraints:

n == matrix.length == matrix[i].length
2 <= n <= 250
-105 <= matrix[i][j] <= 105
* */

class MaximumMatrixSum{
    public long maxMatrixSum(int[][] matrix) {
        long max = 0;
        int neg = 0;
        int min = Integer.MAX_VALUE;

        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = Math.abs(matrix[i][j]);
                min = Math.min(min, val);
                max += val;

                if (matrix[i][j] < 0){
                    neg++;
                }
            }
        }
        if (neg % 2 == 0){
            return max;
        } else{
            return max - 2L * min;
        }
    }
}
public class LeetCode1975 {
    public static void main(String[] args) {
        MaximumMatrixSum mms = new MaximumMatrixSum();
        // Test case 1: Example 1
        int[][] matrix1 = {{1, -1}, {-1, 1}};
        System.out.println("Maximum matrix sum: " + mms.maxMatrixSum(matrix1)); // Expected: 4

        // Test case 2: Example 2
        int[][] matrix2 = {{1, 2, 3}, {-1, -2, -3}, {1, 2, 3}};
        System.out.println("Maximum matrix sum: " + mms.maxMatrixSum(matrix2)); // Expected: 16

        // Test case 3: Single negative value
        int[][] matrix3 = {{-1}};
        System.out.println("Maximum matrix sum: " + mms.maxMatrixSum(matrix3)); // Expected: 1

        // Test case 4: Mixed positive and negative values
        int[][] matrix4 = {{-1, 2, -3}, {4, -5, 6}, {-7, 8, -9}};
        System.out.println("Maximum matrix sum: " + mms.maxMatrixSum(matrix4)); // Expected: 45

        // Test case 5: All positive values
        int[][] matrix5 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Maximum matrix sum: " + mms.maxMatrixSum(matrix5)); // Expected: 45

        // Test case 6: All negative values
        int[][] matrix6 = {{-1, -2, -3}, {-4, -5, -6}, {-7, -8, -9}};
        System.out.println("Maximum matrix sum: " + mms.maxMatrixSum(matrix6)); // Expected: 45

        // Test case 7: Large numbers
        int[][] matrix7 = {{100000, -100000}, {-100000, 100000}};
        System.out.println("Maximum matrix sum: " + mms.maxMatrixSum(matrix7)); // Expected: 400000
    }
}
