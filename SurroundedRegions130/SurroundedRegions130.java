// https://leetcode.com/problems/surrounded-regions/

package SurroundedRegions130;

public class SurroundedRegions130 {
    boolean isBorder(int i, int j, int n, int m) {
        if (i != 0 && i < n - 1 && j != 0 && j < m - 1)
            return false;
        return true;
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int i = 0, j = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (isBorder(i, j, n, m) && board[i][j] == 'O')
                    dfs(i, j, board);
            }
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'Z')
                    board[i][j] = 'O';
            }
        }
    }

    int[] drow = {-1, 0, +1, 0};
    int[] dcol = {0, -1, 0, +1};

    void dfs(int i, int j, char[][] board) {
        board[i][j] = 'Z';
        for (int x = 0; x < 4; x++) {
            int nrow = i + drow[x];
            int ncol = j + dcol[x];
            if (nrow >= 0 && ncol >= 0 && nrow < board.length && ncol < board[0].length && board[nrow][ncol] == 'O')
                dfs(nrow, ncol, board);
        }
    }
}
