package RegularPractice;

/*37. Sudoku Solver
* Write a program to solve a Sudoku puzzle by filling the empty cells.
A sudoku solution must satisfy all of the following rules:
Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

Example 1:
Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:
Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.
* */

class SudokuSolver {
    boolean isSafe(char[][]board,int row,int col,int num){
        //check column
        for(int i=0;i<board.length;i++){
            if(board[i][col]==(char)(num+'0')){
                return false;
            }
        }
        //check row
        for(int i=0;i<board.length;i++){
            if(board[row][i]==(char)(num+'0')){
                return false;
            }
        }
        //check grid
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j]==(char)(num+'0')){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean helper(char[][] board, int row, int col) {
        if(row == board.length) {
            return true;
        }
        int nrow = 0;
        int ncol = 0;

        if(col == board.length-1) {
            nrow = row + 1;
            ncol = 0;
        } else {
            nrow = row;
            ncol = col + 1;
        }

        if(board[row][col] != '.') {
            if(helper(board, nrow, ncol)) {
                return true;
            }
        } else {

            //fill the place
            for(int i=1; i<=9; i++) {
                if(isSafe(board, row, col, i)) {
                    board[row][col] = (char)(i+'0');
                    if(helper(board, nrow, ncol))
                        return true;
                    else
                        board[row][col] = '.';
                }
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
}
public class LeetCode37 {
    public static void main(String[] args) {
        char[][] board = {
                {'6', '1', '.', '.', '4', '2', '5', '.', '8'},
                {'.', '3', '2', '.', '1', '.', '.', '.', '.'},
                {'.', '.', '5', '7', '.', '6', '.', '.', '1'},
                {'5', '.', '8', '1', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '5', '.', '8', '.', '.', '4'},
                {'.', '.', '.', '.', '.', '3', '8', '.', '7'},
                {'7', '.', '.', '4', '.', '9', '6', '.', '.'},
                {'.', '.', '.', '.', '8', '.', '4', '7', '.'},
                {'4', '.', '3', '2', '5', '.', '.', '8', '9'}
        };

        SudokuSolver solver = new SudokuSolver();
        solver.solveSudoku(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
