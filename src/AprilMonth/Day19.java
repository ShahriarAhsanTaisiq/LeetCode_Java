package AprilMonth;
/*
200. Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */
class Island {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        int island=0;
        int m=grid.length; // numbers of columns
        int n=grid[0].length; //number of rows

        //iterate through each cell of the grid
        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    island++;
                    dfs(grid,i,j);
                }
            }
        }
        return island;
    }

    void dfs(char[][] grid,int i, int j){
        int m=grid.length;
        int n=grid[0].length;

        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]=='0'){
            return;
        }

        grid[i][j]='0'; //mark the cell visited

        //check the adjacent
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
public class Day19 {
    public static void main(String[] args) {
        // Test cases
        char[][] grid1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        Island solution = new Island();

        System.out.println("Number of islands in grid1: " + solution.numIslands(grid1)); // Output: 1
        System.out.println("Number of islands in grid2: " + solution.numIslands(grid2)); // Output: 3
    }
}
