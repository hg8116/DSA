// https://leetcode.com/problems/number-of-islands/

package NumberOfIslands200;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(i, j, grid); //bfs(i, j, grid);
                }
            }
        }
        return ans;
    }

    // Using DFS
    int[] drow = {-1, 0, +1, 0};
    int[] dcol = {0, -1, 0, +1};

    public void dfs(int i, int j, char[][] grid) {
        grid[i][j] = '0';
        for (int x = 0; x < 4; x++) {
            int nrow = i + drow[x];
            int ncol = j + dcol[x];
            if (nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && grid[nrow][ncol] == '1') {
                grid[nrow][ncol] = '0';
                dfs(nrow, ncol, grid);
            }
        }
    }

    // Using BFS
    public void bfs(int i, int j, char[][] grid) {
        grid[i][j] = '0';
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            for (int x = 0; x < 4; x++) {
                int nrow = r + drow[x];
                int ncol = r + dcol[x];
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && grid[nrow][ncol] == '1') {
                    q.add(new int[]{nrow, ncol});
                    grid[nrow][ncol] = '0';
                }
            }
        }
    }
}