package ValidSudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * @date: 29/11/2017 10:39 AM
 * @author: qinjiangbo@github.io
 * @description:
 *      Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
        The Sudoku board could be partially filled, where empty cells are filled with
        the character '.'.
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    String rowStr = "[" + i + "]" + board[i][j];
                    String colStr = board[i][j] + "[" + j + "]";
                    String boxStr = "[" + i/3 + "]" + board[i][j] + "[" + j/3 + "]";
                    if (!set.contains(rowStr) && !set.contains(colStr)
                            && !set.contains(boxStr)) {
                        set.add(rowStr);
                        set.add(colStr);
                        set.add(boxStr);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
