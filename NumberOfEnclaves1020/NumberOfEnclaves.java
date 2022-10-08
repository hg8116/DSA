// https://leetcode.com/problems/number-of-enclaves/

package NumberOfEnclaves1020;

public class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isBorder(i, j, n, m) && grid[i][j] == 1)
                    dfs(i, j, grid);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    ans++;
            }
        }

        return ans;
    }

    int[] drow = {-1, 0, +1, 0};
    int[] dcol = {0, -1, 0, +1};

    void dfs(int i, int j, int[][] grid) {
        grid[i][j] = 2;
        for (int x = 0; x < 4; x++) {
            int nrow = i + drow[x];
            int ncol = j + dcol[x];
            if (nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && grid[nrow][ncol] == 1)
                dfs(nrow, ncol, grid);
        }
    }

    boolean isBorder(int i, int j, int n, int m) {
        if (i != 0 && i < n - 1 && j != 0 && j < m - 1)
            return false;
        return true;
    }
}
