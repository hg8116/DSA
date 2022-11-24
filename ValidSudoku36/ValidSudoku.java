// https://leetcode.com/problems/valid-sudoku/

package ValidSudoku36;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set set = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char curr = board[i][j];
                if (curr == '.')
                    continue;
                if (!set.add(curr + " row " + i) ||
                        !set.add(curr + " col " + j) ||
                        !set.add(curr + " box " + i / 3 + j / 3))
                    return false;
            }
        }
        return true;
    }
}
