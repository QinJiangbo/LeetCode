package SudokuSolver;

/**
 * @date: 30/11/2017 4:39 PM
 * @author: qinjiangbo@github.io
 * @description:
 *      Write a program to solve a Sudoku puzzle by filling the empty cells.
        Empty cells are indicated by the character '.'.
        You may assume that there will be only one unique solution.
 */
public class Solution {

    /**
     * 解数独问题
     * @param board
     */
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    /**
     * 回溯法解数独问题
     * @param board
     * @return
     */
    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValidSudoku(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    // 1-9全部试过，都不行，说明这条线失败，直接返回false
                    // 这里需要加一个判断减少回溯深度，否则会报Time Limit Exceed错误
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断数独是否合法，只需要判断这一个点添加以后是否合法
     * @param board
     * @param row
     * @param col
     * @param c
     * @return
     */
    private boolean isValidSudoku(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) {
                return false; // 检查每一行
            }
            if(board[row][i] != '.' && board[row][i] == c) {
                return false; // 检查每一列
            }
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false; // 检查 3*3 方块
            }
        }
        return true;
    }
}
