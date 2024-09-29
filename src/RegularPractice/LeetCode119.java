package RegularPractice;

/* 119. Pascal's Triangle II
* Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
Example 1:
Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:
Input: rowIndex = 0
Output: [1]
Example 3:
Input: rowIndex = 1
Output: [1,1]
Constraints:
0 <= rowIndex <= 33
Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
* */

import java.util.ArrayList;
import java.util.List;

class PascalTriangleII{
    public List<Integer> getRow( int rowIndex){
        List<Integer> row = new ArrayList<>();
        long comb = 1;
        for (int i = 0; i <= rowIndex; i++){
            row.add((int) comb);
            comb = comb * ( rowIndex - i) / (i+1);
        }
        return row;
    }
}
public class LeetCode119 {
    public static void main(String[] args) {
        PascalTriangleII pascalTriangle = new PascalTriangleII();

        // Test case 1: rowIndex = 3
        int rowIndex1 = 3;
        List<Integer> row1 = pascalTriangle.getRow(rowIndex1);
        System.out.println("Row " + rowIndex1 + ": " + row1);

        // Test case 2: rowIndex = 0
        int rowIndex2 = 0;
        List<Integer> row2 = pascalTriangle.getRow(rowIndex2);
        System.out.println("Row " + rowIndex2 + ": " + row2);

        // Test case 3: rowIndex = 1
        int rowIndex3 = 1;
        List<Integer> row3 = pascalTriangle.getRow(rowIndex3);
        System.out.println("Row " + rowIndex3 + ": " + row3);

    }
}
