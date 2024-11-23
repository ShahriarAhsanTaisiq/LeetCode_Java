package RegularPractice;

/*  1861. Rotating the Box
* You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:
A stone '#'
A stationary obstacle '*'
Empty '.'
The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.
It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.
Return an n x m matrix representing the box after the rotation described above.

Example 1:

Input: box = [["#",".","#"]]
Output: [["."],
         ["#"],
         ["#"]]
Example 2:

Input: box = [["#",".","*","."],
              ["#","#","*","."]]
Output: [["#","."],
         ["#","#"],
         ["*","*"],
         [".","."]]
Example 3:

Input: box = [["#","#","*",".","*","."],
              ["#","#","#","*",".","."],
              ["#","#","#",".","#","."]]
Output: [[".","#","#"],
         [".","#","#"],
         ["#","#","*"],
         ["#","*","."],
         ["#",".","*"],
         ["#",".","."]]


Constraints:

m == box.length
n == box[i].length
1 <= m, n <= 500
box[i][j] is either '#', '*', or '.'.
* */

import java.util.Arrays;

class RotatingTheBox{
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        for (int i = 0; i < m; i++) {
            int emptyIndex = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    emptyIndex = j - 1;
                } else if (box[i][j] == '#'){
                    box[i][j] = '.';
                    box[i][emptyIndex] = '#';
                    emptyIndex--;
                }
            }
        }
        char[][] res = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][m - i - 1] = box[i][j];
            }
        }
        return res;
    }
}
public class LeetCode1861 {
    public static void main(String[] args) {
        RotatingTheBox rotatingTheBox = new RotatingTheBox();
        // Example 1
        char[][] box1 = { {'#', '.', '#'} };
        char[][] result1 = rotatingTheBox.rotateTheBox(box1);
        System.out.println("Example 1 Output:");
        printMatrix(result1);

        // Example 2
        char[][] box2 = {
                {'#', '.', '*', '.'},
                {'#', '#', '*', '.'}
        };
        char[][] result2 = rotatingTheBox.rotateTheBox(box2);
        System.out.println("Example 2 Output:");
        printMatrix(result2);

        // Example 3
        char[][] box3 = {
                {'#', '#', '*', '.', '*', '.'},
                {'#', '#', '#', '*', '.', '.'},
                {'#', '#', '#', '.', '#', '.'}
        };
        char[][] result3 = rotatingTheBox.rotateTheBox(box3);
        System.out.println("Example 3 Output:");
        printMatrix(result3);
    }

    // Utility method to print the matrix
    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
