package AprilMonth;

/* 1992: Find all Group of farmland

You are given a 0-indexed m x n binary matrix land where a 0 represents a hectare of forested land and a 1 represents a hectare of farmland.
To keep the land organized, there are designated rectangular areas of hectares that consist entirely of farmland. These rectangular areas are called groups. No two groups are adjacent, meaning farmland in one group is not four-directionally adjacent to another farmland in a different group.
land can be represented by a coordinate system where the top left corner of land is (0, 0) and the bottom right corner of land is (m-1, n-1). Find the coordinates of the top left and bottom right corner of each group of farmland. A group of farmland with a top left corner at (r1, c1) and a bottom right corner at (r2, c2) is represented by the 4-length array [r1, c1, r2, c2].
Return a 2D array containing the 4-length arrays described above for each group of farmland in land. If there are no groups of farmland, return an empty array. You may return the answer in any order.

Example 1:
Input: land = [[1,0,0],[0,1,1],[0,1,1]]
Output: [[0,0,0,0],[1,1,2,2]]
Explanation:
The first group has a top left corner at land[0][0] and a bottom right corner at land[0][0].
The second group has a top left corner at land[1][1] and a bottom right corner at land[2][2].
Example 2:
Input: land = [[1,1],[1,1]]
Output: [[0,0,1,1]]
Explanation:
The first group has a top left corner at land[0][0] and a bottom right corner at land[1][1].
Example 3:
Input: land = [[0]]
Output: []
Explanation:
There are no groups of farmland.

Constraints:
m == land.length
n == land[i].length
1 <= m, n <= 300
land consists of only 0's and 1's.
Groups of farmland are rectangular in shape.
*/

import java.util.*;
public class Day20 {
    public static void main(String[] args) {
        // Example matrices
        int[][] land1 = {
                {1, 0, 0},
                {0, 1, 1},
                {0, 1, 1}
        };

        int[][] land2 = {
                {1, 1},
                {1, 1}
        };

        int[][] land3 = {
                {0}
        };

        // Instantiate the Solution class
        Solution solution = new Solution();

        // Test cases
        int[][] result1 = solution.findFarmland(land1);
        int[][] result2 = solution.findFarmland(land2);
        int[][] result3 = solution.findFarmland(land3);

        // Print results
        System.out.println("Result 1:");
        printResult(result1);

        System.out.println("\nResult 2:");
        printResult(result2);

        System.out.println("\nResult 3:");
        printResult(result3);
    }

    // Helper method to print the result
    private static void printResult(int[][] result) {
        for (int[] group : result) {
            System.out.println(Arrays.toString(group));
        }
    }
}
class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<int[]> result = new ArrayList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(land[i][j]==1){
                    int r2=i, c2=j;

                    while(r2<m && land[r2][j]==1){
                        c2=j;
                        while(c2<n && land[r2][c2]==1){
                            c2++;
                        }
                        r2++;
                    }
                    r2--;
                    c2--;
                    result.add(new int[]{i,j,r2,c2});

                    // mark visited to 0
                    for(int x=i; x<=r2; x++){
                        for(int y=j; y<=c2; y++){
                            land[x][y]=0;
                        }
                    }
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
