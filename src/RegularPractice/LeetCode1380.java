package RegularPractice;

/*1380. Lucky Numbers in a Matrix
* Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
Example 1:
Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 2:
Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 3:
Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
Constraints:
m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 105.
All elements in the matrix are distinct.
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class LuckyNumber{
    public List<Integer> luckyNumbers(int [][] matrix){
        List<Integer> luckyNum = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        // Find the minimum element in each row along with its column index
        for (int i = 0; i<m ; i++){
            int min = matrix[i][0];
            int minColIndex = 0;
            for (int j = 1; j<n; j++){
                if (matrix[i][j] < min){
                    min = matrix[i][j];
                    minColIndex = j;
                }
            }
            // Check if this minimum element is the maximum in its column
            boolean isMax = true;
            for (int k = 0; k<m; k++){
                if (matrix[k][minColIndex] > min){
                    isMax = false;
                    break;
                }
            }
            if (isMax){
                luckyNum.add(min);
            }

        }
        return luckyNum;
    }
}
public class LeetCode1380 {
    public static void main(String[] args) {
        LuckyNumber luckyNumberFinder = new LuckyNumber();

        int[][] matrix1 = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        int[][] matrix2 = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        int[][] matrix3 = {{7, 8}, {1, 2}};

        List<Integer> result1 = luckyNumberFinder.luckyNumbers(matrix1);
        List<Integer> result2 = luckyNumberFinder.luckyNumbers(matrix2);
        List<Integer> result3 = luckyNumberFinder.luckyNumbers(matrix3);

        System.out.println("Lucky numbers in matrix1: " + result1);
        System.out.println("Lucky numbers in matrix2: " + result2);
        System.out.println("Lucky numbers in matrix2: " + result3);
    }

}
