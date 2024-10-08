package RegularPractice;

/* 2022. Convert 1D Array Into 2D Array
*You are given a 0-indexed 1-dimensional (1D) integer array original, and two integers, m and n. You are tasked with creating a 2-dimensional (2D) array with  m rows and n columns using all the elements from original.
The elements from indices 0 to n - 1 (inclusive) of original should form the first row of the constructed 2D array, the elements from indices n to 2 * n - 1 (inclusive) should form the second row of the constructed 2D array, and so on.
Return an m x n 2D array constructed according to the above procedure, or an empty 2D array if it is impossible.

Example 1:
Input: original = [1,2,3,4], m = 2, n = 2
Output: [[1,2],[3,4]]
Explanation: The constructed 2D array should contain 2 rows and 2 columns.
The first group of n=2 elements in original, [1,2], becomes the first row in the constructed 2D array.
The second group of n=2 elements in original, [3,4], becomes the second row in the constructed 2D array.

Example 2:
Input: original = [1,2,3], m = 1, n = 3
Output: [[1,2,3]]
Explanation: The constructed 2D array should contain 1 row and 3 columns.
Put all three elements in original into the first row of the constructed 2D array.

Example 3:
Input: original = [1,2], m = 1, n = 1
Output: []
Explanation: There are 2 elements in original.
It is impossible to fit 2 elements in a 1x1 2D array, so return an empty 2D array.
Constraints:
1 <= original.length <= 5 * 104
1 <= original[i] <= 105
1 <= m, n <= 4 * 104
* */
import java.util.Arrays;
class Convert1DTo2DArray{
   public int[][] construct2DArray( int [] original, int m, int n){
       if (m * n != original.length){
           return new int[0][0];
       }
       int [][] res = new int[m][n];
       int indx = 0;
       for (int i = 0; i < m; i++){
           for (int j = 0 ; j < n; j++){
               res [i][j] = original[indx++];
           }
       }
       return res;
   }
}
public class LeetCode2022 {
    public static void main(String[] args) {
        // Create an instance of the Convert1DTo2DArray class
        Convert1DTo2DArray converter = new Convert1DTo2DArray();

        // Test Case 1
        int[] original1 = {1, 2, 3, 4};
        int m1 = 2, n1 = 2;
        int[][] result1 = converter.construct2DArray(original1, m1, n1);
        System.out.println("Test Case 1: " + Arrays.deepToString(result1)); // Expected Output: [[1, 2], [3, 4]]

        // Test Case 2
        int[] original2 = {1, 2, 3};
        int m2 = 1, n2 = 3;
        int[][] result2 = converter.construct2DArray(original2, m2, n2);
        System.out.println("Test Case 2: " + Arrays.deepToString(result2)); // Expected Output: [[1, 2, 3]]

        // Test Case 3
        int[] original3 = {1, 2};
        int m3 = 1, n3 = 1;
        int[][] result3 = converter.construct2DArray(original3, m3, n3);
        System.out.println("Test Case 3: " + Arrays.deepToString(result3)); // Expected Output: []
    }
}
